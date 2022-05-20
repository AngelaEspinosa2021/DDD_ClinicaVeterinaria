package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosDeContactoDeMedicoActualizados extends DomainEvent {
    private final MedicoId medicoId;
    private final DatosDeContacto datosDeContacto;

    public DatosDeContactoDeMedicoActualizados(MedicoId medicoId, DatosDeContacto datosDeContacto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DatosDeContactoDeMedicoActualizados");
        this.medicoId = medicoId;
        this.datosDeContacto = datosDeContacto;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }
}
