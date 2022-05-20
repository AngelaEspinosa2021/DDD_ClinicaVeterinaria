package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import javax.management.loading.ClassLoaderRepository;
import java.util.Objects;

public class Triage implements ValueObject<Triage.Clasificacion> {

    private final Clasificacion value;

    public Triage(Clasificacion value){
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public Clasificacion value() {
        return value;
    }

    public enum Clasificacion{
        SIN_URGENCIA,URGENCIA_MENOR,URGENCIA,EMERGENCIA,RESUCITACION
    }
}
