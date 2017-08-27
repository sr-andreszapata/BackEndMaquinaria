package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Volqueta;
import co.com.a4b.maquinaria.dao.VolquetaDAO;

public class VolquetaDAOJPAImpl extends GenericDAOJPAImpl<Volqueta, String> implements VolquetaDAO {

  @Override
  public Volqueta buscarPorClaveString(String placa) {
    return super.buscarPorClaveString(placa);
  }

  @Override
  public List<Volqueta> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Volqueta volqueta) {
    super.borrar(volqueta);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(Volqueta volqueta) {
    super.actualizar(volqueta);
  }

  @Override
  public void insertar(Volqueta volqueta) {
    super.insertar(volqueta);
  }

}
