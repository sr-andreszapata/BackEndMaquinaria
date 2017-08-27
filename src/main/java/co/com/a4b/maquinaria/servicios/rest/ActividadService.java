package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Actividad;
import co.com.a4b.maquinaria.negocio.ActividadNegocio;

@RestController
public class ActividadService {

  ActividadNegocio actividadNegocio = new ActividadNegocio();

  @RequestMapping(value = "/insertarActividad", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearActividad(@RequestBody Actividad actividad) {
    if (actividadNegocio.validarSiExisteUnaActividadConDescripcionIgual(actividad)) {
      return Response.status(Status.NOT_FOUND).entity("Ya existe una actividad con esa descripción")
          .build();
    } else {
      actividadNegocio.crearActividad(actividad);
      return Response.status(Status.CREATED).entity("Actividad creada correctamente").build();
    }

  }

  @RequestMapping(value = "/consultarActividades", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarActividades() {
    List<Actividad> actividades = actividadNegocio.consultarActividades();

    if (actividades.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron actividades").build();
    } else {
      return Response.status(Status.OK).entity(actividades).build();
    }

  }

  @RequestMapping(value = "/actualizarActividad", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarActividad(@RequestBody Actividad actividad) {
    if (actividadNegocio.validarSiExisteLaActividad(actividad)) {
      if (actividadNegocio.validarSiExisteUnaActividadConDescripcionIgual(actividad)) {
        return Response.status(Status.NOT_FOUND)
            .entity("Ya existe una actividad con esa descripción").build();
      } else {
        actividadNegocio.actualizarActividad(actividad);
        return Response.status(Status.OK).entity("Actividad modificada exitosamente").build();
      }

    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró la actividad a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarActividad", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarActividad(Actividad actividad) {

    if (actividadNegocio.validarSiSePuedeEliminarLaActividad(actividad)) {
      if (actividadNegocio.validarSiExisteLaActividad(actividad)) {
        actividadNegocio.eliminarActividad(actividad);
        return Response.status(Status.OK).entity("Actividad eliminada exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra la actividad que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity(
              "No se puede eliminar la actividad porque existe información relacionada con ella")
          .build();
    }

  }

  @RequestMapping(value = "/consultarActividad", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarActividadPorId(int idActividad) {
    Actividad actividad = actividadNegocio.buscarActividadPorId(idActividad);


    if (actividad != null) {
      return Response.status(Status.OK).entity(actividad).build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontro la actividad buscada")
          .build();
    }
  }

}
