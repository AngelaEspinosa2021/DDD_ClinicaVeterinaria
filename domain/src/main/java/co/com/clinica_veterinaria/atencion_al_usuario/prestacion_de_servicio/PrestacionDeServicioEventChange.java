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
            prestacionDeServicio.medicamentos=new HashSet<>();
            prestacionDeServicio.examenes=new HashSet<>();
            prestacionDeServicio.fechaDeFinalizacion= new Fecha(LocalDate.parse("1900-01-01"));
        });

        apply((EstadoDeExamenDeLaboratorioActualizado event)->{
            var funcion = prestacionDeServicio.getExamenById(event.getExamenId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de examen medico"));
            funcion.actualizarEstado(event.getEstado());
        });

        apply((EstadoDeHospitalizacionActualizado event)->{
            prestacionDeServicio.hospitalizacion.actualizarEstadoDeHospitalizacion(event.getEstadoDeHospitalizacion());
        });

        apply((ExamenDeLaborarioSolicitado event)->{
            prestacionDeServicio.examenes.add(new ExamenDeLaboratorio(event.getExamenId(),event.getNombre(),event.getEstado()));
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
           prestacionDeServicio.medicamentos.add(new Medicamento(event.getMedicamentoId(), event.getNombre(), event.getFechaDeVencimiento()));
        });

        apply((NombreDeMedicamentoActualizado event)->{
            var funcion = prestacionDeServicio.getMedicamentoById(event.getMedicamentoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de medicamento"));
            funcion.actualizarNombre(event.getNombre());
        });

        apply((PrioridadActualizada event)->{
            prestacionDeServicio.actualizarPrioridad(event.getPrioridad());
        });

        apply((ResultadosDeExamenDeLaboratorioActualizado event)->{
            var funcion = prestacionDeServicio.getExamenById(event.getExamenId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra informacion de examen medico"));
            funcion.actualizarResultados(event.getResultados());
        });

        apply((ObservacionDeHospitalizacionAgregada event)->{
            prestacionDeServicio.hospitalizacion.agregarObservacion(event.getObservacion());
        });
    }
}
