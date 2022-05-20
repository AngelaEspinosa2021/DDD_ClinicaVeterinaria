package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoDeHospitalizacion implements ValueObject<EstadoDeHospitalizacion.Listado>{
    private final Listado value;

    public EstadoDeHospitalizacion(Listado value){
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public Listado value() {
        return value;
    }

    public enum Listado{
       INTERNO, ALTA
   }
}
