package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ObservacionDeHospitalizacionAgregada extends DomainEvent {
    private final HospitalizacionId hospitalizacionId;
    private final Observacion observacion;

    public ObservacionDeHospitalizacionAgregada(HospitalizacionId hospitalizacionId, Observacion observacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ObservacionDeHospitalizacionAgregada");
        this.hospitalizacionId = hospitalizacionId;
        this.observacion = observacion;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
