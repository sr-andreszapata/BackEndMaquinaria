package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Cliente;
import co.com.a4b.maquinaria.dao.ClienteDAO;

public class ClienteDAOJPAImpl extends GenericDAOJPAImpl<Cliente, String> implements ClienteDAO {

  @Override
  public Cliente buscarPorClaveString(String id) {
    return super.buscarPorClaveString(id);
  }

  @Override
  public List<Cliente> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Cliente cliente) {
    super.borrar(cliente);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Cliente cliente) {
    super.actualizar(cliente);
  }

  @Override
  public void insertar(Cliente cliente) {
    super.insertar(cliente);
  }

}
