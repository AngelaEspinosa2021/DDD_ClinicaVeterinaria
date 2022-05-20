package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.HistoriaMedica;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.Usuario;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class AtencionMedicaEventChange extends EventChange {
    public AtencionMedicaEventChange(AtencionMedica atencionMedica) {
        apply((AtencionCreada event)->{
            atencionMedica.fechaDeAtencion=event.getFechaDeAtencion();
            atencionMedica.tipoDeAtencion=event.getTipoDeAtencion();
            atencionMedica.estado=event.getEstado();
        });

        apply((MedicoAgregado event)->{
            atencionMedica.medico.nombreCompleto=event.getNombreCompleto();
            atencionMedica.medico.datosDeContacto=event.getDatosDeContacto();
            atencionMedica.medico.fechaDeNacimiento=event.getFechaDeNacimiento();
        });

        apply((AtencionDeUrgenciaSolicitada event)->{
            atencionMedica.urgencia.observacion=event.getObservacion();
            atencionMedica.urgencia.triage=event.getTriage();
        });

        apply((AtencionDeCitaProgramadaSolicitada event)->{
            atencionMedica.citaProgramada.observacion=event.getObservacion();
            atencionMedica.citaProgramada.fechaCita=event.getFechaCita();
        });

        apply((DatosDeContactoDeMedicoActualizados event)->{
            atencionMedica.medico.datosDeContacto=event.getDatosDeContacto();
        });

        apply((FechaDeCitaProgramadaActualizada event)->{
            atencionMedica.citaProgramada.fechaCita=event.getFechaCita();
        });

        apply((ObservacionDeHistoriaMedicaDeUsuarioAgregada event)->{
            atencionMedica.usuario.agregarObservacionAHistoriaMedica(event.getHistoriaMedicaId(),event.getObservacion());
        });

        apply((NombreDeMedicoActualizado event)->{
            atencionMedica.medico.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((ObservacionDeUrgenciaActualizada event)->{
            atencionMedica.urgencia.actualizarObservacion(event.getObservacion());
        });

        apply((ObservacionesDeCitaProgramadaActualizada event)->{
            atencionMedica.citaProgramada.actualizarObservacion(event.getObservacion());
        });

        apply((EstadoDeAtencionActualizado event)->{
            atencionMedica.actualizarEstadoDeAtencion(event.getEstado());
        });

        apply((ServicioDeExamenDeLaboratorioSolicitado event)->{
            atencionMedica.prestacionDeServicio.solicitarExamenDeLaboratorio(event.getExamenId(),event.getNombre(),event.getEstado());
        });

        apply((ServicioDeHospitalizacionSolicitado event)->{
            atencionMedica.prestacionDeServicio.solicitarHospitalizacion(event.getHospitalizacionId(), event.getEstadoDeHospitalizacion(),event.getFechaDeIngreso());
        });

        apply((ServicioDeMedicamentoSolicitado event)->{
           atencionMedica.prestacionDeServicio.agregarMedicamento(event.getMedicamentoId(), event.getNombre());
        });
    }
}
