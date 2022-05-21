package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.sofka.domain.generic.Identity;

public class MedicoId extends Identity {

    public MedicoId(String id){
        super(id);
    }

    public static MedicoId of(String id){
        return new MedicoId(id);
    }
}
