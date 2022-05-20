package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class AgregarObservacionAHistoriaMedica extends Command {

    private final HistoriaMedicaId historiaMedicaId;
    private final Observacion observacion;

    public AgregarObservacionAHistoriaMedica(HistoriaMedicaId historiaMedicaId, Observacion observacion) {
        this.historiaMedicaId = historiaMedicaId;
        this.observacion = observacion;
    }

    public HistoriaMedicaId getHistoriaMedicaId() {
        return historiaMedicaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
