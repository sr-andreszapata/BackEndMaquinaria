package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.HistoricoEmpleadoMaquina;
import co.com.a4b.maquinaria.negocio.EmpleadoNegocio;
import co.com.a4b.maquinaria.negocio.HistoricoEmpleadoMaquinaNegocio;
import co.com.a4b.maquinaria.negocio.MaquinaNegocio;

@RestController
public class HistoricoEmpleadoMaquinaService {

  HistoricoEmpleadoMaquinaNegocio historicoEmpleadoMaquinaNegocio =
      new HistoricoEmpleadoMaquinaNegocio();
  EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio();
  MaquinaNegocio maquinaNegocio = new MaquinaNegocio();

  @RequestMapping(value = "/insertarAsignacionMaquinaEmpleado", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearAsignacionMaquinaEmpleado(
      @RequestBody HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {

    if (empleadoNegocio.validarSiExisteElEmpleado(historicoEmpleadoMaquina.getEmpleado())) {
      if (maquinaNegocio.validarSiExisteLaMaquina(historicoEmpleadoMaquina.getMaquina())) {
        if (historicoEmpleadoMaquinaNegocio
            .validarSiExisteHistoricoEmpleadoMaquina(historicoEmpleadoMaquina)) {
          return Response.status(Status.CONFLICT)
              .entity("Ya existe el registro historico del empleado en la máquina").build();
        } else {
          historicoEmpleadoMaquinaNegocio.crearAsignacionMaquinaEmpleado(historicoEmpleadoMaquina);
          return Response.status(Status.CREATED)
              .entity("Se creo registro de Historico Empleado Maquina correctamente").build();
        }
      } else {
        return Response.status(Status.NOT_FOUND).entity("Primero debe crear la máquina").build();
      }

    } else {
      return Response.status(Status.NOT_FOUND).entity("Primero debe crear el empleado").build();
    }

  }

  @RequestMapping(value = "/consultarHistoricoEmpleadoMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarHistoricoEmpleadoMaquina() {

    List<HistoricoEmpleadoMaquina> historicosEmpleadoMaquina =
        historicoEmpleadoMaquinaNegocio.consultarHistoricosEmpleadosMaquinas();

    if (historicosEmpleadoMaquina.isEmpty()) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontraron registros en la historia de empleados por máquina").build();
    } else {
      return Response.status(Status.OK).entity(historicosEmpleadoMaquina).build();
    }
  }

  @RequestMapping(value = "/actualizarHistoricoEmpledoMaquina", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarHistoricoEmpledoMaquina(
      @RequestBody HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {

    if (empleadoNegocio.validarSiExisteElEmpleado(historicoEmpleadoMaquina.getEmpleado())) {
      if (maquinaNegocio.validarSiExisteLaMaquina(historicoEmpleadoMaquina.getMaquina())) {
        if (historicoEmpleadoMaquinaNegocio
            .validarSiExisteHistoricoEmpleadoMaquina(historicoEmpleadoMaquina)) {
          historicoEmpleadoMaquinaNegocio
              .actualizarHistoricoEmpledoMaquina(historicoEmpleadoMaquina);
          return Response.status(Status.OK).entity("Máquina modificada exitosamente").build();
        } else {
          return Response.status(Status.NOT_FOUND)
              .entity("No se encontró el registro de la historia a modificar").build();
        }
      } else {
        return Response.status(Status.NOT_FOUND).entity("La máquina no existe").build();
      }
    } else {
      return Response.status(Status.NOT_FOUND).entity("El empleado no existe").build();
    }
  }

  @RequestMapping(value = "/eliminarRegistroHistoricoMaquinaEmpleado",
      method = RequestMethod.DELETE, produces = "application/json")
  public Response eliminarRegistroHistoricoMaquinaEmpleado(
      HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {

    if (historicoEmpleadoMaquinaNegocio
        .validarSiExisteHistoricoEmpleadoMaquina(historicoEmpleadoMaquina)) {
      historicoEmpleadoMaquinaNegocio
          .eliminarRegistroHistoricoMaquinaEmpleado(historicoEmpleadoMaquina);
      return Response.status(Status.OK)
          .entity("Registro del historico Empleado Maquina eliminado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el registro del histórico Empleado Maquina que se desea borrar")
          .build();
    }
  }

  @RequestMapping(value = "/consultarRegistroHistoricoEmpleadoMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarHistoricoEmpleadoMaquinaPorId(int idHistoricoEmpleaadoMaquina) {
    HistoricoEmpleadoMaquina historicoEmpleadoMaquina = historicoEmpleadoMaquinaNegocio
        .buscarHistoricoEmpleadoMaquinaPorId(idHistoricoEmpleaadoMaquina);

    if (historicoEmpleadoMaquina == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontro el registro en el histórico de empleado maquina buscado").build();
    }
    {
      return Response.status(Status.OK).entity(historicoEmpleadoMaquina).build();
    }
  }
}
