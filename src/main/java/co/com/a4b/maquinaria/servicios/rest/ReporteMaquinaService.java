package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.negocio.ActividadNegocio;
import co.com.a4b.maquinaria.negocio.MaquinaNegocio;
import co.com.a4b.maquinaria.negocio.ReporteMaquinaNegocio;
import co.com.a4b.maquinaria.negocio.SubproyectoNegocio;
import co.com.a4b.maquinaria.negocio.TurnoNegocio;


@RestController
public class ReporteMaquinaService {

  ReporteMaquinaNegocio reporteMaquinaNegocio = new ReporteMaquinaNegocio();
  ActividadNegocio actividadNegocio = new ActividadNegocio();
  TurnoNegocio turnoNegocio = new TurnoNegocio();
  MaquinaNegocio maquinaNegocio = new MaquinaNegocio();
  SubproyectoNegocio subproyectoNegocio = new SubproyectoNegocio();

  @RequestMapping(value = "/insertarReporteMaquina", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearReporteMaquina(@RequestBody ReporteMaquina reporteMaquina) {

    if (actividadNegocio.validarSiExisteLaActividad(reporteMaquina.getActividad())) {
      if (turnoNegocio.validarSiExisteElTurno(reporteMaquina.getTurno())) {
        if (maquinaNegocio.validarSiExisteLaMaquina(reporteMaquina.getMaquina())) {
          if (subproyectoNegocio.validarSiExisteSubproyecto(reporteMaquina.getSubproyecto())) {
            reporteMaquinaNegocio.crearReporteMaquina(reporteMaquina);
            return Response.status(Status.CREATED).entity("Reporte maquinas creado correctamente")
                .build();
          } else {
            return Response.status(Status.NOT_FOUND)
                .entity("No se encuentra el subproyecto, por favor crearlo").build();
          }
        } else {
          return Response.status(Status.NOT_FOUND)
              .entity("No se encuentra la maquina, por favor crearla").build();
        }
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra el turno, por favor crearlo").build();
      }
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra la actividad, por favor crearla").build();
    }
  }

  @RequestMapping(value = "/consultarReportesMaquinas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarReportesMaquinas() {

    List<ReporteMaquina> reportesMaquinas = reporteMaquinaNegocio.consultarReportesMaquinas();

    if (reportesMaquinas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron los reportes de máquinas")
          .build();
    } else {
      return Response.status(Status.OK).entity(reportesMaquinas).build();
    }
  }

  @RequestMapping(value = "/eliminarReporteMaquina", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarReporteMaquina(ReporteMaquina reporteMaquina) {

    if (reporteMaquinaNegocio.validarSiExisteElReporteMaquina(reporteMaquina)) {
      reporteMaquinaNegocio.eliminarReporteMaquina(reporteMaquina);
      return Response.status(Status.OK).entity("Reporte de maquinas eliminado exitosamente")
          .build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el reporte de maquina que se desea borrar").build();
    }
  }

  @RequestMapping(value = "/consultarReporteMaquina", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarReporteMaquinaPorId(int idReporteMaquina) {

    ReporteMaquina reporteMaquina = reporteMaquinaNegocio.consultarReporteMaquina(idReporteMaquina);

    if (reporteMaquina == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro reporte de maquinas buscado")
          .build();
    } else {
      return Response.status(Status.OK).entity(reporteMaquina).build();
    }
  }

  @RequestMapping(value = "/actualizarReporteMaquina", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarReporteMaquina(@RequestBody ReporteMaquina reporteMaquina) {

    if (reporteMaquinaNegocio.validarSiExisteElReporteMaquina(reporteMaquina)) {
      reporteMaquinaNegocio.actualizarReporteMaaquina(reporteMaquina);
      return Response.status(Status.OK).entity("Reporte de maquinas modificado exitosamente")
          .build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontró el reporte de maquinas a modificar").build();
    }
  }
}
