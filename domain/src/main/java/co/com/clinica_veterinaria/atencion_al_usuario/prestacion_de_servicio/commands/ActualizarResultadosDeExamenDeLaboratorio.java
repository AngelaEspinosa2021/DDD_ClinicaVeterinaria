package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarResultadosDeExamenDeLaboratorio extends Command {
    private final ServicioId servicioId;
    private final ExamenId examenId;
    private final Resultados resultados;

    public ActualizarResultadosDeExamenDeLaboratorio(ServicioId servicioId, ExamenId examenId, Resultados resultados) {
        this.servicioId = servicioId;
        this.examenId = examenId;
        this.resultados = resultados;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Resultados getResultados() {
        return resultados;
    }
}
