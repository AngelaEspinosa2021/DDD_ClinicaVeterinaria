package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Entity;

public class CitaProgramada extends Entity<CitaId> {
    protected Observacion observacion;
    protected FechaCita fechaCita;

    public CitaProgramada(CitaId CitaId, Observacion observacion,FechaCita fechaCita){
        super(CitaId);
        this.observacion = observacion;
        this.fechaCita = fechaCita;
    }

    public void actualizarFechaCita(FechaCita fechaCita){
        this.fechaCita=fechaCita;
    }

    public void actualizarObservacion(Observacion observacion){
        this.observacion=observacion;
    }

    public Observacion observacion() {
        return observacion;
    }

    public FechaCita fechaCita() {
        return fechaCita;
    }
}
