package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Insumo;
import co.com.a4b.maquinaria.negocio.InsumoNegocio;

@RestController
public class InsumoService {

  InsumoNegocio insumoNegocio = new InsumoNegocio();

  @RequestMapping(value = "/insertarInsumo", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearInsumo(@RequestBody Insumo insumo) {

    if (insumoNegocio.validarSiExisteElInsumo(insumo)) {
      return Response.status(Status.CONFLICT).entity("El insumo ya existe").build();
    } else {
      insumoNegocio.crearInsumo(insumo);
      return Response.status(Status.CREATED).entity("Insumo creado correctamente").build();
    }


  }

  @RequestMapping(value = "/consultarInsumos", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarInsumos() {

    List<Insumo> insumos = insumoNegocio.consultarInsumos();

    if (insumos.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron insumos").build();
    } else {
      return Response.status(Status.OK).entity(insumos).build();
    }
  }

  @RequestMapping(value = "/actualizarInsumo", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarInsumo(@RequestBody Insumo insumo) {

    if (insumoNegocio.validarSiExisteElInsumo(insumo)) {
      insumoNegocio.actualizarInsumo(insumo);
      return Response.status(Status.OK).entity("Insumo modificado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró el insumo a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarInsumo", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarInsumo(Insumo insumo) {

    if (insumoNegocio.validarSiSePuedeEliminarElInsumo(insumo)) {
      if (insumoNegocio.validarSiExisteElInsumo(insumo)) {
        insumoNegocio.eliminarInsumo(insumo);
        return Response.status(Status.OK).entity("Insumo eliminado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra el insumo que se desea borrar").build();

      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar el insumo porque existe información relacionada con él")
          .build();
    }
  }

  @RequestMapping(value = "/consultarInsumo", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarTurnoPorId(int idInsumo) {

    Insumo insumo = insumoNegocio.buscarTurnoPorId(idInsumo);

    if (insumo == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el insumo buscado").build();
    }
    {
      return Response.status(Status.OK).entity(insumo).build();
    }
  }

}
