package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class ServicioDeMedicamentoSolicitado extends DomainEvent {
    private final ServicioId servicioId;
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;

    public ServicioDeMedicamentoSolicitado(ServicioId servicioId, MedicamentoId medicamentoId, Nombre nombre) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ServicioDeMedicamentoSolicitado");
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
