package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeHospitalizacionActualizado extends DomainEvent {
    private final HospitalizacionId hospitalizacionId;
    private final EstadoDeHospitalizacion estadoDeHospitalizacion;

    public EstadoDeHospitalizacionActualizado(HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.EstadoDeHospitalizacionActualizado");
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
