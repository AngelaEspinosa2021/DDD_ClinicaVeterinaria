package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class AtencionMedica extends AggregateEvent<AtencionId> {
    protected UsuarioId usuarioId;
    protected ServicioId servicioId;
    protected Fecha fechaDeAtencion;
    protected TipoDeAtencion tipoDeAtencion;
    protected Estado estado;
    protected Fecha proximaCita;
    protected Fecha fechaDeFinalizacion;
    protected Medico medico;
    protected Urgencia urgencia;
    protected CitaProgramada citaProgramada;


    public AtencionMedica(AtencionId atencionId,UsuarioId usuarioId,Fecha fechaDeAtencion,TipoDeAtencion tipoDeAtencion) {
        super(atencionId);
        appendChange( new AtencionCreada(fechaDeAtencion,tipoDeAtencion, usuarioId)).apply();
    }

    private AtencionMedica(AtencionId atencionId){
        super(atencionId);
        subscribe(new AtencionMedicaEventChange(this));
    }

    public static AtencionMedica from(AtencionId atencionId, List<DomainEvent> events){
        var atencionMedica = new AtencionMedica(atencionId);
        events.forEach(atencionMedica::applyEvent);
        return atencionMedica;
    }

    public void finalizarAtencion(Fecha proximaCita){
        appendChange(new AtencionFinalizada(usuarioId, proximaCita)).apply();
    }

    public void actualizarFechaDeFinalizacionPrestacionDeServicio(Fecha fechaDeFinalizacion){
        appendChange(new FechaDeFinalizacionPrestacionDeServicioActualizada(servicioId,fechaDeFinalizacion)).apply();
    }

    public void agregarMedico(MedicoId medicoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento){
        appendChange( new MedicoAgregado(medicoId,nombreCompleto,datosDeContacto,fechaDeNacimiento)).apply();
    }

    public void generarAtencionDeUrgencias(UrgenciaId urgenciaId, Observacion observacion, Triage triage){
        appendChange( new AtencionDeUrgenciasGenerada(urgenciaId,observacion,triage)).apply();
    }

    public void generarAtencionDeCitaProgramada(CitaId citaId, Observacion observacion, FechaCita fechaCita){
        appendChange( new AtencionDeCitaProgramadaGenerada(citaId,observacion,fechaCita)).apply();
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

    public void actualizarEstadoDeAtencion(Estado estado){
        appendChange( new EstadoDeAtencionActualizado(estado)).apply();
    }

}
