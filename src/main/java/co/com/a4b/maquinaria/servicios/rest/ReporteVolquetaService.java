package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.ReporteVolqueta;
import co.com.a4b.maquinaria.negocio.ReporteVolquetaNegocio;
import co.com.a4b.maquinaria.negocio.RutaNegocio;
import co.com.a4b.maquinaria.negocio.SubproyectoNegocio;
import co.com.a4b.maquinaria.negocio.TurnoNegocio;

@RestController
public class ReporteVolquetaService {

  ReporteVolquetaNegocio reporteVolquetaNegocio = new ReporteVolquetaNegocio();
  SubproyectoNegocio subproyectoNegocio = new SubproyectoNegocio();
  TurnoNegocio turnoNegocio = new TurnoNegocio();
  RutaNegocio rutaNegocio = new RutaNegocio();

  @RequestMapping(value = "/insertarReporteVolqueta", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearReporteVolqueta(@RequestBody ReporteVolqueta reporteVolqueta) {

    if (subproyectoNegocio.validarSiExisteSubproyecto(reporteVolqueta.getSubproyecto())) {
      if (turnoNegocio.validarSiExisteElTurno(reporteVolqueta.getTurno())) {
        if (rutaNegocio.validarSiExisteLaRuta(reporteVolqueta.getRuta())) {
          reporteVolquetaNegocio.crearReporteVolqueta(reporteVolqueta);
          return Response.status(Status.CREATED).entity("Reporte de volqueta creado correctamente")
              .build();
        } else {
          return Response.status(Status.CREATED).entity("La ruta no existe, debe crearla").build();
        }
      } else {
        return Response.status(Status.CREATED).entity("El turno no existe, debe crearlo").build();
      }
    } else {
      return Response.status(Status.CREATED).entity("El subproyecto no existe, debe crearlo")
          .build();
    }
  }

  @RequestMapping(value = "/consultarReportesVolquetas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarReportesVolquetas() {

    List<ReporteVolqueta> reportesVolquetas = reporteVolquetaNegocio.consultarReportesVolquetas();

    if (reportesVolquetas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron los reportes de volquetas")
          .build();
    } else {
      return Response.status(Status.OK).entity(reportesVolquetas).build();
    }
  }

  @RequestMapping(value = "/eliminarReporteVolqueta", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarReporteVolqueta(ReporteVolqueta reporteVolqueta) {

    if (reporteVolquetaNegocio.validarSiExisteElReporteVolqueta(reporteVolqueta)) {
      reporteVolquetaNegocio.eliminarReporteMaquina(reporteVolqueta);
      return Response.status(Status.OK).entity("Reporte de la volqueta eliminado exitosamente")
          .build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el reporte de la volqueta que se desea borrar").build();
    }
  }

  @RequestMapping(value = "/consultarReporteVolqueta", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarReporteVolquetaPorId(int idReporteVolqueta) {
    ReporteVolqueta reporteVolqueta =
        reporteVolquetaNegocio.consultarReporteVolqueta(idReporteVolqueta);

    if (reporteVolqueta == null) {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontro reporte de la volqueta buscado").build();
    }
    {
      return Response.status(Status.OK).entity(reporteVolqueta).build();
    }
  }

  @RequestMapping(value = "/actualizarReporteVolqueta", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarReporteVolqueta(@RequestBody ReporteVolqueta reporteVolqueta) {

    if (reporteVolquetaNegocio.validarSiExisteElReporteVolqueta(reporteVolqueta)) {
      if (subproyectoNegocio.validarSiExisteSubproyecto(reporteVolqueta.getSubproyecto())) {
        if (turnoNegocio.validarSiExisteElTurno(reporteVolqueta.getTurno())) {
          if (rutaNegocio.validarSiExisteLaRuta(reporteVolqueta.getRuta())) {
            reporteVolquetaNegocio.actualizarReporteVolqueta(reporteVolqueta);
            return Response.status(Status.OK).entity("Reporte de volquetas modificado exitosamente")
                .build();
          } else {
            return Response.status(Status.NOT_FOUND).entity("La ruta no existe, debe crearla")
                .build();
          }
        } else {
          return Response.status(Status.NOT_FOUND).entity("El turno no existe, debe crearlo")
              .build();
        }
      } else {
        return Response.status(Status.NOT_FOUND).entity("El subproyecto no existe, debe crearlo")
            .build();
      }
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encontró el reporte de la volqueta a  modificar").build();
    }
  }
}
