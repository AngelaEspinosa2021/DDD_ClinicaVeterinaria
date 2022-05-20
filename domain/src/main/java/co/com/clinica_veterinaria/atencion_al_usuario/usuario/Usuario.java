package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected FechaDeCreacion fechaDeCreacion;
    protected Dueño dueño;
    protected Paciente paciente;
    protected Set<HistoriaMedica> historiasMedicas;

    public Usuario(UsuarioId usuarioId, FechaDeCreacion fechaDeCreacion){
        super(usuarioId);
        appendChange( new UsuarioCreado(fechaDeCreacion)).apply();
    }

    private Usuario(UsuarioId usurioId){
        super(usurioId);
        subscribe(new UsuarioEventChange(this));
    }

    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events){
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    public void agregarDueño(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, FechaDeNacimiento fechaDeNacimiento){
        appendChange(new DueñoCreado(dueñoId,nombreCompleto,datosDeContacto,fechaDeNacimiento)).apply();
    }

    public void agregarPaciente(PacienteId pacienteId, NombreCompleto nombreCompleto, FechaDeNacimiento fechaDeNacimiento){
        appendChange( new PacienteCreado(pacienteId,nombreCompleto,fechaDeNacimiento)).apply();
    }

    public void crearHistoriaMedica(HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion){
        appendChange( new HistoriaMedicaCreada(historiaMedicaId,fecha,descripcion));
    }

    public void actualizarFechaDeCreacion(FechaDeCreacion fechaDeCreacion){
        appendChange( new FechaDeCreacionActualizada(fechaDeCreacion)).apply();
    }

    public void actualizarDescripcionDeHistoriaMedica(HistoriaMedicaId historiaMedicaId, Descripcion descripcion){
        appendChange(new DescripcionDeHistoriaMedicaActualizada(historiaMedicaId,descripcion)).apply();
    }

    public void asociarMedicoAHistoriaMedica(HistoriaMedicaId historiaMedicaId, InformacionDeMedico informacionDeMedico){
        appendChange(new MedicoDeHistoriaMedicaAsociado(historiaMedicaId,informacionDeMedico)).apply();
    }

    public void actualizarNombreCompletoDePaciente(PacienteId pacienteId, NombreCompleto nombreCompleto){
        appendChange( new NombreCompletoPacienteActualizado(pacienteId,nombreCompleto)).apply();
    }

    public void actualizarDatosDeContactoDeDueño(DueñoId dueñoId, DatosDeContacto datosDeContacto){
        appendChange(new DatosDeContactoDeDueñoActualizados(dueñoId,datosDeContacto)).apply();
    }

    public void actualizarNombreCompletoDeDueño(DueñoId dueñoId, NombreCompleto nombreCompleto){
        appendChange(new NombreCompletoDeDueñoActualizado(dueñoId,nombreCompleto)).apply();
    }

    public void agregarObservacionAHistoriaMedica(HistoriaMedicaId historiaMedicaId, Observacion observacion){
        appendChange(new ObservacionDeHistoriaMedicaAgregada(historiaMedicaId,observacion)).apply();
    }

    protected Optional<HistoriaMedica> getHistoriaMedicaById(HistoriaMedicaId historiaMedicaId){
        return historiasMedicas().stream().filter(funcion -> funcion.identity().equals(historiaMedicaId)).findFirst();
    }

    public FechaDeCreacion fechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Dueño dueño() {
        return dueño;
    }

    public Paciente paciente() {
        return paciente;
    }

    public Set<HistoriaMedica> historiasMedicas() {
        return historiasMedicas;
    }
}
