package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empleado;
import co.com.a4b.maquinaria.dao.EmpleadoDAO;

public class EmpleadoDAOJPAImpl extends GenericDAOJPAImpl<Empleado, String> implements EmpleadoDAO {

  @Override
  public Empleado buscarPorClaveString(String dni) {
    return super.buscarPorClaveString(dni);
  }

  @Override
  public List<Empleado> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Empleado empleado) {
    super.borrar(empleado);
  }

  @Override
  public void actualizar(Empleado empleado) {
    super.actualizar(empleado);
  }

  @Override
  public void insertar(Empleado empleado) {
    super.insertar(empleado);
  }

}
