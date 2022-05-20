package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearUsuario extends Command {

    private Fecha fechaDeCreacion;

    public CrearUsuario(Fecha fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
