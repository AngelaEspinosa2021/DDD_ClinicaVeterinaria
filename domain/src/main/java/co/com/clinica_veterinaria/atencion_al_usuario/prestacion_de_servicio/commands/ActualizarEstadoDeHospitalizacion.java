package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeHospitalizacion extends Command {
    private final HospitalizacionId hospitalizacionId;
    private final EstadoDeHospitalizacion estadoDeHospitalizacion;

    public ActualizarEstadoDeHospitalizacion(HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion) {
        this.hospitalizacionId = hospitalizacionId;
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public EstadoDeHospitalizacion getEstadoDeHospitalizacion() {
        return estadoDeHospitalizacion;
    }
}
