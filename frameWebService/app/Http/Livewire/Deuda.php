<?php

namespace App\Http\Livewire;
use Illuminate\Support\Facades\Http;
use Livewire\Component;

class Deuda extends Component
{  public $deudaArray;
    public $cliente_id;
  
  
    protected $listeners = ['refreshDeuda' =>  '$refresh','updateDeuda'=>'showDeuda','pagarDeuda'=>'pagarDeuda'];
    public function render()
    {  
        $deudas= array();
      
       // dd('http://localhost:8080/deuda/viewsDeuda/'.$this->cliente_id);
        if(!empty($this->cliente_id)){
            $responseDeuda = Http::get('http://localhost:8080/deuda/viewsDeuda/'.$this->cliente_id);
            $deudas=json_decode($responseDeuda);
        
            // dd($deudas);

           // $responseDetalle = Http::get('http://localhost:8080/detalledeuda/views/'.$deudas->id);
           // $detalle=json_decode($responseDetalle);
           // dd($detalle);
        }

        return view('livewire.deuda',['deudas' => $deudas]);
    }

 
    public function showDeuda($id){  
        $this->cliente_id=$id;
        $this->render();
    }

    public function pagarDeuda($id){


    }
   
}