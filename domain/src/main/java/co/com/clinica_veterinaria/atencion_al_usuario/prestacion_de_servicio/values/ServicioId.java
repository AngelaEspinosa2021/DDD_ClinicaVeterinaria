package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.Identity;

public class ServicioId extends Identity {
    public ServicioId(){

    }

    public ServicioId(String id){
        super(id);
    }

    public static ServicioId of(String id){
        return new ServicioId(id);
    }
}
