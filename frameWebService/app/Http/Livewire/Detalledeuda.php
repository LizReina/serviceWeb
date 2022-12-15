<?php

namespace App\Http\Livewire;

use Livewire\Component;
use Illuminate\Support\Facades\Http;
class Detalledeuda extends Component
{
    public $id_deuda=1;
    protected $listeners = ['refreshDeuda' =>  '$refresh','showDetalle'=>'showDetalle'];

    public function render()
    {   $detalles= array();
        if(!empty($this->id_deuda)){
            $responseDetalle = Http::get('http://localhost:8080/detalledeuda/viewsDetalle/'.$this->id_deuda);
            $detalles=json_decode($responseDetalle);
        }

        return view('livewire.detalledeuda',['detalles'=>$detalles]);
    }

    public function showDetalle($id){  
       $this->id_deuda=$id;
       $this->render();
       $this->dispatchBrowserEvent('showDialogo');
    }
}