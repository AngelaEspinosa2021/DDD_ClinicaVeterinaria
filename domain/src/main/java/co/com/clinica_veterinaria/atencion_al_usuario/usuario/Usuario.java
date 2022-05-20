package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.DueñoCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected FechaDeCreacion fechaDeCreacion;
    protected Dueño dueño;
    protected Paciente paciente;
    protected Set<HistoriaMedica> historiasMedicas;

    public Usuario(UsuarioId usuarioId, FechaDeCreacion fechaDeCreacion){
        super(usuarioId);
        appendChange( new UsuarioCreado(fechaDeCreacion)).apply();
    }

    public void agregarDueño(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, FechaDeNacimiento fechaDeNacimiento){
        appendChange(new DueñoCreado(dueñoId,nombreCompleto,datosDeContacto,fechaDeNacimiento)).apply();
    }
}
