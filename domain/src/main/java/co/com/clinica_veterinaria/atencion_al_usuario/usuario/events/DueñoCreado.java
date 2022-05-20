package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class DueñoCreado extends DomainEvent {
    private final DueñoId dueñoId;
    private final NombreCompleto nombreCompleto;
    private final DatosDeContacto datosDeContacto;
    private final FechaDeNacimiento fechaDeNacimiento;

    public DueñoCreado(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, FechaDeNacimiento fechaDeNacimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DueñoCreado");
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
