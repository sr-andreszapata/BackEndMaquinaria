package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.dao.ReporteMaquinaDAO;

public class ReporteMaquinaDAOJPAImpl extends GenericDAOJPAImpl<ReporteMaquina, String>
    implements ReporteMaquinaDAO {

  @Override
  public List<ReporteMaquina> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(ReporteMaquina objeto) {
    super.borrar(objeto);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(ReporteMaquina objeto) {
    super.actualizar(objeto);
  }

  @Override
  public void insertar(ReporteMaquina objeto) {
    super.insertar(objeto);
  }

  @Override
  public ReporteMaquina buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

}
