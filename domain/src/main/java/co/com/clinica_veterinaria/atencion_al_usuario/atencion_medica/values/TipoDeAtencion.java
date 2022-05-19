package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeAtencion implements ValueObject<TipoDeAtencion.Atenciones> {

    private final Atenciones value;

    public TipoDeAtencion(Atenciones value) {
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public Atenciones value() {
        return value;
    }

    public enum Atenciones{
        URGENCIA, CITAPRIORITARIA
    }
}
