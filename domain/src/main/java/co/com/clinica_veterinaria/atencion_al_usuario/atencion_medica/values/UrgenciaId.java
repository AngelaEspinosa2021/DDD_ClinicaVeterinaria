package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class UrgenciaId extends Identity {

    private UrgenciaId(){

    }

    private UrgenciaId(String id){
        super(id);
    }

    private static UrgenciaId of(String id){
        return new UrgenciaId(id);
    }
}
