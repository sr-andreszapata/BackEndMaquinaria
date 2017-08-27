package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Proyecto;
import co.com.a4b.maquinaria.dao.ProyectoDAO;

public class ProyectoDAOJPAImpl extends GenericDAOJPAImpl<Proyecto, String> implements ProyectoDAO {

  @Override
  public Proyecto buscarPorClaveInt(int idProyecto) {
    return super.buscarPorClaveInt(idProyecto);
  }

  @Override
  public List<Proyecto> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Proyecto proyecto) {
    super.borrar(proyecto);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Proyecto proyecto) {
    super.actualizar(proyecto);
  }

  @Override
  public void insertar(Proyecto proyecto) {
    super.insertar(proyecto);
  }

}
