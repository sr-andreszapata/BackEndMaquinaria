package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.InsumoReporteMaquina;
import co.com.a4b.maquinaria.dao.InsumoReporteMaquinaDAO;

public class InsumoReporteMaquinaDAOJPAImpl extends GenericDAOJPAImpl<InsumoReporteMaquina, String>
    implements InsumoReporteMaquinaDAO {

  @Override
  public InsumoReporteMaquina buscarPorClaveInt(int idInsumoReporteMaquina) {
    return super.buscarPorClaveInt(idInsumoReporteMaquina);
  }

  @Override
  public List<InsumoReporteMaquina> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(InsumoReporteMaquina insumoReporteMaquina) {
    super.borrar(insumoReporteMaquina);
  }


  @Override
  public void actualizar(InsumoReporteMaquina insumoReporteMaquina) {
    super.actualizar(insumoReporteMaquina);
  }

  @Override
  public void insertar(InsumoReporteMaquina insumoReporteMaquina) {
    super.insertar(insumoReporteMaquina);
  }

}
