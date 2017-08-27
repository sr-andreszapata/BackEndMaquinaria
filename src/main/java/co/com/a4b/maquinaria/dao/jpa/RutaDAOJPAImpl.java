package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Ruta;
import co.com.a4b.maquinaria.dao.RutaDAO;

public class RutaDAOJPAImpl extends GenericDAOJPAImpl<Ruta, String> implements RutaDAO {


  @Override
  public List<Ruta> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Ruta ruta) {
    super.borrar(ruta);
  }

  @Override
  public void actualizar(Ruta ruta) {
    super.actualizar(ruta);
  }

  @Override
  public void insertar(Ruta ruta) {
    super.insertar(ruta);
  }

  @Override
  public Ruta buscarPorClaveInt(int idRuta) {
    return super.buscarPorClaveInt(idRuta);
  }

}
