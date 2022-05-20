package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            new IllegalArgumentException("La descripción no puede estar vacia.");
        }

        if(this.value.length() <= 5){
            new IllegalArgumentException("Debe de tener mayor a 5 caracteres.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Descripcion)) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
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
