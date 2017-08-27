package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empresa;
import co.com.a4b.maquinaria.dao.EmpresaDAO;

public class EmpresaDAOJPAImpl extends GenericDAOJPAImpl<Empresa, String> implements EmpresaDAO {

  @Override
  public void actualizar(Empresa empresa) {
    super.actualizar(empresa);
  }

  @Override
  public void borrar(Empresa empresa) {
    super.borrar(empresa);
  }

  @Override
  public Empresa buscarPorClaveString(String dni) {
    return super.buscarPorClaveString(dni);
  }


  @Override
  public Empresa buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public List<Empresa> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void insertar(Empresa empresa) {
    super.insertar(empresa);
  }

}
