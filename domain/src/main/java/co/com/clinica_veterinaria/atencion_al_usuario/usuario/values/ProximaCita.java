package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProximaCita implements ValueObject<String> {
    private final String value;

    public ProximaCita(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
