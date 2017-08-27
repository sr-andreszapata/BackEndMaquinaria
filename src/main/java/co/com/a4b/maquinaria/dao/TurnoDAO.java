package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Turno;

public interface TurnoDAO extends GenericDAO<Turno, String> {

  List<Turno> buscarTodos();

  void insertar(Turno turno);

  void actualizar(Turno turno);

  void borrar(Turno turno);

  Turno buscarPorClaveInt(int idTurno);

}
