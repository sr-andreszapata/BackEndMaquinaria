package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Maquina;

public interface MaquinaDAO extends GenericDAO<Maquina, String> {

  @Override
  List<Maquina> buscarTodos();

  @Override
  void actualizar(Maquina maquina);

  @Override
  void borrar(Maquina maquina);

  @Override
  void insertar(Maquina maquina);

  @Override
  Maquina buscarPorClaveString(String idMaquina);

}
