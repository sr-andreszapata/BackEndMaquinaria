package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Insumo;
import co.com.a4b.maquinaria.dao.InsumoDAO;

public class InsumoDAOJPAImpl extends GenericDAOJPAImpl<Insumo, String> implements InsumoDAO {

  @Override
  public Insumo buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

  @Override
  public List<Insumo> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Insumo insumo) {
    super.borrar(insumo);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Insumo insumo) {
    super.actualizar(insumo);
  }

  @Override
  public void insertar(Insumo insumo) {
    super.insertar(insumo);
  }

}
