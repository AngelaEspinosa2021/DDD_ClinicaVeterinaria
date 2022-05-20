package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class HistoriaMedica extends Entity<HistoriaMedicaId> {

    private Fecha fecha;
    private Descripcion descripcion;
    private NombreDelMedico nombreDelMedico;
    private TipoAtencion tipoAtencion;
    private Observacion observaciones;


    public HistoriaMedica(HistoriaMedicaId historiaMedicaId,Fecha fecha,Descripcion descripcion,NombreDelMedico nombreDelMedico,TipoAtencion tipoAtencion,Observacion observaciones) {
        super(historiaMedicaId);
        this.fecha=fecha;
        this.descripcion=descripcion;
        this.nombreDelMedico=nombreDelMedico;
        this.tipoAtencion=tipoAtencion;
        this.observaciones=observaciones;
    }

    public void asociarMedico(NombreDelMedico nombreDelMedico){
        this.nombreDelMedico=nombreDelMedico;
    }

    public void actualizarTipoAtencion(TipoAtencion tipoAtencion){
        this.tipoAtencion=tipoAtencion;
    }

    public void agregarObservacion(Observacion observaciones){
        this.observaciones=observaciones;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion=descripcion;
    }

}
