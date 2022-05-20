package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class FechaCita implements ValueObject<FechaCita.Props> {
    private final LocalDate fecha;
    private final LocalDateTime hora;

    public FechaCita(LocalDate fecha, LocalDateTime hora) {
        this.fecha = Objects.requireNonNull(fecha);
        this.hora = Objects.requireNonNull(hora);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalDate fecha() {
                return fecha;
            }

            @Override
            public LocalDateTime hora() {
                return hora;
            }
        };
    }

    public interface Props {
        LocalDate fecha();
        LocalDateTime hora();

    }
}
