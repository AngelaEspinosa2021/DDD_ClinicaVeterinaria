package co.com.ClinicaVeterinaria.prestacion_de_servicio;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Prioridad implements ValueObject<Prioridad.Prioridades> {

    private final Prioridades value;


    public Prioridad (Prioridades value) {
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public Prioridades value() {
        return null;
    }

    public enum Prioridades{
        ALTA, MEDIA, BAJA
    }
}
