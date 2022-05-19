package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.FechaDeSolicitud;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class PrestacionDeServicio extends AggregateEvent<ServicioId> {
    protected Prioridad prioridad;
    protected FechaDeSolicitud fechaDeSolicitud;
    protected Set<ExamenDeLaboratorio> examenes;
    protected Set<Medicamento> medicamentos;
    protected Hospitalizacion hospitalizacion;


    public PrestacionDeServicio(ServicioId entityId) {
        super(entityId);
    }
}
