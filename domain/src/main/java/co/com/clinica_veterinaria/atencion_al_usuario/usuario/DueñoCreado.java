package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class DueñoCreado extends DomainEvent {
    public DueñoCreado(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, FechaDeNacimiento fechaDeNacimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DueñoCreado");
    }
}
