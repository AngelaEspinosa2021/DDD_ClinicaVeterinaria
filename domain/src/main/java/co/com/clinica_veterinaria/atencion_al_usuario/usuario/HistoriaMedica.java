package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class HistoriaMedica extends Entity<HistoriaMedicaId> {

    private Fecha fecha;
    private Descripcion descripcion;
    private NombreDelMedico nombreDelMedico;
    private TipoAtencion tipoAtencion;
    private List<Observacion> observaciones;

    public HistoriaMedica(HistoriaMedicaId historiaMedicaId,Fecha fecha,Descripcion descripcion) {
        super(historiaMedicaId);
        this.fecha=fecha;
        this.descripcion=descripcion;
    }

    public void asociarMedico(NombreDelMedico nombreDelMedico){
        this.nombreDelMedico=nombreDelMedico;
    }

    public void actualizarTipoAtencion(TipoAtencion tipoAtencion){
        this.tipoAtencion=tipoAtencion;
    }

    public void agregarObservacion(Observacion observacion){
        this.observaciones.add(observacion);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion=descripcion;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public NombreDelMedico nombreDelMedico() {
        return nombreDelMedico;
    }

    public TipoAtencion tipoAtencion() {
        return tipoAtencion;
    }

    public List<Observacion> observaciones() {
        return observaciones;
    }
}
