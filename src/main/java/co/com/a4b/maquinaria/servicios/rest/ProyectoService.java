package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Proyecto;
import co.com.a4b.maquinaria.negocio.ClienteNegocio;
import co.com.a4b.maquinaria.negocio.ProyectoNegocio;

@RestController
public class ProyectoService {

  ProyectoNegocio proyectoNegocio = new ProyectoNegocio();
  ClienteNegocio clienteNegocio = new ClienteNegocio();

  @RequestMapping(value = "/insertarProyecto", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearRuta(@RequestBody Proyecto proyecto) {
    if (clienteNegocio.validarSiExisteElCliente(proyecto.getCliente())) {
      proyectoNegocio.crearProyecto(proyecto);
      return Response.status(Status.CREATED).entity("Proyecto creado correctamente").build();
    } else {
      return Response.status(Status.CREATED).entity("El cliente no existe, debe crearlo").build();
    }
  }

  @RequestMapping(value = "/consultarProyectos", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarProyectos() {
    List<Proyecto> proyectos = proyectoNegocio.consultarProyectos();

    if (proyectos.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron proyectos").build();
    } else {
      return Response.status(Status.OK).entity(proyectos).build();
    }
  }

  @RequestMapping(value = "/actualizarProyecto", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarProyecto(@RequestBody Proyecto proyecto) {
    if (clienteNegocio.validarSiExisteElCliente(proyecto.getCliente())) {
      if (proyectoNegocio.validarSiExisteElProyecto(proyecto)) {
        proyectoNegocio.actualizarProyecto(proyecto);
        return Response.status(Status.OK).entity("Proyecto modificado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND).entity("No se encontró el proyecto a modificar")
            .build();
      }
    } else {
      return Response.status(Status.CREATED).entity("El cliente no existe, debe crearlo").build();
    }

  }

  @RequestMapping(value = "/eliminarProyecto", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarProyecto(Proyecto proyecto) {

    if (proyectoNegocio.validarSiSePuedeEliminarElProyecto(proyecto)) {

      if (proyectoNegocio.validarSiExisteElProyecto(proyecto)) {
        proyectoNegocio.eliminarproyecto(proyecto);
        return Response.status(Status.OK).entity("Proyecto eliminado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra el proyecto que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar el proyecto porque existe información relacionada con el")
          .build();
    }
  }

  @RequestMapping(value = "/consultarProyecto", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarProyectoPorId(int idProyecto) {
    Proyecto proyecto = proyectoNegocio.consultarProyecto(idProyecto);

    if (proyecto == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el proyecto buscado").build();
    } else {
      return Response.status(Status.OK).entity(proyecto).build();
    }
  }
}
