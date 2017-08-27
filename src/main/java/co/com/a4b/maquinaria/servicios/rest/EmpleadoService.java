package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Empleado;
import co.com.a4b.maquinaria.negocio.EmpleadoNegocio;
import co.com.a4b.maquinaria.negocio.EmpresaNegocio;

@RestController
public class EmpleadoService {


  EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio();
  EmpresaNegocio empresaNegocio = new EmpresaNegocio();

  @RequestMapping(value = "/insertarEmpleado", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearEmpleado(@RequestBody Empleado empleado) {
    if (empresaNegocio.validarSiExisteLaEmpresa(empleado.getEmpresa())) {
      if (empleadoNegocio.validarSiExisteElEmpleado(empleado)) {
        return Response.status(Status.CONFLICT).entity("El empleado ya se encuentra registrado")
            .build();
      } else {
        empleadoNegocio.crearEmpleado(empleado);;
        return Response.status(Status.CREATED).entity("Empleado creado correctamente").build();
      }
    } else {
      return Response.status(Status.PRECONDITION_FAILED)
          .entity("Por favor crear la empresa antes de registrar el empleado").build();
    }
  }

  @RequestMapping(value = "/consultarEmpleados", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarEmpleados() {
    List<Empleado> listaEmpleados = empleadoNegocio.consultarEmpleados();

    if (listaEmpleados.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No existen emopleados registrados").build();
    } else {
      return Response.status(Status.OK).entity(listaEmpleados).build();
    }
  }

  @RequestMapping(value = "/actualizarEmpleado", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarEmpleado(@RequestBody Empleado empleado) {
    if (empresaNegocio.validarSiExisteLaEmpresa(empleado.getEmpresa())) {
      if (empleadoNegocio.validarSiExisteElEmpleado(empleado)) {
        empleadoNegocio.actualizarEmpleado(empleado);
        return Response.status(Status.OK).entity("Empleado modificado exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encontró el empleado que se desea modificar").build();
      }
    } else {
      return Response.status(Status.PRECONDITION_FAILED)
          .entity("No se encuentra la empresa en la cual se desea registrar el empleado").build();
    }
  }


  @RequestMapping(value = "/eliminarEmpleado", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarEmpleado(Empleado empleado) {

    if (empleadoNegocio.validarSiExisteElEmpleado(empleado)) {
      empleadoNegocio.eliminarEmpleado(empleado);
      return Response.status(Status.OK).entity("Empleado eliminado exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND)
          .entity("No se encuentra el empleado que se desea borrar").build();
    }
  }

  @RequestMapping(value = "/consultarEmpleado", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarEmpleadoPorId(String dni) {
    Empleado empleado = empleadoNegocio.buscarEmpleadoPorId(dni);

    if (empleado != null) {
      return Response.status(Status.OK).entity(empleado).build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontro el empleado buscado").build();
    }
  }
}
