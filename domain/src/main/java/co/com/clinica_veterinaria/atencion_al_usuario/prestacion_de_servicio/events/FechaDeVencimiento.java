package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaDeVencimiento implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaDeVencimiento(LocalDate value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaDeVencimiento)) return false;
        FechaDeVencimiento that = (FechaDeVencimiento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public LocalDate value() {
        return null;
    }
}
