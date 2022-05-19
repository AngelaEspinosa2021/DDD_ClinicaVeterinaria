package co.com.ClinicaVeterinaria.usuario;

import co.com.ClinicaVeterinaria.usuario.values.FechaDeCreacion;
import co.com.ClinicaVeterinaria.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected FechaDeCreacion fechaDeCreacion;
    protected Dueño dueño;
    protected Paciente paciente;


    public Usuario(UsuarioId entityId) {
        super(entityId);
    }
}
