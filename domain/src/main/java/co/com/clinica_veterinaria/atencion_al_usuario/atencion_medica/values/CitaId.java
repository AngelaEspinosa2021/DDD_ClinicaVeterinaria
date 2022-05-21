package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class CitaId extends Identity {

    public CitaId(String id){
        super(id);
    }

    public static CitaId of(String id){
        return new CitaId(id);
    }
}
