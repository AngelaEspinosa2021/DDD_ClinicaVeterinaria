package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.sofka.domain.generic.DomainEvent;

public class ResultadosDeExamenDeLaboratorioActualizado extends DomainEvent {
    private ExamenId examenId;
    private Resultados resultados;

    public ResultadosDeExamenDeLaboratorioActualizado(ExamenId examenId, Resultados resultados) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ResultadosDeExamenDeLaboratorioActualizado");
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
