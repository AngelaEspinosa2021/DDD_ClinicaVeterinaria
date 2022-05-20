package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.InformacionDeMedico;
import co.com.sofka.domain.generic.Command;

public class AsociarMedicoAHistoriaMedica extends Command {

    private final HistoriaMedicaId historiaMedicaId;
    private final InformacionDeMedico informacionDeMedico;

    public AsociarMedicoAHistoriaMedica(HistoriaMedicaId historiaMedicaId, InformacionDeMedico informacionDeMedico) {
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
