package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Turno;
import co.com.a4b.maquinaria.negocio.TurnoNegocio;

@RestController
public class TurnoService {

  TurnoNegocio turnoNegocio = new TurnoNegocio();

  @RequestMapping(value = "/insertarTurno", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearTurno(@RequestBody Turno turno) {
    turnoNegocio.crearTurno(turno);
    return Response.status(Status.CREATED).entity("Turno creado correctamente").build();
  }

  @RequestMapping(value = "/consultarTurnos", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarTurnos() {

    List<Turno> turnos = turnoNegocio.consultarTurnos();

    if (turnos.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron turnos").build();
    } else {
      return Response.status(Status.OK).entity(turnos).build();
    }

  }

  @RequestMapping(value = "/actualizarTurno", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarTurno(@RequestBody Turno turno) {
    if (turnoNegocio.validarSiExisteElTurno(turno)) {
      turnoNegocio.actualizarTurno(turno);
      return Response.status(Status.OK).entity("Turno modificado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró el turno a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarTurno", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarTurno(Turno turno) {

    if (turnoNegocio.validarSiExisteElTurno(turno)) {
      turnoNegocio.eliminarTurno(turno);
      return Response.status(Status.OK).entity("Turno eliminado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el turno que se desea borrar").build();
    }
  }

  @RequestMapping(value = "/consultarTurno", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarTurnoPorId(int idTurno) {

    Turno turno = turnoNegocio.consultarTurno(idTurno);

    if (turno == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el turno buscado").build();
    } else {
      return Response.status(Status.OK).entity(turno).build();
    }
  }
}
