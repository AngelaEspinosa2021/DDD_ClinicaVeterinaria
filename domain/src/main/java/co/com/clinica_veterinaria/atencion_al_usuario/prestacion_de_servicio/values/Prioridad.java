package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Prioridad implements ValueObject<String> {

    private final String value;
    public Prioridad (String value) {
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
