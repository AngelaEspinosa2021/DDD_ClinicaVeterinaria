package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AtencionMedica extends AggregateEvent<AtencionId> {
    protected Fecha fechaDeAtencion;
    protected TipoDeAtencion tipoDeAtencion;
    protected Estado estado;
    protected UsuarioId usuarioId;
    protected Medico medico;
    protected Urgencia urgencia;
    protected Set<PrestacionDeServicio> servicios;
    protected CitaProgramada citaProgramada;


    public AtencionMedica(AtencionId atencionId, Fecha fechaDeAtencion,TipoDeAtencion tipoDeAtencion,Estado estado) {
        super(atencionId);
        appendChange( new AtencionCreada(fechaDeAtencion,tipoDeAtencion,estado)).apply();
    }

    public void agregarMedico(MedicoId medicoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento){
        appendChange( new MedicoAgregado(medicoId,nombreCompleto,datosDeContacto,fechaDeNacimiento)).apply();
    }

    public void solicitarAtencionDeUrgencia(UrgenciaId urgenciaId, Observacion observacion, Triage triage){
        appendChange(new AtencionDeUrgenciaSolicitada(urgenciaId,observacion,triage)).apply();
    }

    public void solicitarAtencionDeCitaProgramada(CitaId CitaId, Observacion observacion,FechaCita fechaCita){
        appendChange(new AtencionDeCitaProgramadaSolicitada(CitaId,observacion,fechaCita)).apply();
    }

    public void actualizarDatosDeContactoDeMedico(MedicoId medicoId, DatosDeContacto datosDeContacto){
        appendChange(new DatosDeContactoDeMedicoActualizados(medicoId,datosDeContacto)).apply();
    }

    public void actualizarNombreDeMedico(MedicoId medicoId, NombreCompleto nombreCompleto){
        appendChange(new NombreDeMedicoActualizado(medicoId,nombreCompleto)).apply();
    }

    public void actualizarFechaDeCitaProgramada(CitaId citaId, FechaCita fechaCita){
        appendChange( new FechaDeCitaProgramadaActualizada(citaId,fechaCita)).apply();
    }

    public void actualizarObservacionesDeCitaProgramada(CitaId citaId, Observacion observacion){
        appendChange( new ObservacionesDeCitaProgramadaActualizada(citaId,observacion)).apply();
    }

    public void actualizarObservacionDeUrgencia(UrgenciaId urgenciaId, Observacion observacion){
        appendChange( new ObservacionDeUrgenciaActualizada(urgenciaId,observacion)).apply();
    }

    public void agregarAHistoriaMedicaDeUsuario(UsuarioId usuarioId,HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion ){
        appendChange(new HistoriaMedicaDeUsuarioAgregada(usuarioId,historiaMedicaId,fecha,descripcion)).apply();
    }

    public void solicitarPrestacionDeServicio(ServicioId servicioId, Prioridad prioridad, Fecha fechaDeSolicitud){
        appendChange(new PrestacionDeServicioSolicitado(servicioId,prioridad,fechaDeSolicitud)).apply();
    }


}
