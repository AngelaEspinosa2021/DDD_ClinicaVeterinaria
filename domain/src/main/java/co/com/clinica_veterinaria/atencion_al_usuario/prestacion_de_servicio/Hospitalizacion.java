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
    protected List<Observacion> observacionesHospitalizacion;


    public Hospitalizacion(HospitalizacionId hospitalizacionId,EstadoDeHospitalizacion estadoDeHospitalizacion,Fecha fechaDeIngreso) {
        super(hospitalizacionId);
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public void actualizarEstadoDeHospitalizacion(EstadoDeHospitalizacion estadoDeHospitalizacion){
        this.estadoDeHospitalizacion=estadoDeHospitalizacion;
    }

    public void actualizarFechaDeAlta(Fecha fechaDeAlta){
        this.fechaDeAlta=fechaDeAlta;
    }

    public void agregarObservacion(Observacion observacion){
        this.observacionesHospitalizacion.add(observacion);
    }

    public EstadoDeHospitalizacion estadoDeHospitalizacion() {
        return estadoDeHospitalizacion;
    }

    public Fecha fechaDeIngreso() {
        return fechaDeIngreso;
    }

    public Fecha fechaDeAlta() {
        return fechaDeAlta;
    }

    public List<Observacion> observacionesHospitalizacion() {
        return observacionesHospitalizacion;
    }
}
