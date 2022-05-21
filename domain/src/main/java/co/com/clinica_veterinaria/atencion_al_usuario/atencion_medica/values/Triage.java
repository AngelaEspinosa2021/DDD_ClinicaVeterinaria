package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import javax.management.loading.ClassLoaderRepository;
import java.util.Objects;

public class Triage implements ValueObject<String> {

    private final String value;

    public Triage(String value){
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
