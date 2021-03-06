package co.com.clinica_veterinaria.atencion_al_usuario.values_generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observacion implements ValueObject<String> {
    private final String observacion;

    public Observacion(String observacion) {
        this.observacion = Objects.requireNonNull(observacion);
    }

    @Override
    public String value() {
        return observacion;
    }
}
