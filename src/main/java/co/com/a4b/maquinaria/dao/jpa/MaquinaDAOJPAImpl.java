package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Maquina;
import co.com.a4b.maquinaria.dao.MaquinaDAO;

public class MaquinaDAOJPAImpl extends GenericDAOJPAImpl<Maquina, String> implements MaquinaDAO {


  @Override
  public Maquina buscarPorClaveString(String id) {
    return super.buscarPorClaveString(id);
  }

  @Override
  public List<Maquina> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Maquina objeto) {
    super.borrar(objeto);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Maquina objeto) {
    super.actualizar(objeto);
  }

  @Override
  public void insertar(Maquina objeto) {
    super.insertar(objeto);
  }

}
