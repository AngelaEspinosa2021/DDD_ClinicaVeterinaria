package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Estado.Estados> {

    private final Estados value;

    public Estado(Estados value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Estados value() {
        return value;
    }

    public enum Estados{
        ENPROGRESO, TERMINADA
    }
}
