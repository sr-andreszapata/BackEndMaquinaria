package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Subproyecto;
import co.com.a4b.maquinaria.negocio.ProyectoNegocio;
import co.com.a4b.maquinaria.negocio.SubproyectoNegocio;

@RestController
public class SubproyectoService {

  SubproyectoNegocio subproyectoNegocio = new SubproyectoNegocio();
  ProyectoNegocio proyectoNegocio = new ProyectoNegocio();

  @RequestMapping(value = "/insertarSubproyecto", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearSubproyecto(@RequestBody Subproyecto subproyecto) {

    if (proyectoNegocio.validarSiExisteElProyecto(subproyecto.getProyecto())) {
      subproyectoNegocio.crearSubproyecto(subproyecto);
      return Response.status(Status.CREATED).entity("Subproyecto creado correctamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No existe el proyecto, por favor crearlo")
          .build();
    }
  }

  @RequestMapping(value = "/consultarSubproyectos", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarSubproyectos() {

    List<Subproyecto> subproyectos = subproyectoNegocio.consultarSubproyectos();

    if (subproyectos.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron subproyectos").build();
    } else {
      return Response.status(Status.OK).entity(subproyectos).build();
    }
  }

  @RequestMapping(value = "/actualizarSubproyecto", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarSubproyecto(@RequestBody Subproyecto subproyecto) {
    if (proyectoNegocio.validarSiExisteElProyecto(subproyecto.getProyecto())) {
      if (subproyectoNegocio.validarSiExisteSubproyecto(subproyecto)) {
        subproyectoNegocio.actualizarSubproyecto(subproyecto);
        return Response.status(Status.OK).entity("Subproyecto modificado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND).entity("No se encontró el subproyecto a modificar")
            .build();
      }
    } else {
      return Response.status(Status.NOT_FOUND).entity("No existe el proyecto, por favor crearlo")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarSubproyecto", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarProyecto(Subproyecto subproyecto) {

    if (subproyectoNegocio.validarSiSePuedeEliminarElSubproyecto(subproyecto)) {
      if (subproyectoNegocio.validarSiExisteSubproyecto(subproyecto)) {
        subproyectoNegocio.eliminarSubproyecto(subproyecto);
        return Response.status(Status.OK).entity("Subproyecto eliminado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra el proyecto que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity(
              "No se puede eliminar el subproyecto porque existe información relacionada con el")
          .build();
    }
  }

  @RequestMapping(value = "/consultarSubproyecto", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarSubproyectoPorId(int idSubproyecto) {

    Subproyecto subproyecto = subproyectoNegocio.consultarSubproyecto(idSubproyecto);

    if (subproyecto == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el subproyecto buscado")
          .build();
    } else {
      return Response.status(Status.OK).entity(subproyecto).build();
    }
  }
}
