package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.Turno;
import co.com.a4b.maquinaria.dao.TurnoDAO;

public class TurnoDAOJPAImpl extends GenericDAOJPAImpl<Turno, String> implements TurnoDAO {

  @Override
  public Turno buscarPorClaveInt(int id) {
    return super.buscarPorClaveInt(id);
  }

  @Override
  public List<Turno> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(Turno turno) {
    super.borrar(turno);
  }

  @Override
  public void actualizar(Turno turno) {
    super.actualizar(turno);
  }

  @Override
  public void insertar(Turno turno) {
    super.insertar(turno);
  }

}
