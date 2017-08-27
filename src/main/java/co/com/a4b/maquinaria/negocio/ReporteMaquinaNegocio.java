package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.dao.ReporteMaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.ReporteMaquinaDAOJPAImpl;

public class ReporteMaquinaNegocio {

  ReporteMaquinaDAO reporteMaquinaDAO = new ReporteMaquinaDAOJPAImpl();

  public List<ReporteMaquina> consultarReportesMaquinas() {
    return reporteMaquinaDAO.buscarTodos();
  }

  public void crearReporteMaquina(ReporteMaquina reporteMaquina) {
    reporteMaquinaDAO.insertar(reporteMaquina);
  }

  public void actualizarReporteMaaquina(ReporteMaquina reporteMaquina) {
    reporteMaquinaDAO.actualizar(reporteMaquina);
  }

  public void eliminarReporteMaquina(ReporteMaquina reporteMaquina) {
    reporteMaquinaDAO.borrar(reporteMaquina);
  }

  public ReporteMaquina consultarReporteMaquina(int idReporteMaquina) {
    return reporteMaquinaDAO.buscarPorClaveInt(idReporteMaquina);
  }

  public boolean validarSiExisteElReporteMaquina(ReporteMaquina reporteMaquina) {
    if (this.consultarReporteMaquina(reporteMaquina.getIdReporteMaquina()) != null) {
      return true;
    } else {
      return false;
    }
  }

}
