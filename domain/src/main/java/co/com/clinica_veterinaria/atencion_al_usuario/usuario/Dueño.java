package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

public class Dueño extends Entity<DueñoId> {

    private NombreCompleto nombreCompleto;
    private DatosDeContacto datosDeContacto;


    public Dueño(DueñoId dueñoId) {
        super(dueñoId);
    }
}
