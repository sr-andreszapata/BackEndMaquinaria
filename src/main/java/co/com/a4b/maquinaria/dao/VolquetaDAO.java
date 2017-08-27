package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Volqueta;

public interface VolquetaDAO extends GenericDAO<Volqueta, String> {

  @Override
  List<Volqueta> buscarTodos();

  @Override
  void actualizar(Volqueta volqueta);

  @Override
  void borrar(Volqueta volqueta);

  @Override
  void insertar(Volqueta volqueta);

  @Override
  Volqueta buscarPorClaveString(String placa);

}
