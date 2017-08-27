package co.com.a4b.maquinaria.servicios.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.a4b.maquinaria.bo.Empresa;
import co.com.a4b.maquinaria.negocio.EmpresaNegocio;

@RestController
public class EmpresaService {

  EmpresaNegocio empresaNegocio = new EmpresaNegocio();

  @RequestMapping(value = "/insertarEmpresa", method = RequestMethod.POST,
      produces = "application/json")
  public Response crearEmpresa(@RequestBody Empresa empresa) {

    if (empresaNegocio.validarSiExisteLaEmpresa(empresa)) {
      return Response.status(Status.CONFLICT).entity("La empresa ya existe").build();
    } else {
      empresaNegocio.crearEmpresa(empresa);
      return Response.status(Status.OK).entity("Empresa insertada exitosamente").build();

    }
  }

  @RequestMapping(value = "/consultarEmpresas", method = RequestMethod.GET,
      produces = "application/json")
  public Response consultarEmpresas() {
    List<Empresa> empresas = empresaNegocio.consultarEmpresas();

    if (empresas.isEmpty()) {
      return Response.status(Status.NOT_FOUND).entity("No se encontraron empresas").build();
    } else {
      return Response.status(Status.OK).entity(empresas).build();
    }
  }

  @RequestMapping(value = "/actualizarEmpresa", method = RequestMethod.PUT,
      produces = "application/json")
  public Response actualizarEmpresa(@RequestBody Empresa empresa) {

    if (empresaNegocio.validarSiExisteLaEmpresa(empresa)) {
      empresaNegocio.actualizarEmpresa(empresa);
      return Response.status(Status.OK).entity("Empresa modificada exitosamente").build();
    } else {
      return Response.status(Status.NOT_FOUND).entity("No se encontró la empresa a modificar")
          .build();
    }
  }

  @RequestMapping(value = "/eliminarEmpresa", method = RequestMethod.DELETE,
      produces = "application/json")
  public Response eliminarEmpresa(Empresa empresa) {

    if (empresaNegocio.validarSiSePuedeEliminarLaEmpresa(empresa)) {

      if (empresaNegocio.validarSiExisteLaEmpresa(empresa)) {
        empresaNegocio.eliminarEmpresa(empresa);
        return Response.status(Status.OK).entity("Empresa eliminada exitosamente").build();
      } else {
        return Response.status(Status.NOT_FOUND)
            .entity("No se encuentra la empresa que se desea borrar").build();
      }
    } else {
      return Response.status(Status.CONFLICT)
          .entity("No se puede eliminar la empresa porque existe información relacionada con ella")
          .build();
    }
  }

  @RequestMapping(value = "/consultarEmpresa", method = RequestMethod.GET,
      produces = "application/json")
  public Response buscarEmpresaPorId(String dni) {

    Empresa empresa = empresaNegocio.buscarEmpresaPorId(dni);

    if (empresa == null) {
      return Response.status(Status.NOT_FOUND).entity("No se encontro la empresa").build();
    } else {
      return Response.status(Status.OK).entity(empresa).build();
    }
  }
}
