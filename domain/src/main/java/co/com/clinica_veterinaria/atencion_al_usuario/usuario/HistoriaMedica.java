package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class HistoriaMedica extends Entity<HistoriaMedicaId> {

    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Observacion observacion;

    public HistoriaMedica(HistoriaMedicaId historiaMedicaId,Fecha fecha,Descripcion descripcion) {
        super(historiaMedicaId);
        this.fecha=fecha;
        this.descripcion=descripcion;
    }

    public void agregarObservacion(Observacion observacion){this.observacion=observacion;}
}
