package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.InformacionDeMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicoDeHistoriaMedicaAsociado extends DomainEvent {
    public MedicoDeHistoriaMedicaAsociado(HistoriaMedicaId historiaMedicaId, InformacionDeMedico informacionDeMedico) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.MedicoDeHistoriaMedicaAsociado");
    }
}
