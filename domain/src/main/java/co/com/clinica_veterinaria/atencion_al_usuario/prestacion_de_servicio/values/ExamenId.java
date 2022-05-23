package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.Identity;

public class ExamenId extends Identity {
    public ExamenId(String id){
        super(id);
    }

    public static ExamenId of(String id){
        return new ExamenId(id);
    }

}
