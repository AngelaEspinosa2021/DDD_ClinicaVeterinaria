package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.Identity;

public class MedicamentoId extends Identity {

    public MedicamentoId(String id){
        super(id);
    }

    public static MedicamentoId of(String id){
        return new MedicamentoId(id);
    }
}
