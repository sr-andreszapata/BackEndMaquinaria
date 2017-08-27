package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, String> {

  @Override
  List<Cliente> buscarTodos();

  @Override
  void actualizar(Cliente cliente);

  @Override
  void borrar(Cliente cliente);

  @Override
  void insertar(Cliente cliente);

  @Override
  Cliente buscarPorClaveString(String id);

}
