<?php

namespace App\Http\Livewire;

use Livewire\Component;
use Illuminate\Support\Facades\Http;
use WithPagination;
class SearchPosts extends Component
{  
    public $cliente = "NONE";
    public $dataclient;
    public $search="";
    public $cliente_id;
 
    protected $queryString = ['search'];
 
    public function render()
    {   
   // echo 'aqui: '.'http://localhost:8080/cliente/views/'.$this->search;
  
        return view('livewire.search-posts');
       // $searchTerm = '%'.$this->searchTerm.'%';
 
      /*   return view('livewire.search-pagination',[
            'employees' => Employee::where('name','like', $searchTerm)->paginate(10)
        ]); */
    }
    public function search(){
        $this->emitTo('deuda', 'updateDeuda',$this->cliente_id); 
        $this->dispatchBrowserEvent('collection');
        
    }
}
