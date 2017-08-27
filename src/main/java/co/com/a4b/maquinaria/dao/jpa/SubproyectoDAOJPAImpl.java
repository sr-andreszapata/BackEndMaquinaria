package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Subproyecto;
import co.com.a4b.maquinaria.dao.SubproyectoDAO;

public class SubproyectoDAOJPAImpl extends GenericDAOJPAImpl<Subproyecto, String>
    implements SubproyectoDAO {

  @Override
  public Subproyecto buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

  @Override
  public List<Subproyecto> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Subproyecto objeto) {
    super.borrar(objeto);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Subproyecto objeto) {
    super.actualizar(objeto);
  }

  @Override
  public void insertar(Subproyecto objeto) {
    super.insertar(objeto);
  }

}
