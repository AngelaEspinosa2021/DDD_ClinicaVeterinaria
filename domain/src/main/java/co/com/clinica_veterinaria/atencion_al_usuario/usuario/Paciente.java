package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

public class Paciente extends Entity<PacienteId> {
    protected NombreCompleto nombreCompleto;
    protected Fecha fechaDeNacimiento;

    public Paciente(PacienteId pacienteId,NombreCompleto nombreCompleto,Fecha fechaDeNacimiento) {
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

    public Fecha fechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
