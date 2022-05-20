package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ExamenDeLaborarioSolicitado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.FechaDeVencimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.MedicamentoAgregado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Set;

public class PrestacionDeServicio extends AggregateEvent<ServicioId> {
    protected Prioridad prioridad;
    protected FechaDeSolicitud fechaDeSolicitud;
    protected Set<ExamenDeLaboratorio> examenes;
    protected Set<Medicamento> medicamentos;
    protected Hospitalizacion hospitalizacion;


    public PrestacionDeServicio(ServicioId servicioId, Prioridad prioridad,FechaDeSolicitud fechaDeSolicitud) {
        super(servicioId);
        appendChange(new PrestacionDeServicioCreado(prioridad,fechaDeSolicitud)).apply();
    }

    public void solicitarExamenDeLaboratorio(ExamenId examenId, Nombre nombre, FechaRealizacion fechaRealizacion, Resultados resultados, Estado estado){
        appendChange( new ExamenDeLaborarioSolicitado(examenId,nombre,fechaRealizacion,resultados,estado)).apply();
    }

    public void agregarMedicamento(MedicamentoId medicamentoId, Nombre nombre, FechaDeVencimiento fechaDeVencimiento){
        appendChange( new MedicamentoAgregado(medicamentoId,nombre,fechaDeVencimiento)).apply();
    }

    public void solicitarHospitalizacion(){

    }

}
