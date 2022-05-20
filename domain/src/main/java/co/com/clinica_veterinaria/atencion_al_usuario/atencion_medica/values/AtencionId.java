package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class AtencionId extends Identity {
    private AtencionId(){

    }

    private AtencionId(String id){
        super(id);
    }

    private static AtencionId of(String id){
        return new AtencionId(id);
    }
}
