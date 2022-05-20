package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.sofka.domain.generic.Command;

public class CrearUsuario extends Command {

    private FechaDeCreacion fechaDeCreacion;

    public CrearUsuario(FechaDeCreacion fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public FechaDeCreacion getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
