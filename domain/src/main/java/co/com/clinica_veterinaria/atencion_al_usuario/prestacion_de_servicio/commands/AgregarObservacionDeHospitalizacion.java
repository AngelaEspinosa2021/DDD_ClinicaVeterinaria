package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class AgregarObservacionDeHospitalizacion extends Command {
    private final HospitalizacionId hospitalizacionId;
    private final Observacion observacion;

    public AgregarObservacionDeHospitalizacion(HospitalizacionId hospitalizacionId, Observacion observacion) {
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
