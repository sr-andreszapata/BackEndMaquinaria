package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empleado;
import co.com.a4b.maquinaria.bo.Empresa;
import co.com.a4b.maquinaria.dao.EmpresaDAO;
import co.com.a4b.maquinaria.dao.jpa.EmpresaDAOJPAImpl;

public class EmpresaNegocio {

  EmpresaDAO empresaDAO = new EmpresaDAOJPAImpl();

  public void crearEmpresa(Empresa empresa) {
    empresaDAO.insertar(empresa);
  }

  public List<Empresa> consultarEmpresas() {
    return empresaDAO.buscarTodos();
  }

  public void actualizarEmpresa(Empresa empresa) {
    empresaDAO.actualizar(empresa);
  }

  public void eliminarEmpresa(Empresa empresa) {
    empresaDAO.borrar(empresa);
  }

  public Empresa buscarEmpresaPorId(String dni) {
    return empresaDAO.buscarPorClaveString(dni);
  }

  public boolean validarSiExisteLaEmpresa(Empresa empresa) {

    if (this.buscarEmpresaPorId(empresa.getDni()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarLaEmpresa(Empresa empresa) {
    EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio();
    List<Empleado> empleados = empleadoNegocio.consultarEmpleados();

    for (Empleado empleado : empleados) {
      if (empleado.getEmpresa().getDni().equals(empresa.getDni())) {
        return false;
      }
    }
    return true;
  }
}
