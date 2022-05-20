package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.Command;

public class SolicitarExamenDeLaboratorio extends Command {
    private final ServicioId servicioId;
    private final ExamenId examenId;
    private final Nombre nombre;
    private final Estado estado;

    public SolicitarExamenDeLaboratorio(ServicioId servicioId, ExamenId examenId, Nombre nombre, Estado estado) {
        this.servicioId = servicioId;
        this.examenId = examenId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }
}
