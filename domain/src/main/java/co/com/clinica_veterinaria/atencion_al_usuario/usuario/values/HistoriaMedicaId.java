package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.sofka.domain.generic.Identity;

public class HistoriaMedicaId extends Identity {

    public HistoriaMedicaId(){

    }

    public HistoriaMedicaId(String id){
        super(id);
    }

    public static HistoriaMedicaId of(String id){
        return new HistoriaMedicaId(id);
    }
}
