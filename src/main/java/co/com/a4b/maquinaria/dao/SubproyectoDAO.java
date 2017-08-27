package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Subproyecto;

public interface SubproyectoDAO extends GenericDAO<Subproyecto, String> {

  @Override
  List<Subproyecto> buscarTodos();

  @Override
  void actualizar(Subproyecto subproyecto);

  @Override
  void borrar(Subproyecto subproyecto);

  @Override
  void insertar(Subproyecto subproyecto);

  @Override
  Subproyecto buscarPorClaveInt(int idSubproyecto);

}
