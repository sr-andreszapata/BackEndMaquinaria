package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteVolqueta;
import co.com.a4b.maquinaria.dao.ReporteVolquetaDAO;
import co.com.a4b.maquinaria.dao.jpa.ReporteVolquetaDAOJPAImpl;

public class ReporteVolquetaNegocio {

  ReporteVolquetaDAO reporteVolquetaDAO = new ReporteVolquetaDAOJPAImpl();

  public void crearReporteVolqueta(ReporteVolqueta reporteVolqueta) {
    reporteVolquetaDAO.insertar(reporteVolqueta);
  }

  public void actualizarReporteVolqueta(ReporteVolqueta reporteVolqueta) {
    reporteVolquetaDAO.actualizar(reporteVolqueta);
  }

  public void eliminarReporteMaquina(ReporteVolqueta reporteVolqueta) {
    reporteVolquetaDAO.borrar(reporteVolqueta);
  }

  public List<ReporteVolqueta> consultarReportesVolquetas() {
    return reporteVolquetaDAO.buscarTodos();
  }

  public ReporteVolqueta consultarReporteVolqueta(int idReporteVolqueta) {
    return reporteVolquetaDAO.buscarPorClaveInt(idReporteVolqueta);
  }

  public boolean validarSiExisteElReporteVolqueta(ReporteVolqueta reporteVolqueta) {
    if (this.consultarReporteVolqueta(reporteVolqueta.getIdReporteVolqueta()) != null) {
      return true;
    } else {
      return false;
    }
  }
}
