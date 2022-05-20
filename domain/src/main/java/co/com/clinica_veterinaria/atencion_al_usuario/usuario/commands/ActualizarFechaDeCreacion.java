package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeCreacion extends Command {

    private FechaDeCreacion fechaDeCreacion;

    public ActualizarFechaDeCreacion(FechaDeCreacion fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public FechaDeCreacion getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
