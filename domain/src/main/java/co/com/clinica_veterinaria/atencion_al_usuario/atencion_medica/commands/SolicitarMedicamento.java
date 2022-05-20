package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class SolicitarMedicamento extends Command {
    private final ServicioId servicioId;
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;

    public SolicitarMedicamento(ServicioId servicioId, MedicamentoId medicamentoId, Nombre nombre) {
        this.servicioId = servicioId;
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
