package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeAltaDeHospitalizacionActualizada extends DomainEvent {
    private final HospitalizacionId hospitalizacionId;
    private final Fecha fechaDeAlta;

    public FechaDeAltaDeHospitalizacionActualizada(HospitalizacionId hospitalizacionId, Fecha fechaDeAlta) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeAltaDeHospitalizacionActualizada");
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
