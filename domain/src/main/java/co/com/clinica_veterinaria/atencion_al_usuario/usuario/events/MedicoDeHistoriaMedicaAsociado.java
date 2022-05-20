package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.InformacionDeMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicoDeHistoriaMedicaAsociado extends DomainEvent {
    private final HistoriaMedicaId historiaMedicaId;
    private final InformacionDeMedico informacionDeMedico;

    public MedicoDeHistoriaMedicaAsociado(HistoriaMedicaId historiaMedicaId, InformacionDeMedico informacionDeMedico) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.MedicoDeHistoriaMedicaAsociado");
        this.historiaMedicaId = historiaMedicaId;
        this.informacionDeMedico = informacionDeMedico;
    }

    public HistoriaMedicaId getHistoriaMedicaId() {
        return historiaMedicaId;
    }

    public InformacionDeMedico getInformacionDeMedico() {
        return informacionDeMedico;
    }
}
