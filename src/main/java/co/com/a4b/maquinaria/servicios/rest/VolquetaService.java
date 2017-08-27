package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Volqueta;
import co.com.a4b.maquinaria.negocio.VolquetaNegocio;

@RestController
public class VolquetaService {

  VolquetaNegocio volquetaNegocio = new VolquetaNegocio();

  @RequestMapping(value = "/insertarVolqueta", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearVolqueta(@RequestBody Volqueta volqueta) {

    if (volquetaNegocio.validarSiExisteLaVolqueta(volqueta)) {
      return Response.status(Status.CONFLICT).entity("La Volqueta ya existe").build();
    } else {
      volquetaNegocio.crearVolqueta(volqueta);
      return Response.status(Status.CREATED).entity("Volqueta creada correctamente").build();
    }
  }

  @RequestMapping(value = "/consultarVolquetas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarVolquetas() {
    List<Volqueta> volquetas = volquetaNegocio.consultarVolquetas();

    if (volquetas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron Volquetas").build();
    } else {
      return Response.status(Status.OK).entity(volquetas).build();
    }

  }

  @RequestMapping(value = "/actualizarVolqueta", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarVolqueta(@RequestBody Volqueta volqueta) {

    if (volquetaNegocio.validarSiExisteLaVolqueta(volqueta)) {
      volquetaNegocio.actualizarVolqueta(volqueta);
      return Response.status(Status.OK).entity("Volqueta modificada exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró la volqueta a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarVolqueta", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarVolqueta(Volqueta volqueta) {

    if (volquetaNegocio.validarSiSePuedeEliminarLaVolqueta(volqueta)) {
      if (volquetaNegocio.validarSiExisteLaVolqueta(volqueta)) {
        volquetaNegocio.eliminarVolqueta(volqueta);
        return Response.status(Status.OK).entity("Volqueta eliminada exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra la volqueta que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar la volqueta porque existe información relacionada con ella")
          .build();
    }

  }

  @RequestMapping(value = "/consultarVolqueta", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarVolquetaPorId(String placa) {
    Volqueta volqueta = volquetaNegocio.consultarVolqueta(placa);

    if (volqueta == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro la volqueta buscada").build();
    } else {
      return Response.status(Status.OK).entity(volqueta).build();
    }
  }
}
