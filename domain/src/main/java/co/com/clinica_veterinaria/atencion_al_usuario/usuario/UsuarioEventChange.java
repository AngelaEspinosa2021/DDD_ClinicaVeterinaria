package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class UsuarioEventChange extends EventChange {
    public UsuarioEventChange(Usuario usuario) {
        apply((UsuarioCreado event)->{
            usuario.fechaDeCreacion=event.getFechaDeCreacion();
            usuario.historiasMedicas= new HashSet<>();
        });

        apply((PacienteCreado event)->{
            usuario.paciente= new Paciente(event.getPacienteId(),event.getNombreCompleto(),event.getFechaDeNacimiento());
        });

        apply((DueñoCreado event)->{
           usuario.dueño = new Dueño(event.getDueñoId(), event.getNombreCompleto(), event.getDatosDeContacto(), event.getFechaDeNacimiento());
        });

        apply((HistoriaMedicaCreada event)->{
            var funcion = usuario.getHistoriaMedicaById(event.getHistoriaMedicaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de historia medcia"));
            usuario.historiasMedicas.add(new HistoriaMedica(
               event.getHistoriaMedicaId(),
               event.getFecha(),
               event.getDescripcion()
            ));
        });

        apply((NombreCompletoDeDueñoActualizado event)->{
           usuario.dueño.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((DatosDeContactoDeDueñoActualizados event)->{
           usuario.dueño.actualizarDatosDeContacto(event.getDatosDeContacto());
        });

        apply((NombreCompletoPacienteActualizado event)->{
            usuario.paciente.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((MedicoDeHistoriaMedicaAsociado event)-> {
            var funcion = usuario.getHistoriaMedicaById(event.getHistoriaMedicaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de historia medcia"));
            funcion.asociarMedico(event.getInformacionDeMedico());
        });

        apply((ObservacionDeHistoriaMedicaAgregada event)-> {
            var funcion = usuario.getHistoriaMedicaById(event.getHistoriaMedicaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de historia medcia"));
            funcion.agregarObservacion(event.getObservacion());
        });

        apply((DescripcionDeHistoriaMedicaActualizada event)->{
            var funcion = usuario.getHistoriaMedicaById(event.getHistoriaMedicaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de historia medcia"));
            funcion.actualizarDescripcion(event.getDescripcion());
        });

    }
}
