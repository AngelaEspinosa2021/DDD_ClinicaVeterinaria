package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicoAgregado extends DomainEvent {
    private final MedicoId medicoId;
    private final NombreCompleto nombreCompleto;
    private final DatosDeContacto datosDeContacto;
    private final Fecha fechaDeNacimiento;

    public MedicoAgregado(MedicoId medicoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.MedicoAgregado");
        this.medicoId = medicoId;
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
