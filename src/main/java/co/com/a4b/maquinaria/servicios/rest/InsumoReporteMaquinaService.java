package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.InsumoReporteMaquina;
import co.com.a4b.maquinaria.negocio.InsumoNegocio;
import co.com.a4b.maquinaria.negocio.InsumoReporteMaquinaNegocio;
import co.com.a4b.maquinaria.negocio.ReporteMaquinaNegocio;

@RestController
public class InsumoReporteMaquinaService {

  InsumoReporteMaquinaNegocio insumoReporteMaquinaNegocio = new InsumoReporteMaquinaNegocio();
  ReporteMaquinaNegocio reporteMaquinaNegocio = new ReporteMaquinaNegocio();
  InsumoNegocio insumoNegocio = new InsumoNegocio();

  @RequestMapping(value = "/insertarInsumoReporteMaquina", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearInsumoReporteMaquina(
      @RequestBody InsumoReporteMaquina insumoReporteMaquina) {

    if (insumoNegocio.validarSiExisteElInsumo(insumoReporteMaquina.getInsumo())) {
      if (reporteMaquinaNegocio
          .validarSiExisteElReporteMaquina(insumoReporteMaquina.getReporteMaquina())) {
        insumoReporteMaquinaNegocio.crearInsumoReporteMaquina(insumoReporteMaquina);
        return Response.status(Status.CREATED)
            .entity("Insumo de reporte maquinas creado correctamente").build();
      } else {
        return Response.status(Status.NOT_FOUND).entity("Debe crear el reporte de máquina").build();
      }
    } else {
      return Response.status(Status.NOT_FOUND).entity("Debe crear el insumo").build();
    }
  }

  @RequestMapping(value = "/consultarInsumosReportesMaquinas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarInsumosReportesMaquinas() {

    List<InsumoReporteMaquina> insumosReportesMaquinas =
        insumoReporteMaquinaNegocio.consultarInsumosReporteMaquina();
    if (insumosReportesMaquinas.isEmpty()) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontraron los insumos de reportes de máquinas").build();
    } else {
      return Response.status(Status.OK).entity(insumosReportesMaquinas).build();
    }
  }

  @RequestMapping(value = "/eliminarInsumoReporteMaquina", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarInsumoReporteMaquina(InsumoReporteMaquina insumoReporteMaquina) {

    if (insumoReporteMaquinaNegocio.vaalidarSiExisteElInsumoReporteMaquina(insumoReporteMaquina)) {
      insumoReporteMaquinaNegocio.eliminarInsumoReporteMaquina(insumoReporteMaquina);
      return Response.status(Status.OK)
          .entity("Insumo del reporte de maquinas eliminado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el insumo del reporte de maquina que se desea borrar").build();
    }
  }

  @RequestMapping(value = "/consultarInsumoReporteMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarInsumoReporteMaquinaPorId(int idInsumoReporteMaquina) {

    InsumoReporteMaquina insumoReporteMaquina =
        insumoReporteMaquinaNegocio.consultarInsumoReporteMaquina(idInsumoReporteMaquina);

    if (insumoReporteMaquina == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontro insumo de reporte de maquinas buscado").build();
    }
    {
      return Response.status(Status.OK).entity(insumoReporteMaquina).build();
    }
  }

  @RequestMapping(value = "/actualizarInsumoReporteMaquina", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarReporteMaquina(@RequestBody InsumoReporteMaquina insumoReporteMaquina) {

    if (insumoReporteMaquinaNegocio.vaalidarSiExisteElInsumoReporteMaquina(insumoReporteMaquina)) {
      insumoReporteMaquinaNegocio.actualizarInsumoReporteMaquina(insumoReporteMaquina);
      return Response.status(Status.OK)
          .entity("Insumo del reporte de maquina actualizado correctamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontró el insumo del reporte de maquinas a modificar").build();
    }
  }
}
