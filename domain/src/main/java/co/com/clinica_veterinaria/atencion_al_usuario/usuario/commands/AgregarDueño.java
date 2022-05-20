package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class AgregarDueño extends Command {

    private final UsuarioId usuarioId;
    private final DueñoId dueñoId;
    private final NombreCompleto nombreCompleto;
    private final DatosDeContacto datosDeContacto;
    private final Fecha fechaDeNacimiento;

    public AgregarDueño(UsuarioId usuarioId, DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento) {
        this.usuarioId = usuarioId;
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
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

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
