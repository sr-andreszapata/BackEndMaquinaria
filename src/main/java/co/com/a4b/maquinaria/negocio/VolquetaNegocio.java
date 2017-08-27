package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteVolqueta;
import co.com.a4b.maquinaria.bo.Volqueta;
import co.com.a4b.maquinaria.dao.VolquetaDAO;
import co.com.a4b.maquinaria.dao.jpa.VolquetaDAOJPAImpl;

public class VolquetaNegocio {

  VolquetaDAO volquetaDAO = new VolquetaDAOJPAImpl();

  public void crearVolqueta(Volqueta volqueta) {
    volquetaDAO.insertar(volqueta);
  }

  public void actualizarVolqueta(Volqueta volqueta) {
    volquetaDAO.actualizar(volqueta);
  }

  public void eliminarVolqueta(Volqueta volqueta) {
    volquetaDAO.borrar(volqueta);
  }

  public List<Volqueta> consultarVolquetas() {
    return volquetaDAO.buscarTodos();
  }

  public Volqueta consultarVolqueta(String placa) {
    return volquetaDAO.buscarPorClaveString(placa);
  }

  public boolean validarSiExisteLaVolqueta(Volqueta volqueta) {
    if (this.consultarVolqueta(volqueta.getPlaca()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarLaVolqueta(Volqueta volqueta) {
    ReporteVolquetaNegocio reporteVolquetaNegocio = new ReporteVolquetaNegocio();
    List<ReporteVolqueta> reportesVolquetas = reporteVolquetaNegocio.consultarReportesVolquetas();

    for (ReporteVolqueta reporteVolqueta : reportesVolquetas) {
      if (reporteVolqueta.getVolqueta().getPlaca().equals(volqueta.getPlaca())) {
        return false;
      }
    }
    return true;
  }
}
