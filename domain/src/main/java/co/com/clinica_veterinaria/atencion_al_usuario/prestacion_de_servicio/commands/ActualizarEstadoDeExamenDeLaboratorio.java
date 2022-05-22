package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeExamenDeLaboratorio extends Command {
    private final ServicioId servicioId;
    private final ExamenId examenId;
    private final Estado estado;

    public ActualizarEstadoDeExamenDeLaboratorio(ExamenId examenId, Estado estado,ServicioId servicioId) {
        this.examenId = examenId;
        this.estado = estado;
        this.servicioId = servicioId;
    }

    public ServicioId getServicioId() {return servicioId;}

    public ExamenId getExamenId() {
        return examenId;
    }

    public Estado getEstado() {
        return estado;
    }
}
