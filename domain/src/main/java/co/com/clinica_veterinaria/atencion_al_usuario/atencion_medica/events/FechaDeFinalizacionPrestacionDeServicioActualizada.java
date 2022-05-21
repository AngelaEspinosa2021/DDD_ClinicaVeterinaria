package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeFinalizacionPrestacionDeServicioActualizada extends DomainEvent {
    private final ServicioId servicioId;
    private final Fecha fechaDeFinalizacion;

    public FechaDeFinalizacionPrestacionDeServicioActualizada(ServicioId servicioId, Fecha fechaDeFinalizacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeFinalizacionPrestacionDeServicioActualizada");
        this.servicioId = servicioId;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Fecha getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }
}
