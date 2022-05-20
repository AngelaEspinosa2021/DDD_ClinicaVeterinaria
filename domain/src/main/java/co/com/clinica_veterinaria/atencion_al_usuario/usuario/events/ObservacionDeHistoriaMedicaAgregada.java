package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ObservacionDeHistoriaMedicaAgregada extends DomainEvent {
    private HistoriaMedicaId historiaMedicaId;
    private Observacion observacion;

    public ObservacionDeHistoriaMedicaAgregada(HistoriaMedicaId historiaMedicaId, Observacion observacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ObservacionDeHistoriaMedicaAgregada");
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
