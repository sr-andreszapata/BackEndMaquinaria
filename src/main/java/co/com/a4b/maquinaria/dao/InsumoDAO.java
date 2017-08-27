package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Insumo;

public interface InsumoDAO extends GenericDAO<Insumo, String> {

  @Override
  List<Insumo> buscarTodos();

  @Override
  void actualizar(Insumo insumo);

  @Override
  void borrar(Insumo insumo);

  @Override
  void insertar(Insumo insumo);

  @Override
  Insumo buscarPorClaveInt(int id);

}
