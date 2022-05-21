package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.EventChange;

import java.time.LocalDate;

public class UsuarioEventChange extends EventChange {
    public UsuarioEventChange(Usuario usuario) {
        apply((UsuarioCreado event)->{
            usuario.fechaDeCreacion=event.getFechaDeCreacion();
            usuario.proximaCita=new Fecha(LocalDate.parse("1900-01-01"));
        });

        apply((ProximaCitaAgendada event)->{
            usuario.proximaCita=event.getProximaCita();
        });

        apply((PacienteCreado event)->{
            usuario.paciente= new Paciente(event.getPacienteId(),event.getNombreCompleto(),event.getFechaDeNacimiento());
        });

        apply((DueñoCreado event)->{
           usuario.dueño = new Dueño(event.getDueñoId(), event.getNombreCompleto(), event.getDatosDeContacto(), event.getFechaDeNacimiento());
        });

        apply((HistoriaMedicaCreada event)->{
            usuario.historiaMedica = new HistoriaMedica(event.getHistoriaMedicaId(),event.getFecha(),event.getDescripcion());
        });

        apply((NombreCompletoDeDueñoActualizado event)->{
           usuario.dueño.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((NombreCompletoPacienteActualizado event)->{
            usuario.paciente.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((ObservacionDeHistoriaMedicaAgregada event)-> {
            usuario.historiaMedica.agregarObservacion(event.getObservacion());
        });

    }
}
