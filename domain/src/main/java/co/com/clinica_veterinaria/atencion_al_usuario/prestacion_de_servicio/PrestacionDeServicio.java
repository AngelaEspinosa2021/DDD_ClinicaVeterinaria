package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class PrestacionDeServicio extends AggregateEvent<ServicioId> {
    protected Prioridad prioridad;
    protected Fecha fechaDeSolicitud;
    protected Set<ExamenDeLaboratorio> examenes;
    protected Set<Medicamento> medicamentos;
    protected Hospitalizacion hospitalizacion;


    public PrestacionDeServicio(ServicioId servicioId, Prioridad prioridad,Fecha fechaDeSolicitud) {
        super(servicioId);
        appendChange(new PrestacionDeServicioCreado(prioridad,fechaDeSolicitud)).apply();
    }

    public void solicitarExamenDeLaboratorio(ExamenId examenId, Nombre nombre, Fecha fechaRealizacion, Resultados resultados, Estado estado){
        appendChange( new ExamenDeLaborarioSolicitado(examenId,nombre,fechaRealizacion,resultados,estado)).apply();
    }

    public void agregarMedicamento(MedicamentoId medicamentoId, Nombre nombre, Fecha fechaDeVencimiento){
        appendChange( new MedicamentoAgregado(medicamentoId,nombre,fechaDeVencimiento)).apply();
    }

    public void solicitarHospitalizacion(HospitalizacionId hospitalizacionId,EstadoDeHospitalizacion estadoDeHospitalizacion,Fecha fechaDeIngreso){
        appendChange( new HospitalizacionSolicitada(hospitalizacionId,estadoDeHospitalizacion,fechaDeIngreso)).apply();
    }

    public void actualizarPrioridad(Prioridad prioridad){
        appendChange( new PrioridadActualizada(prioridad)).apply();
    }

    public void actualizarNombreDeMedicamento(MedicamentoId medicamentoId, Nombre nombre){
        appendChange( new NombreDeMedicamentoActualizado(medicamentoId,nombre)).apply();
    }

    public void actualizarEstadoDeExamenDeLaboratorio(ExamenId examenId, Estado estado){
        appendChange( new EstadoDeExamenDeLaboratorioActualizado(examenId,estado)).apply();
    }

    public void actualizarResultadosDeExamenDeLaboratorio(ExamenId examenId, Resultados resultados){
        appendChange( new ResultadosDeExamenDeLaboratorioActualizado(examenId,resultados)).apply();
    }

    public void actualizarEstadoDeHospitalizacion(HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion){
        appendChange( new EstadoDeHospitalizacionActualizado(hospitalizacionId,estadoDeHospitalizacion)).apply();
    }

    public void actualizarFechaDeAltaDeHospitalizacion(HospitalizacionId hospitalizacionId, Fecha fechaDeAlta){
        appendChange( new FechaDeAltaDeHospitalizacionActualizada(hospitalizacionId,fechaDeAlta)).apply();
    }
}
