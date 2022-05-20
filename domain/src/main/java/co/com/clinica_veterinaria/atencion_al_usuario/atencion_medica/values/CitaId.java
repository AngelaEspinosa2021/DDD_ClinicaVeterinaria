package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class CitaId extends Identity {
    private CitaId(){

    }

    private CitaId(String id){
        super(id);
    }

    private static CitaId of(String id){
        return new CitaId(id);
    }
}
