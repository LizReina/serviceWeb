<div class="container -my-5" style=" margin-top: 20px">


    <div class="row">
        <div class="col-md-12">
            <div class="card h">
                <div class="card-header">
                    <h5 style="float: left;"><strong>
                        </strong>
                    </h5>

                </div>
                <div class="card-body">

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col" width="5%">ID</th>
                                <th scope="col" width="20%">fecha creacion</th>
                                <th scope="col" width="10%">fecha vencimiento</th>
                                <th scope="col" width="20%">total</th>
                                <th scope="col" width="20%">cliente</th>
                                <th style="text-align: center;">Action</th>
                            </tr>
                        </thead>
                        <tbody>

                            @foreach ($deudas as $deuda)
                            <tr>
                                <td>{{$deuda->cliente->id}}</td>
                                <td>{{$deuda->fechaCreacion}}</td>
                                <td>{{$deuda->fechaVencimiento}}</td>
                                <td>{{$deuda->total}}</td>
                                <td>{{$deuda->cliente->nombre}}</td>
                                <td style="text-align: center;">
                                    <!-- Button trigger modal -->

                                    <div class="card-body">
                                        <button type="button" class="btn btn-primary my-modal" data-toggle="modal"
                                            wire:click="$emitTo('detalledeuda', 'showDetalle','{{$deuda->id}}')">
                                            ver Deuda
                                        </button>
                                    </div>

                                  <!--   <button type="button" id="my-modal-pago" class="btn btn-sm btn-secondary"
                                        data-toggle="modal" data-target="">
                                        Info
                                    </button> -->
                                    <button pago-id="{{$deuda->id}}" type="button" class="btn btn-sm btn-primary button-pago" data-toggle="modal"
                                        data-target="#exampleModalPago1"
                                        
                                        wire:click="$emitTo('pago-form', 'addPago','{{$deuda->id}}','{{$deuda->total}}')">
                                        pagar
                                    </button>

                                </td>
                            </tr>
                            @endforeach

                        </tbody>
                    </table>

                    <div wire:ignore.self class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Detalle de Deuda  </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true close-btn">×</span>
                                    </button>
                                </div>

                                <div class="modal-body">
                                    @livewire('detalledeuda')
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary close-btn"
                                        data-dismiss="modal">Close</button>

                                </div>
                            </div>
                        </div>
                    </div>


                    <div wire:ignore.self class="modal fade" id="exampleModalPago" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Detalle de Deuda
                                        de
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true close-btn">×</span>
                                    </button>
                                </div>

                                <div class="modal-body">
                                   @livewire('pago-form')
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary close-btn"
                                        data-dismiss="modal">Close</button>
                                        
                                        <button type="button" class="btn btn-primary "
                                        data-dismiss="modal"
                                        wire:click="$emitTo('pago-form', 'addPago',)">pagar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type='text/javascript'>
window.addEventListener('showDialogo', event => {
    $('#exampleModal').modal('show');

    
});

collection = document.querySelectorAll('.button-pago');
    console.log(collection);
window.addEventListener('collection', event => {
    
     collection = document.querySelectorAll('.button-pago');
    console.log(collection);
    collection.forEach(el => el.addEventListener('click', event => {
        console.log("Hi")//event.target.getAttribute("data-el"));
    }));

});


</script>