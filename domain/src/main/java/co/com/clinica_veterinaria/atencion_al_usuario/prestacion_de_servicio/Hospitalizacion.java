package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class Hospitalizacion extends Entity<HospitalizacionId> {
    protected EstadoDeHospitalizacion estadoDeHospitalizacion;
    protected Fecha fechaDeIngreso;
    protected Fecha fechaDeAlta;
    protected Observacion observacion;


    public Hospitalizacion(HospitalizacionId hospitalizacionId,EstadoDeHospitalizacion estadoDeHospitalizacion,Fecha fechaDeIngreso) {
        super(hospitalizacionId);
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public void agregarObservacion(Observacion observacion){
        this.observacion=observacion;
    }

    public Observacion getObservacion() {return observacion;}
}
