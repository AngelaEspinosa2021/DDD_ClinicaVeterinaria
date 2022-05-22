package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeAltaDeHospitalizacion extends Command {
    private final ServicioId servicioId;
    private final HospitalizacionId hospitalizacionId;
    private final Fecha fechaDeAlta;

    public ActualizarFechaDeAltaDeHospitalizacion(ServicioId servicioId, HospitalizacionId hospitalizacionId, Fecha fechaDeAlta) {
        this.servicioId = servicioId;
        this.hospitalizacionId = hospitalizacionId;
        this.fechaDeAlta = fechaDeAlta;
    }

    public ServicioId getServicioId() {return servicioId;}

    public HospitalizacionId getHospitalizacionId() {
        return hospitalizacionId;
    }

    public Fecha getFechaDeAlta() {
        return fechaDeAlta;
    }
}
