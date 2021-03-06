package co.com.clinica_veterinaria.atencion_al_usuario.usuario;


import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected Fecha fechaDeCreacion;
    protected Dueño dueño;
    protected Paciente paciente;
    protected HistoriaMedica historiaMedica;
    protected Fecha proximaCita;

    public Usuario(UsuarioId usuarioId, Fecha fechaDeCreacion){
        super(usuarioId);
        appendChange( new UsuarioCreado(fechaDeCreacion)).apply();
    }

    private Usuario(UsuarioId usurioId){
        super(usurioId);
        subscribe(new UsuarioEventChange(this));
    }

    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events){
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    public void agendarProximaCita(Fecha proximaCita){
        appendChange(new ProximaCitaAgendada(proximaCita)).apply();
    }

    public void agregarDueño(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento){
        appendChange(new DueñoCreado(dueñoId,nombreCompleto,datosDeContacto,fechaDeNacimiento)).apply();
    }

    public void agregarPaciente(PacienteId pacienteId, NombreCompleto nombreCompleto, Fecha fechaDeNacimiento){
        appendChange( new PacienteCreado(pacienteId,nombreCompleto,fechaDeNacimiento)).apply();
    }

    public void crearHistoriaMedica(HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion){
        appendChange( new HistoriaMedicaCreada(historiaMedicaId,fecha,descripcion));
    }

    public void actualizarNombreCompletoDePaciente(PacienteId pacienteId, NombreCompleto nombreCompleto){
        appendChange( new NombreCompletoPacienteActualizado(pacienteId,nombreCompleto)).apply();
    }

    public void actualizarNombreCompletoDeDueño(DueñoId dueñoId, NombreCompleto nombreCompleto){
        appendChange(new NombreCompletoDeDueñoActualizado(dueñoId,nombreCompleto)).apply();
    }

    public void agregarObservacionAHistoriaMedica(HistoriaMedicaId historiaMedicaId, Observacion observacion){
        appendChange(new ObservacionDeHistoriaMedicaAgregada(historiaMedicaId,observacion)).apply();
    }

}
