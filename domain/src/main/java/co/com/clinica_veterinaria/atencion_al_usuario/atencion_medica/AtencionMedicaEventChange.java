package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.EventChange;

import java.time.LocalDate;

public class AtencionMedicaEventChange extends EventChange {
    public AtencionMedicaEventChange(AtencionMedica atencionMedica) {
        apply((AtencionCreada event)->{
            atencionMedica.fechaDeAtencion=event.getFechaDeAtencion();
            atencionMedica.tipoDeAtencion=event.getTipoDeAtencion();
            atencionMedica.estado=new Estado(Estado.Estados.POR_INICIAR);
            atencionMedica.proximaCita=new Fecha(LocalDate.parse("1900-01-01"));
            atencionMedica.fechaDeFinalizacion=new Fecha(LocalDate.parse("1900-01-01"));
            atencionMedica.usuarioId=event.getUsuarioId();
        });

        apply((AtencionFinalizada event)->{
            atencionMedica.proximaCita=event.getProximaCita();
            atencionMedica.estado=new Estado(Estado.Estados.FINALIZADO);
        });

        apply((FechaDeFinalizacionPrestacionDeServicioActualizada event)->{
            atencionMedica.fechaDeFinalizacion=event.getFechaDeFinalizacion();
        });

        apply((MedicoAgregado event)->{
            atencionMedica.medico.nombreCompleto=event.getNombreCompleto();
            atencionMedica.medico.datosDeContacto=event.getDatosDeContacto();
            atencionMedica.medico.fechaDeNacimiento=event.getFechaDeNacimiento();
        });

        apply((AtencionDeUrgenciasGenerada event)->{
            atencionMedica.urgencia = new Urgencia(event.getUrgenciaId(), event.getObservacion(), event.getTriage());
        });

        apply((AtencionDeCitaProgramadaGenerada event)->{
            atencionMedica.citaProgramada = new CitaProgramada(event.getCitaId(), event.getObservacion(), event.getFechaCita());
        });

        apply((FechaDeCitaProgramadaActualizada event)->{
            atencionMedica.citaProgramada.fechaCita=event.getFechaCita();
        });

        apply((NombreDeMedicoActualizado event)->{
            atencionMedica.medico.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((ObservacionDeUrgenciaActualizada event)->{
            atencionMedica.urgencia.actualizarObservacion(event.getObservacion());
        });

        apply((EstadoDeAtencionActualizado event)->{
            atencionMedica.actualizarEstadoDeAtencion(event.getEstado());
        });

    }
}
