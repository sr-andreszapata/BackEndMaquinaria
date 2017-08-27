package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Actividad;

public interface ActividadDAO extends GenericDAO<Actividad, String> {

  @Override
  List<Actividad> buscarTodos();

  @Override
  void actualizar(Actividad actividad);

  @Override
  void borrar(Actividad actividad);

  @Override
  void insertar(Actividad actividad);

  @Override
  Actividad buscarPorClaveInt(int idActividad);

}
