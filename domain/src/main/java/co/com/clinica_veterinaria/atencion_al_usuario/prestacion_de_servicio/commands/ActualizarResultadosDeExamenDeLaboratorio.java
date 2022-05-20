package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.sofka.domain.generic.Command;

public class ActualizarResultadosDeExamenDeLaboratorio extends Command {
    private final ExamenId examenId;
    private final Resultados resultados;

    public ActualizarResultadosDeExamenDeLaboratorio(ExamenId examenId, Resultados resultados) {
        this.examenId = examenId;
        this.resultados = resultados;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Resultados getResultados() {
        return resultados;
    }
}
