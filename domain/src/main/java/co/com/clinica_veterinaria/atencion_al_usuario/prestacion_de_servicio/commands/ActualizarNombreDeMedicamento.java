package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeMedicamento extends Command {
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;

    public ActualizarNombreDeMedicamento(MedicamentoId medicamentoId, Nombre nombre) {
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
