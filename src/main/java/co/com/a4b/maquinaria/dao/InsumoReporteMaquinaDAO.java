package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.InsumoReporteMaquina;

public interface InsumoReporteMaquinaDAO extends GenericDAO<InsumoReporteMaquina, String> {

  @Override
  List<InsumoReporteMaquina> buscarTodos();

  @Override
  void actualizar(InsumoReporteMaquina insumoReporteMaquina);

  @Override
  void borrar(InsumoReporteMaquina insumoReporteMaquina);

  @Override
  void insertar(InsumoReporteMaquina insumoReporteMaquina);

  @Override
  InsumoReporteMaquina buscarPorClaveInt(int idInsumoReporteMaquina);

}
