<div>

<div class="container">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <h4 class="h1 alert alert-success">
                Buscar Usuario
            </h4>

            <!-- <input type="text" class="form-control" placeholder="Search" wire:model="search" /> -->
            <div class="input-group">
                <input type="search" wire:model.defer="cliente_id" class="form-control rounded" placeholder="Search"
                    wire:model="search" aria-label="Search" aria-describedby="search-addon" />
                <button wire:click="search" type="button" class="btn btn-outline-primary">search</button>
            </div>

         <!--    <input type="text" wire:model.defer="cliente_id">
            <button wire:click="search">Search</button> -->

        </div>

    </div>
</div>
        @livewire('deuda','render')
</div>
