package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Turno;
import co.com.a4b.maquinaria.dao.TurnoDAO;
import co.com.a4b.maquinaria.dao.jpa.TurnoDAOJPAImpl;

public class TurnoNegocio {

  TurnoDAO turnoDAO = new TurnoDAOJPAImpl();

  public void crearTurno(Turno turno) {
    turnoDAO.insertar(turno);
  }

  public void actualizarTurno(Turno turno) {
    turnoDAO.actualizar(turno);
  }

  public void eliminarTurno(Turno turno) {
    turnoDAO.borrar(turno);
  }

  public List<Turno> consultarTurnos() {
    return turnoDAO.buscarTodos();
  }

  public Turno consultarTurno(int idTurno) {
    return turnoDAO.buscarPorClaveInt(idTurno);
  }

  public boolean validarSiExisteElTurno(Turno turno) {
    if (this.consultarTurno(turno.getIdTurno()) != null) {
      return true;
    } else {
      return false;
    }
  }
}
