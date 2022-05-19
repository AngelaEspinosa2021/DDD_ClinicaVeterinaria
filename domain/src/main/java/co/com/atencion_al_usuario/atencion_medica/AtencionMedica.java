package co.com.atencion_al_usuario.atencion_medica;

import co.com.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.atencion_al_usuario.atencion_medica.values.Estado;
import co.com.atencion_al_usuario.atencion_medica.values.FechaDeAtencion;
import co.com.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.atencion_al_usuario.usuario.values.UsuarioId;
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
