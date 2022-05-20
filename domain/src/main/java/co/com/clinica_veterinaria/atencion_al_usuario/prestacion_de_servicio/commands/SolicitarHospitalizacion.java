package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarHospitalizacion extends Command {
    private final HospitalizacionId hospitalizacionId;
    private final EstadoDeHospitalizacion estadoDeHospitalizacion;
    private final Fecha fechaDeIngreso;

    public SolicitarHospitalizacion(HospitalizacionId hospitalizacionId, EstadoDeHospitalizacion estadoDeHospitalizacion, Fecha fechaDeIngreso) {
        this.hospitalizacionId = hospitalizacionId;
        this.estadoDeHospitalizacion = estadoDeHospitalizacion;
        this.fechaDeIngreso = fechaDeIngreso;
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
