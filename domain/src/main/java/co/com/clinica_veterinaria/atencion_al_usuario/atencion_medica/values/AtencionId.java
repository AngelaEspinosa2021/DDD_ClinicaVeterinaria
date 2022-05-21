package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class AtencionId extends Identity {
    public AtencionId(){

    }

    public AtencionId(String id){
        super(id);
    }

    public static AtencionId of(String id){
        return new AtencionId(id);
    }
}
