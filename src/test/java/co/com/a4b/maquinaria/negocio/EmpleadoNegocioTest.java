package co.com.a4b.maquinaria.negocio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.a4b.maquinaria.bo.Empleado;
import co.com.a4b.maquinaria.dao.EmpleadoDAO;


public class EmpleadoNegocioTest {

  @Mock
  EmpleadoDAO empleadoDAO;

  @Test
  public void validarSiExisteElEmpleadoTest() {

    MockitoAnnotations.initMocks(this);

    Empleado empleado = new Empleado();
    EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio();
    empleado.setDni("C123");

    Mockito.when(empleadoDAO.buscarPorClaveString("C123")).thenReturn(empleado);
    Mockito.when(empleadoDAO.buscarPorClaveString("")).thenReturn(null);

    empleadoNegocio.setEmpleadoDAO(empleadoDAO);


    Assert.assertTrue(empleadoNegocio.validarSiExisteElEmpleado(empleado));
    empleado.setDni("");
    Assert.assertFalse(empleadoNegocio.validarSiExisteElEmpleado(empleado));

  }

}
