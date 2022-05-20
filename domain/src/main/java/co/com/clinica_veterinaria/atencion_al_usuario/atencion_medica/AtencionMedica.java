package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.Usuario;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.*;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;

public class AtencionMedica extends AggregateEvent<AtencionId> {
    protected Fecha fechaDeAtencion;
    protected TipoDeAtencion tipoDeAtencion;
    protected Estado estado;
    protected Usuario usuario;
    protected Medico medico;
    protected Urgencia urgencia;
    protected PrestacionDeServicio prestacionDeServicio;
    protected CitaProgramada citaProgramada;


    public AtencionMedica(AtencionId atencionId,UsuarioId usuarioId, Fecha fechaDeAtencion,TipoDeAtencion tipoDeAtencion,Estado estado) {
        super(atencionId);
        appendChange( new AtencionCreada(usuarioId,fechaDeAtencion,tipoDeAtencion,estado)).apply();
    }

    private AtencionMedica(AtencionId atencionId){
        super(atencionId);
        subscribe(new AtencionMedicaEventChange(this));
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

    public void actualizarEstadoDeAtencion(Estado estado){
        appendChange( new EstadoDeAtencionActualizado(estado)).apply();
    }

    public void agregarObservacionAHistoriaMedicaDeUsuario(UsuarioId usuarioId,HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion, Observacion observacion){
        appendChange(new ObservacionDeHistoriaMedicaDeUsuarioAgregada(usuarioId,historiaMedicaId,fecha,descripcion,observacion)).apply();
    }

    public void solicitarExamenDeLaboratorio(ServicioId servicioId, ExamenId examenId, Nombre nombre, Estado estado){
        appendChange(new ServicioDeExamenDeLaboratorioSolicitado(servicioId,examenId,nombre,estado)).apply();
    }

    public void solicitarHospitalizacion(ServicioId servicioId, HospitalizacionId hospitalizacionId,EstadoDeHospitalizacion estadoDeHospitalizacion,Fecha fechaDeIngreso ){
        appendChange(new ServicioDeHospitalizacionSolicitado(servicioId,hospitalizacionId,estadoDeHospitalizacion,fechaDeIngreso)).apply();
    }

    public void solicitarMedicamento(ServicioId servicioId,MedicamentoId medicamentoId, Nombre nombre){
        appendChange( new ServicioDeMedicamentoSolicitado(servicioId,medicamentoId,nombre)).apply();
    }

}
