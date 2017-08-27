package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Ruta;
import co.com.a4b.maquinaria.dao.RutaDAO;
import co.com.a4b.maquinaria.dao.jpa.RutaDAOJPAImpl;

public class RutaNegocio {

  RutaDAO rutaDAO = new RutaDAOJPAImpl();

  public void crearRuta(Ruta ruta) {
    rutaDAO.insertar(ruta);
  }

  public void actualizarRuta(Ruta ruta) {
    rutaDAO.actualizar(ruta);
  }

  public void eliminarRuta(Ruta ruta) {
    rutaDAO.borrar(ruta);
  }

  public List<Ruta> consultarRutas() {
    return rutaDAO.buscarTodos();
  }

  public Ruta consultarRuta(int idRuta) {
    return rutaDAO.buscarPorClaveInt(idRuta);
  }

  public boolean validarSiExisteLaRuta(Ruta ruta) {
    if (this.consultarRuta(ruta.getIdRuta()) != null) {
      return true;
    } else {
      return false;
    }
  }
}
