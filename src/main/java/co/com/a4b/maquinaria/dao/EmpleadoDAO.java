package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empleado;

public interface EmpleadoDAO extends GenericDAO<Empleado, String> {

  List<Empleado> buscarTodos();

  void insertar(Empleado empleado);

  void actualizar(Empleado empleado);

  void borrar(Empleado empleado);

  Empleado buscarPorClaveString(String dni);

}
