package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            new IllegalArgumentException("El Nombre no puede estar vacio.");
        }
        if (this.value.length() <= 2) {
            new IllegalArgumentException("Debe de tener mayor a 4 caracteres.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre)) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
