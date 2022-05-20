package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosDeContactoDeDueñoActualizados extends DomainEvent {
    public DatosDeContactoDeDueñoActualizados(DueñoId dueñoId, DatosDeContacto datosDeContacto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DatosDeContactoDeDueñoActualizados");
    }
}
