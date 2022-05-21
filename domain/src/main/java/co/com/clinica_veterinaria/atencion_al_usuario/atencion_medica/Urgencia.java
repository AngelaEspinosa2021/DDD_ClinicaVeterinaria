package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.Triage;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Entity;

public class Urgencia extends Entity<UrgenciaId> {
    protected Observacion observacion;
    protected Triage triage;

    public Urgencia(UrgenciaId urgenciaId,Observacion observacion,Triage triage){
        super(urgenciaId);
        this.observacion = observacion;
        this.triage = triage;
    }

    public void actualizarObservacion(Observacion observacion){
        this.observacion=observacion;
    }

    public Observacion observacion() {
        return observacion;
    }

    public Triage getTriage() {return triage;}
}
