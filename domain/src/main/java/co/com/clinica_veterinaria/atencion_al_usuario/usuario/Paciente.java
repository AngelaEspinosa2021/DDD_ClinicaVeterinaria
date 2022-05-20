package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

import java.util.Set;

public class Paciente extends Entity<PacienteId> {
    private NombreCompleto nombreCompleto;
    private FechaDeNacimiento fechaDeNacimiento;
    private Set<HistoriaMedica> historiasMedicas;

    public Paciente(PacienteId pacienteId) {
        super(pacienteId);
    }
}
