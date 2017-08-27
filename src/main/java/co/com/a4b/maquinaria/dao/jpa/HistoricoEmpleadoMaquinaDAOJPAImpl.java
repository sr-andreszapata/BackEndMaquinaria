package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.HistoricoEmpleadoMaquina;
import co.com.a4b.maquinaria.dao.HistoricoEmpledoMaquinaDAO;

public class HistoricoEmpleadoMaquinaDAOJPAImpl extends
    GenericDAOJPAImpl<HistoricoEmpleadoMaquina, String> implements HistoricoEmpledoMaquinaDAO {

  @Override
  public HistoricoEmpleadoMaquina buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

  @Override
  public List<HistoricoEmpleadoMaquina> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(HistoricoEmpleadoMaquina objeto) {
    super.borrar(objeto);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(HistoricoEmpleadoMaquina objeto) {
    super.actualizar(objeto);
  }

  @Override
  public void insertar(HistoricoEmpleadoMaquina objeto) {
    super.insertar(objeto);
  }

}
