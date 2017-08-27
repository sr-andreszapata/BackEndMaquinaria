package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.HistoricoEmpleadoMaquina;

public interface HistoricoEmpledoMaquinaDAO extends GenericDAO<HistoricoEmpleadoMaquina, String> {

  @Override
  List<HistoricoEmpleadoMaquina> buscarTodos();

  @Override
  void actualizar(HistoricoEmpleadoMaquina historicoEmpleadoMaquina);

  @Override
  void borrar(HistoricoEmpleadoMaquina historicoEmpleadoMaquina);

  @Override
  void insertar(HistoricoEmpleadoMaquina historicoEmpleadoMaquina);

  @Override
  HistoricoEmpleadoMaquina buscarPorClaveInt(int id);

}
