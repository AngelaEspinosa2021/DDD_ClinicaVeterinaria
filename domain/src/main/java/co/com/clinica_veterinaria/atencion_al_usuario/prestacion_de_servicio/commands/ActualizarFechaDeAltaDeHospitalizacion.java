package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeAltaDeHospitalizacion extends Command {
    private final HospitalizacionId hospitalizacionId;
    private final Fecha fechaDeAlta;

    public ActualizarFechaDeAltaDeHospitalizacion(HospitalizacionId hospitalizacionId, Fecha fechaDeAlta) {
        this.hospitalizacionId = hospitalizacionId;
        this.fechaDeAlta = fechaDeAlta;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public Fecha getFechaDeAlta() {
        return fechaDeAlta;
    }
}
