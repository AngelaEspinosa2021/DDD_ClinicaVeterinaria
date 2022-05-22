package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class AgregarObservacionDeHospitalizacion extends Command {
    private final ServicioId servicioId;
    private final HospitalizacionId hospitalizacionId;
    private final Observacion observacion;

    public AgregarObservacionDeHospitalizacion(ServicioId servicioId, HospitalizacionId hospitalizacionId, Observacion observacion) {
        this.servicioId = servicioId;
        this.hospitalizacionId = hospitalizacionId;
        this.observacion = observacion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
