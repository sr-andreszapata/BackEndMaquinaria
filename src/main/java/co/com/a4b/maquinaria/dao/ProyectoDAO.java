package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Proyecto;

public interface ProyectoDAO extends GenericDAO<Proyecto, String> {

  @Override
  List<Proyecto> buscarTodos();

  @Override
  void actualizar(Proyecto proyecto);

  @Override
  void borrar(Proyecto proyecto);

  @Override
  void insertar(Proyecto proyecto);

  @Override
  Proyecto buscarPorClaveInt(int idProyecto);

}
