package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeAtencion implements ValueObject<String> {

    private final String value;

    public TipoDeAtencion(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
