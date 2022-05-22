package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoExamen implements ValueObject<String> {
    private final String value;

    public EstadoExamen(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
