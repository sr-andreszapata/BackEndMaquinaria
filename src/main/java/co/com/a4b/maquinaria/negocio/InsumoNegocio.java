package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Insumo;
import co.com.a4b.maquinaria.bo.InsumoReporteMaquina;
import co.com.a4b.maquinaria.dao.InsumoDAO;
import co.com.a4b.maquinaria.dao.jpa.InsumoDAOJPAImpl;

public class InsumoNegocio {

  InsumoDAO insumoDAO = new InsumoDAOJPAImpl();

  public void crearInsumo(Insumo insumo) {
    insumoDAO.insertar(insumo);
  }

  public Insumo buscarTurnoPorId(int idInsumo) {
    return insumoDAO.buscarPorClaveInt(idInsumo);
  }

  public List<Insumo> consultarInsumos() {
    return insumoDAO.buscarTodos();
  }

  public void actualizarInsumo(Insumo insumo) {
    insumoDAO.actualizar(insumo);
  }

  public void eliminarInsumo(Insumo insumo) {
    insumoDAO.borrar(insumo);
  }

  public boolean validarSiExisteElInsumo(Insumo insumo) {
    if (this.buscarTurnoPorId(insumo.getIdInsumo()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarElInsumo(Insumo insumo) {
    InsumoReporteMaquinaNegocio insumoReporteMaquinaNegocio = new InsumoReporteMaquinaNegocio();
    List<InsumoReporteMaquina> insumodReportesMaquinas =
        insumoReporteMaquinaNegocio.consultarInsumosReporteMaquina();

    for (InsumoReporteMaquina insumoReporteMaquina : insumodReportesMaquinas) {
      if (insumoReporteMaquina.getInsumo().getIdInsumo() == insumo.getIdInsumo()) {
        return false;
      }
    }
    return true;
  }
}
