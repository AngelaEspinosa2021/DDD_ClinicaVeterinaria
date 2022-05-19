package co.com.ClinicaVeterinaria.atencion_medica;

import co.com.ClinicaVeterinaria.atencion_medica.values.AtencionId;
import co.com.ClinicaVeterinaria.atencion_medica.values.Estado;
import co.com.ClinicaVeterinaria.atencion_medica.values.FechaDeAtencion;
import co.com.ClinicaVeterinaria.atencion_medica.values.TipoDeAtencion;
import co.com.ClinicaVeterinaria.prestacion_de_servicio.PrestacionDeServicio;
import co.com.ClinicaVeterinaria.prestacion_de_servicio.values.ServicioId;
import co.com.ClinicaVeterinaria.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Map;

public class AtencionMedica extends AggregateEvent<AtencionId> {
    protected FechaDeAtencion fechaDeAtencion;
    protected TipoDeAtencion tipoDeAtencion;
    protected Estado estado;
    protected UsuarioId usuarioId;
    protected Urgencia urgencia;
    protected Map<ServicioId, PrestacionDeServicio> servicios;
    protected CitaProgramada citaProgramada;


    public AtencionMedica(AtencionId entityId) {
        super(entityId);
    }
}
