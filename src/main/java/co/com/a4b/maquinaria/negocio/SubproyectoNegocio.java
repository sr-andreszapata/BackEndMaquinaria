package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.bo.ReporteVolqueta;
import co.com.a4b.maquinaria.bo.Subproyecto;
import co.com.a4b.maquinaria.dao.SubproyectoDAO;
import co.com.a4b.maquinaria.dao.jpa.SubproyectoDAOJPAImpl;

public class SubproyectoNegocio {

  SubproyectoDAO subproyectoDAO = new SubproyectoDAOJPAImpl();

  public void crearSubproyecto(Subproyecto subproyecto) {
    subproyectoDAO.insertar(subproyecto);
  }

  public void actualizarSubproyecto(Subproyecto subproyecto) {
    subproyectoDAO.actualizar(subproyecto);
  }

  public void eliminarSubproyecto(Subproyecto subproyecto) {
    subproyectoDAO.borrar(subproyecto);
  }

  public List<Subproyecto> consultarSubproyectos() {
    return subproyectoDAO.buscarTodos();
  }

  public Subproyecto consultarSubproyecto(int idSubproyecto) {
    return subproyectoDAO.buscarPorClaveInt(idSubproyecto);
  }

  public boolean validarSiExisteSubproyecto(Subproyecto subproyecto) {
    if (this.consultarSubproyecto(subproyecto.getIdSubproyecto()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarElSubproyecto(Subproyecto subproyecto) {
    ReporteMaquinaNegocio reporteMaquinaNegocio = new ReporteMaquinaNegocio();
    ReporteVolquetaNegocio reporteVolquetaNegocio = new ReporteVolquetaNegocio();

    List<ReporteMaquina> reportesMaquinas = reporteMaquinaNegocio.consultarReportesMaquinas();
    List<ReporteVolqueta> reportesVolquetas = reporteVolquetaNegocio.consultarReportesVolquetas();

    for (ReporteMaquina reporteMaquina : reportesMaquinas) {
      if (reporteMaquina.getSubproyecto().getIdSubproyecto() == subproyecto.getIdSubproyecto()) {
        return false;
      }
    }

    for (ReporteVolqueta reporteVolqueta : reportesVolquetas) {
      if (reporteVolqueta.getSubproyecto().getIdSubproyecto() == subproyecto.getIdSubproyecto()) {
        return false;
      }
    }
    return true;
  }
}
