package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaRealizacion implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaRealizacion(LocalDate value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaRealizacion)) return false;
        FechaRealizacion that = (FechaRealizacion) o;
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
