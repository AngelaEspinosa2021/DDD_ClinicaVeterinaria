package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class UsuarioId extends Identity {

    public UsuarioId(String id){
        super(id);
    }

    public static UsuarioId of(String id){
        return new UsuarioId(id);
    }
}
