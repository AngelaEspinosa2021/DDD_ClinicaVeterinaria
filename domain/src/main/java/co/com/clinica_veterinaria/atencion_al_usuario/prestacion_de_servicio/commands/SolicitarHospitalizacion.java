package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarHospitalizacion extends Command {
    private final ServicioId servicioId;
    private final HospitalizacionId hospitalizacionId;
    private final EstadoDeHospitalizacion estadoDeHospitalizacion;
    private final Fecha fechaDeIngreso;

    public SolicitarHospitalizacion(ServicioId servicioId, HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion, Fecha fechaDeIngreso) {
        this.servicioId = servicioId;
        this.hospitalizacionId = hospitalizacionId;
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public EstadoDeHospitalizacion getEstadoDeHospitalizacion() {
        return estadoDeHospitalizacion;
    }

    public Fecha getFechaDeIngreso() {
        return fechaDeIngreso;
    }
}
