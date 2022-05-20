package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;
import java.util.Set;

public class Paciente extends Entity<PacienteId> {
    protected NombreCompleto nombreCompleto;
    protected FechaDeNacimiento fechaDeNacimiento;

    public Paciente(PacienteId pacienteId,NombreCompleto nombreCompleto,FechaDeNacimiento fechaDeNacimiento) {
        super(pacienteId);
        this.nombreCompleto=nombreCompleto;
        this.fechaDeNacimiento=fechaDeNacimiento;
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto=nombreCompleto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public FechaDeNacimiento fechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
