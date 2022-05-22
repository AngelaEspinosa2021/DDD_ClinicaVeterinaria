package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.services;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;

public interface ActualizarFechaDeFinalizacion {
    Fecha consultarPorAtencionId(AtencionId atencionId);
}
