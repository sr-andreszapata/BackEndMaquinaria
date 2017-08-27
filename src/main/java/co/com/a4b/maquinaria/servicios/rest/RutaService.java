package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Ruta;
import co.com.a4b.maquinaria.dao.RutaDAO;
import co.com.a4b.maquinaria.dao.jpa.RutaDAOJPAImpl;

@RestController
public class RutaService {

  RutaDAO rutaDAO = new RutaDAOJPAImpl();

  @RequestMapping(value = "/insertarRuta", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearRuta(@RequestBody Ruta ruta) {
    rutaDAO.insertar(ruta);
    return Response.status(Status.CREATED).entity("Ruta creada correctamente").build();
  }

  @RequestMapping(value = "/consultarRutas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarRutas() {
    List<Ruta> rutas = rutaDAO.buscarTodos();

    if (rutas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron rutas").build();
    } else {
      return Response.status(Status.OK).entity(rutas).build();
    }

  }

  @RequestMapping(value = "/actualizarRuta", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarRuta(@RequestBody Ruta ruta) {
    if (rutaDAO.buscarPorClaveInt(ruta.getIdRuta()) == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontró la ruta a modificar").build();
    } else {
      rutaDAO.actualizar(ruta);
      return Response.status(Status.OK).entity("Ruta modificada exitosamente").build();
    }
  }

  @RequestMapping(value = "/eliminarRuta", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarRuta(Ruta ruta) {

    if (rutaDAO.buscarPorClaveInt(ruta.getIdRuta()) == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encuentra la ruta que se desea borrar")
          .build();
    } else {
      rutaDAO.borrar(ruta);
      return Response.status(Status.OK).entity("Ruta eliminada exitosamente").build();
    }
  }

  @RequestMapping(value = "/consultarRuta", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarRutaPorId(int idRuta) {
    Ruta ruta = rutaDAO.buscarPorClaveInt(idRuta);

    if (ruta == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro la ruta buscada").build();
    }
    {
      return Response.status(Status.OK).entity(ruta).build();
    }
  }

}
