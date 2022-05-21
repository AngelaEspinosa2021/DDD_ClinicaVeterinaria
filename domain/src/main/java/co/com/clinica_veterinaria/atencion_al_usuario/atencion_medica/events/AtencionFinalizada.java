package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;


import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionFinalizada extends DomainEvent {
    private final UsuarioId usuarioId;
    private final Fecha proximaCita;

    public AtencionFinalizada(UsuarioId usuarioId, Fecha proximaCita) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionFinalizada");
        this.usuarioId = usuarioId;
        this.proximaCita = proximaCita;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Fecha getProximaCita() {
        return proximaCita;
    }
}
