package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Actividad;
import co.com.a4b.maquinaria.dao.ActividadDAO;

public class ActividadDAOJPAImpl extends GenericDAOJPAImpl<Actividad, String>
    implements ActividadDAO {

  @Override
  public Actividad buscarPorClaveInt(int idActividad) {
    return super.buscarPorClaveInt(idActividad);
  }

  @Override
  public List<Actividad> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Actividad actividad) {
    super.borrar(actividad);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Actividad actividad) {
    super.actualizar(actividad);
  }

  @Override
  public void insertar(Actividad actividad) {
    super.insertar(actividad);
  }

}
