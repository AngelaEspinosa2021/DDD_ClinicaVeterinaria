package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.Identity;

public class HospitalizacionId extends Identity {
    public HospitalizacionId(){

    }

    public HospitalizacionId(String id){
        super(id);
    }

    public static HospitalizacionId of(String id){
        return new HospitalizacionId(id);
    }

}
