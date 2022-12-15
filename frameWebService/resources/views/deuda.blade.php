<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>NzCoding - Laravel LivewireCRUD</title>


    {{-- Bootstrap Styles --}}
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">


    @livewireStyles
</head>

<body>
    <div>
        <div class="container mt-5">
            <div class="row mb-5">
                <div class="col-md-12 text-center">
                    <h3><strong> Clientes con Deudas</strong></h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h5 style="float: left;"><strong>All Students</strong></h5>
                            <button class="btn btn-sm btn-primary" style="float: right;" data-toggle="modal"
                                data-target="#addStudentModal">Add New Student</button>
                        </div>
                        <div class="card-body">
                            @if (session()->has('message'))
                            <div class="alert alert-success text-center">{{ session('message') }}</div>
                            @endif


                            <div class="row mb-3">
                                <div class="col-md-12">
                                    <input type="search" class="form-control w-25" placeholder="search"
                                        wire:model="searchTerm" style="float: right;" />
                                </div>
                            </div>


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

                                    @foreach ($deudaArray as $deuda)
                                    <tr>
                                        <td>{{$deuda->cliente->id}}</td>
                                        <td>{{$deuda->fechaCreacion}}</td>
                                        <td>{{$deuda->fechaVencimiento}}</td>
                                        <td>{{$deuda->total}}</td>
                                        <td>{{$deuda->cliente->nombre}}</td>
                                        <td style="text-align: center;">
                                            <!-- Button trigger modal -->
                                            <button type="button" class="btn btn-sm btn-secondary" data-toggle="modal"
                                                data-target="#exampleModalCenter">
                                                ver
                                            </button>
                                            <button wire:click="showDetalle" type="button" id="my-modal" class="btn btn-sm btn-secondary" data-toggle="modal"
                                                data-target="">
                                                Info
                                            </button>

                                            <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                                                data-target="#exampleModalPago">
                                                pagar
                                            </button>

                                        </td>
                                    </tr>
                                    @endforeach

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>

    <script type='text/javascript'>
        document.getElementById("my-modal").addEventListener("click", function(){ 
            var userid = $(this).data('id');

            // AJAX request
            $.ajax({
                url: 'http://localhost:8080/detalledeuda/views',
                type: 'get',
             
               // data: {userid: userid},
                success: function(response){ 
                    // Add response in Modal body
                    $('.modal-body').html(response); 

                    // Display Modal
                    $('#exampleModalCenter').modal('show'); 
                }
            });


           
        });
    </script>



</body>

</html>