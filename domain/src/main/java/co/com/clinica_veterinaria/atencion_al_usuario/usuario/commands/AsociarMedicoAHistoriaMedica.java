package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.InformacionDeMedico;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.Command;

public class AsociarMedicoAHistoriaMedica extends Command {
    private final UsuarioId usuarioId;
    private final HistoriaMedicaId historiaMedicaId;
    private final InformacionDeMedico informacionDeMedico;

    public AsociarMedicoAHistoriaMedica(UsuarioId usuarioId, HistoriaMedicaId historiaMedicaId, InformacionDeMedico informacionDeMedico) {
        this.usuarioId = usuarioId;
        this.historiaMedicaId = historiaMedicaId;
        this.informacionDeMedico = informacionDeMedico;
    }

    public UsuarioId getUsuarioId() { return usuarioId;}

    public HistoriaMedicaId getHistoriaMedicaId() {
        return historiaMedicaId;
    }

    public InformacionDeMedico getInformacionDeMedico() {
        return informacionDeMedico;
    }
}
