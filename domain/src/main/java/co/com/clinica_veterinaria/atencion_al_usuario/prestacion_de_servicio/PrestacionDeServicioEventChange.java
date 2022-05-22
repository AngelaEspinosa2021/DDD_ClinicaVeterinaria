package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.EventChange;

import java.time.LocalDate;
import java.util.HashSet;

public class PrestacionDeServicioEventChange extends EventChange {
    public PrestacionDeServicioEventChange(PrestacionDeServicio prestacionDeServicio) {
        apply((PrestacionDeServicioCreado event)->{
            prestacionDeServicio.prioridad=event.getPrioridad();
            prestacionDeServicio.fechaDeSolicitud=event.getFechaDeSolicitud();
            prestacionDeServicio.estado=new Estado(Estado.Estados.POR_INICIAR);
            prestacionDeServicio.fechaDeFinalizacion= new Fecha(LocalDate.parse("1900-01-01"));
        });

        apply((EstadoDeExamenDeLaboratorioActualizado event)->{
            prestacionDeServicio.examenDeLaboratorio.actualizarEstado(event.getEstadoExamen());
        });

        apply((EstadoDeHospitalizacionActualizado event)->{
            prestacionDeServicio.hospitalizacion.actualizarEstadoDeHospitalizacion(event.getEstadoDeHospitalizacion());
        });

        apply((ExamenDeLaborarioSolicitado event)->{
            prestacionDeServicio.examenDeLaboratorio=new ExamenDeLaboratorio(event.getExamenId(),event.getNombre(),event.getEstadoExamen());
        });

        apply((FechaDeAltaDeHospitalizacionActualizada event)->{
            prestacionDeServicio.hospitalizacion.actualizarFechaDeAlta(event.getFechaDeAlta());
        });

        apply((FechaDeFinalizacionActualizada event)->{
            prestacionDeServicio.fechaDeFinalizacion=event.getFechaDeFinalizacion();
            prestacionDeServicio.estado=new Estado(Estado.Estados.FINALIZADO);
        });

        apply((HospitalizacionSolicitada event)->{
            prestacionDeServicio.hospitalizacion=new Hospitalizacion(event.getHospitalizacionId(), event.getEstadoDeHospitalizacion(), event.getFechaDeIngreso());
        });

        apply((MedicamentoAgregado event)->{
           prestacionDeServicio.medicamento=new Medicamento(event.getMedicamentoId(), event.getNombre(), event.getFechaDeVencimiento());
        });

        apply((NombreDeMedicamentoActualizado event)->{
            prestacionDeServicio.medicamento.actualizarNombre(event.getNombre());
        });

        apply((PrioridadActualizada event)->{
            prestacionDeServicio.actualizarPrioridad(event.getPrioridad());
        });

        apply((ResultadosDeExamenDeLaboratorioActualizado event)->{
            prestacionDeServicio.examenDeLaboratorio.actualizarResultados(event.getResultados());
        });

        apply((ObservacionDeHospitalizacionAgregada event)->{
            prestacionDeServicio.hospitalizacion.agregarObservacion(event.getObservacion());
        });
    }
}
