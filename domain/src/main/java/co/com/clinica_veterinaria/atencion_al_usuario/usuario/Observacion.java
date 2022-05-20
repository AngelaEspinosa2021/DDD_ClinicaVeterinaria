package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.sofka.domain.generic.ValueObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Observacion implements ValueObject<Map<Integer, String>> {
    private final Integer observacionId;
    private final String observacion;
    private final Map<Integer,String> observaciones = new HashMap<Integer,String>();

    public Observacion(Integer observacionId, String observacion){
        this.observacionId= Objects.requireNonNull(observacionId);
        this.observacion=Objects.requireNonNull(observacion);
        observaciones.put(observacionId,observacion);
    }

    @Override
    public Map<Integer, String> value() {
        return observaciones;
    }
}
