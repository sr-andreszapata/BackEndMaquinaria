package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.TarifaSubproyectoTurnoMaquina;
import co.com.a4b.maquinaria.dao.TarifaSubproyectoTurnoMaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.TarifaSubproyectoTurnoMaquinaDAOJPAImpl;

@RestController
public class TarifaSubproyectoTurnoMaquinaService {

  TarifaSubproyectoTurnoMaquinaDAO tarifaSubproyectoTurnoMaquinaDAO =
      new TarifaSubproyectoTurnoMaquinaDAOJPAImpl();

  @RequestMapping(value = "/insertarTarifaSubproyectoTurnoMaquina", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearTarifaSubproyectoTurnoMaquina(
      @RequestBody TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    tarifaSubproyectoTurnoMaquinaDAO.insertar(tarifaSubproyectoTurnoMaquina);
    return Response.status(Status.CREATED)
        .entity("Tarifa para maquinas de acuerdo al turno creada correctamente").build();
  }

  @RequestMapping(value = "/consultarTarifasSubproyectoTurnoMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultaTarifasSubproyectoTurnoMaquina() {
    List<TarifaSubproyectoTurnoMaquina> tarifasSubproyectoTurnoMaquina =
        tarifaSubproyectoTurnoMaquinaDAO.buscarTodos();

    if (tarifasSubproyectoTurnoMaquina.isEmpty()) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontraron las tarifas para las máquinas").build();
    } else {
      return Response.status(Status.OK).entity(tarifasSubproyectoTurnoMaquina).build();
    }
  }

  @RequestMapping(value = "/eliminarTarifaSubproyectoTurnoMaquina", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarTarifaSubproyectoTurnoMaquina(
      TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {

    if (tarifaSubproyectoTurnoMaquinaDAO.buscarPorClaveInt(
        tarifaSubproyectoTurnoMaquina.getIdTarifaSubproyectoTurnoMaquina()) == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra la tarifa de la maquina que se desea borrar").build();
    } else {
      tarifaSubproyectoTurnoMaquinaDAO.borrar(tarifaSubproyectoTurnoMaquina);
      return Response.status(Status.OK).entity("Tarifa eliminada exitosamente").build();
    }
  }

  @RequestMapping(value = "/consultarTarifaSubproyectoTurnoMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarTarifaSubproyectoTurnoMaquinaId(int idTarifaSubproyectoTurnoMaquina) {
    TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina =
        tarifaSubproyectoTurnoMaquinaDAO.buscarPorClaveInt(idTarifaSubproyectoTurnoMaquina);

    if (tarifaSubproyectoTurnoMaquina == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontro la tarifa para la maquina buscada").build();
    }
    {
      return Response.status(Status.OK).entity(tarifaSubproyectoTurnoMaquina).build();
    }
  }

  @RequestMapping(value = "/actualizarTarifaSubproyectoTurnoMaquina", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarTarifaSubproyectoTurnoMaquina(
      @RequestBody TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    if (tarifaSubproyectoTurnoMaquinaDAO.buscarPorClaveInt(
        (tarifaSubproyectoTurnoMaquina.getIdTarifaSubproyectoTurnoMaquina())) == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontró la tarifa de la maquina a modificar").build();
    } else {
      tarifaSubproyectoTurnoMaquinaDAO.actualizar(tarifaSubproyectoTurnoMaquina);
      return Response.status(Status.OK).entity("Tarifa modificada exitosamente").build();
    }
  }

}
