package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class PacienteId extends Identity {

    public PacienteId(String id){
        super(id);
    }

    public static PacienteId of(String id){
        return new PacienteId(id);
    }
}
