package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.InsumoReporteMaquina;
import co.com.a4b.maquinaria.dao.InsumoReporteMaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.InsumoReporteMaquinaDAOJPAImpl;

public class InsumoReporteMaquinaNegocio {

  InsumoReporteMaquinaDAO insumoReporteMaquinaDAO = new InsumoReporteMaquinaDAOJPAImpl();

  public List<InsumoReporteMaquina> consultarInsumosReporteMaquina() {
    return insumoReporteMaquinaDAO.buscarTodos();
  }

  public void crearInsumoReporteMaquina(InsumoReporteMaquina insumoReporteMaquina) {
    insumoReporteMaquinaDAO.insertar(insumoReporteMaquina);
  }

  public void actualizarInsumoReporteMaquina(InsumoReporteMaquina insumoReporteMaquina) {
    insumoReporteMaquinaDAO.actualizar(insumoReporteMaquina);
  }

  public void eliminarInsumoReporteMaquina(InsumoReporteMaquina insumoReporteMaquina) {
    insumoReporteMaquinaDAO.borrar(insumoReporteMaquina);
  }

  public InsumoReporteMaquina consultarInsumoReporteMaquina(int idInsumoReporteMaquina) {
    return insumoReporteMaquinaDAO.buscarPorClaveInt(idInsumoReporteMaquina);
  }

  public boolean vaalidarSiExisteElInsumoReporteMaquina(InsumoReporteMaquina insumoReporteMaquina) {
    if (this
        .consultarInsumoReporteMaquina(insumoReporteMaquina.getIdInsumoReporteMaquina()) != null) {
      return true;
    } else {
      return false;
    }
  }

}
