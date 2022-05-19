package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosDeContacto implements ValueObject<DatosDeContacto.Props> {
    private String direccion;
    private String barrio;
    private String telefonoCelular;
    private String correo;

    public DatosDeContacto(String direccion, String barrio, String telefonoCelular, String correo){
        this.direccion = Objects.requireNonNull(direccion);
        if(this.direccion.isBlank()){
            new IllegalArgumentException("La dirección no puede estar vacia.");
        }
        this.barrio = Objects.requireNonNull(barrio);
        this.telefonoCelular =Objects.requireNonNull(telefonoCelular);
        if(this.telefonoCelular.isBlank()){
            new IllegalArgumentException("El Télofono no puede estar vacio.");
        }
        this.correo = Objects.requireNonNull(correo);
        if(this.correo.isBlank()){
            new IllegalArgumentException("El correo no puede estar vacio.");
        }
        if(!correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[_A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public String barrio() {
                return barrio;
            }

            @Override
            public String telefonoCelular() {
                return telefonoCelular;
            }

            @Override
            public String correo() {
                return correo;
            }
        };
    }

    public interface Props {
        String direccion();
        String barrio();
        String telefonoCelular();
        String correo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosDeContacto)) return false;
        DatosDeContacto that = (DatosDeContacto) o;
        return Objects.equals(direccion, that.direccion) && Objects.equals(barrio, that.barrio) && Objects.equals(telefonoCelular, that.telefonoCelular) && Objects.equals(correo, that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, barrio, telefonoCelular, correo);
    }
}
