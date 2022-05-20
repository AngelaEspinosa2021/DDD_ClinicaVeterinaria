package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosDeContactoDeDueñoActualizados extends DomainEvent {
    private DueñoId dueñoId;
    private DatosDeContacto datosDeContacto;

    public DatosDeContactoDeDueñoActualizados(DueñoId dueñoId, DatosDeContacto datosDeContacto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DatosDeContactoDeDueñoActualizados");
        this.dueñoId = dueñoId;
        this.datosDeContacto = datosDeContacto;
    }

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }
}
