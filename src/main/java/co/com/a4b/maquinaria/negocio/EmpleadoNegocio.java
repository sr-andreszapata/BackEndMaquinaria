package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empleado;
import co.com.a4b.maquinaria.dao.EmpleadoDAO;
import co.com.a4b.maquinaria.dao.jpa.EmpleadoDAOJPAImpl;

public class EmpleadoNegocio {

  EmpleadoDAO empleadoDAO = new EmpleadoDAOJPAImpl();

  public EmpleadoDAO getEmpleadoDAO() {
    return empleadoDAO;
  }

  public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
    this.empleadoDAO = empleadoDAO;
  }

  public void crearEmpleado(Empleado empleado) {
    empleadoDAO.insertar(empleado);
  }

  public List<Empleado> consultarEmpleados() {
    return empleadoDAO.buscarTodos();
  }

  public void actualizarEmpleado(Empleado empleado) {
    empleadoDAO.actualizar(empleado);
  }

  public void eliminarEmpleado(Empleado empleado) {
    empleadoDAO.borrar(empleado);
  }

  public Empleado buscarEmpleadoPorId(String dni) {
    return empleadoDAO.buscarPorClaveString(dni);
  }

  public boolean validarSiExisteElEmpleado(Empleado empleado) {

    if (this.buscarEmpleadoPorId(empleado.getDni()) != null) {
      return true;
    } else {
      return false;
    }
  }
}
