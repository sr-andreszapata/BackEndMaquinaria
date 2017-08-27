package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Cliente;
import co.com.a4b.maquinaria.negocio.ClienteNegocio;

@RestController
public class ClienteService {

  ClienteNegocio clienteNegocio = new ClienteNegocio();

  @RequestMapping(value = "/insertarCliente", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearCliente(@RequestBody Cliente cliente) {

    if (clienteNegocio.validarSiExisteElCliente(cliente)) {
      return Response.status(Status.NOT_FOUND)
          .entity("El cliente que esta intentando crear ya existe").build();
    } else {
      clienteNegocio.crearCliente(cliente);
      return Response.status(Status.CREATED).entity("Cliente creado correctamente").build();
    }

  }

  @RequestMapping(value = "/consultarClientes", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarClientes() {

    List<Cliente> clientes = clienteNegocio.consultarClientes();

    if (clientes.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron clientes").build();
    } else {
      return Response.status(Status.OK).entity(clientes).build();
    }

  }

  @RequestMapping(value = "/actualizarCliente", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarCliente(@RequestBody Cliente cliente) {

    if (clienteNegocio.validarSiExisteElCliente(cliente)) {
      clienteNegocio.actualizarCliente(cliente);
      return Response.status(Status.OK).entity("Cliente modificado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró el cliente a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarCliente", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarCliente(Cliente cliente) {

    if (clienteNegocio.validarSiSePuedeEliminarElCliente(cliente)) {
      if (clienteNegocio.validarSiExisteElCliente(cliente)) {
        clienteNegocio.eliminaraCliente(cliente);
        return Response.status(Status.OK).entity("Cliente eliminado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra el cliente que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar el cliente porque existe información relacionada con él")
          .build();
    }
  }

  @RequestMapping(value = "/consultarCliente", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarClientePorId(String dni) {

    Cliente cliente = clienteNegocio.buscarClientePorId(dni);

    if (cliente == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el cliente buscado").build();
    }
    {
      return Response.status(Status.OK).entity(cliente).build();
    }
  }

}
