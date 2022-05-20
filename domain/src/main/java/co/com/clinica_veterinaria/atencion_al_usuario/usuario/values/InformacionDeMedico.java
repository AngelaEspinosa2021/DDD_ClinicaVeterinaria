package co.com.clinica_veterinaria.atencion_al_usuario.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionDeMedico implements ValueObject<InformacionDeMedico.Props> {

    private final String medicoId;
    private final String nombreCompleto;

    public InformacionDeMedico(String medicoId, String nombreCompleto){
        this.medicoId= Objects.requireNonNull(medicoId);
        if(this.medicoId.isBlank()){
            new IllegalArgumentException("El identificador Del Médico no puede estar vacio.");
        }
        this.nombreCompleto=Objects.requireNonNull(nombreCompleto);
        if(this.nombreCompleto.isBlank()){
            new IllegalArgumentException("El nombre del Médico no puede estar vacio.");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String medicoId() {
                return medicoId;
            }

            @Override
            public String nombreCompleto() {
                return nombreCompleto;
            }
        };
    }

    public interface Props {
        String medicoId();
        String nombreCompleto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformacionDeMedico)) return false;
        InformacionDeMedico that = (InformacionDeMedico) o;
        return Objects.equals(medicoId, that.medicoId) && Objects.equals(nombreCompleto, that.nombreCompleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicoId, nombreCompleto);
    }
}
