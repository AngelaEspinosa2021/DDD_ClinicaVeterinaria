package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.Identity;

public class UrgenciaId extends Identity {

    public UrgenciaId(String id){
        super(id);
    }

    public static UrgenciaId of(String id){
        return new UrgenciaId(id);
    }
}
