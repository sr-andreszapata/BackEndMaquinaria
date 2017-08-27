package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Cliente;
import co.com.a4b.maquinaria.bo.Proyecto;
import co.com.a4b.maquinaria.dao.ClienteDAO;
import co.com.a4b.maquinaria.dao.jpa.ClienteDAOJPAImpl;

public class ClienteNegocio {

  ClienteDAO clienteDAO = new ClienteDAOJPAImpl();


  public void crearCliente(Cliente cliente) {
    clienteDAO.insertar(cliente);
  }

  public List<Cliente> consultarClientes() {
    return clienteDAO.buscarTodos();
  }

  public void actualizarCliente(Cliente cliente) {
    clienteDAO.actualizar(cliente);
  }

  public void eliminaraCliente(Cliente cliente) {
    clienteDAO.borrar(cliente);
  }

  public Cliente buscarClientePorId(String dni) {
    return clienteDAO.buscarPorClaveString(dni);
  }

  public boolean validarSiExisteElCliente(Cliente cliente) {
    if (this.buscarClientePorId(cliente.getDni()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarElCliente(Cliente cliente) {
    ProyectoNegocio proyectoNegocio = new ProyectoNegocio();
    List<Proyecto> proyectos = proyectoNegocio.consultarProyectos();

    for (Proyecto proyecto : proyectos) {
      if (proyecto.getCliente().getDni().equals(cliente.getDni())) {
        return false;
      }
    }
    return true;
  }
}
