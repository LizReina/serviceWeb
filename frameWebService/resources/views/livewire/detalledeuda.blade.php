<div>
   
    <h6>Fecha Prestamo </h6>
    <p class="lead"> 14/05/2022 </p>
    <h6>Fecha Finalizacion Prestamo </h6>
    <p class="lead"> 14/06/2022 </p>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th scope="col" width="5%">Concepto Deuda</th>
                <th scope="col" width="20%">Monto</th>

            </tr>
        </thead>
        <tbody>
        @foreach ($detalles as $d)
            <tr>
            <td>{{$d->conceptodeuda->descripcion}}</td>
            <td>{{$d->monto}}</td>  
            </tr>
        @endforeach
        </tbody>
    </table>


</div>