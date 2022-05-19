package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.Dueño;
import co.com.sofka.domain.generic.Identity;

public class DueñoId extends Identity {

    private DueñoId(){

    }

    private DueñoId(String id){
        super(id);
    }

    public static DueñoId of(String id){
        return new DueñoId(id);
    }
}
