package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class HospitalizacionSolicitada extends DomainEvent {
    private final HospitalizacionId hospitalizacionId;
    private final EstadoDeHospitalizacion estadoDeHospitalizacion;
    private final FechaDeIngreso fechaDeIngreso;

    public HospitalizacionSolicitada(HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion, FechaDeIngreso fechaDeIngreso) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.HospitalizacionSolicitada");
        this.hospitalizacionId = hospitalizacionId;
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public EstadoDeHospitalizacion getEstadoDeHospitalizacion() {
        return estadoDeHospitalizacion;
    }

    public FechaDeIngreso getFechaDeIngreso() {
        return fechaDeIngreso;
    }
}
