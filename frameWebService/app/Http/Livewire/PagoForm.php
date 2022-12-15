<?php

namespace App\Http\Livewire;

use Livewire\Component;
use Illuminate\Support\Facades\Http;
class PagoForm extends Component
{
    public $direccion="Totai";

    protected $listeners = ['refreshDeuda' =>  '$refresh','addPago'=>'addPago'];
    
    public function render()
    {
        return view('livewire.pago-form');
    }

    public function addPago($id,$monto){
        $responseDeuda = Http::post('http://localhost:8080/pago/add', [
            "descripcion"=> "silla",
            "direccion"=> $this->direccion,
            "fechaVencimiento"=>"2022-11-15",
            "monto"=>$monto,
            "deuda"=> ["id"=> $id]

        ]);

       
    }
}
