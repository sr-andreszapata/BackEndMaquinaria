package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Maquina;
import co.com.a4b.maquinaria.negocio.MaquinaNegocio;

@RestController
public class MaquinaService {

  MaquinaNegocio maquinaNegocio = new MaquinaNegocio();

  @RequestMapping(value = "/insertarMaquina", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearMaquina(@RequestBody Maquina maquina) {

    if (maquinaNegocio.validarSiExisteLaMaquina(maquina)) {
      return Response.status(Status.CONFLICT)
          .entity("Ya existe la máquina que esta tratando de crear").build();
    } else {
      maquinaNegocio.crearMaquina(maquina);
      return Response.status(Status.CREATED).entity("Máquina creada correctamente").build();
    }
  }

  @RequestMapping(value = "/consultarMaquinas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarMaquinas() {

    List<Maquina> maquinas = maquinaNegocio.consultarMaquinas();

    if (maquinas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron máquinas").build();
    } else {
      return Response.status(Status.OK).entity(maquinas).build();
    }

  }

  @RequestMapping(value = "/actualizarMaquina", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarMaquina(@RequestBody Maquina maquina) {

    if (maquinaNegocio.validarSiExisteLaMaquina(maquina)) {
      maquinaNegocio.actualizarMaquina(maquina);
      return Response.status(Status.OK).entity("Máquina modificada exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontró la máquina que se desea modificar").build();
    }
  }

  @RequestMapping(value = "/eliminarMaquina", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarMaquina(Maquina maquina) {

    if (maquinaNegocio.validarSiSePuedeEliminarLaMaquina(maquina)) {
      if (maquinaNegocio.validarSiExisteLaMaquina(maquina)) {
        maquinaNegocio.eliminarMaquina(maquina);
        return Response.status(Status.OK).entity("Máquina eliminada exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra la máquina que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar la maquin porque existe información relacionada con ella")
          .build();
    }
  }

  @RequestMapping(value = "/consultarMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarMaquinaPorId(String idMaquina) {
    Maquina maquina = maquinaNegocio.buscarMaquinaPorId(idMaquina);

    if (maquina != null) {
      return Response.status(Status.OK).entity(maquina).build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontro la máquina buscada").build();
    }
  }

}
