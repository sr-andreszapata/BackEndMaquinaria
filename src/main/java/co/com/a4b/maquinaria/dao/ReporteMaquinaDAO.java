package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteMaquina;

public interface ReporteMaquinaDAO extends GenericDAO<ReporteMaquina, String> {

  @Override
  List<ReporteMaquina> buscarTodos();

  @Override
  void actualizar(ReporteMaquina reporteMaquina);

  @Override
  void borrar(ReporteMaquina reporteMaquina);

  @Override
  void insertar(ReporteMaquina reporteMaquina);

  @Override
  ReporteMaquina buscarPorClaveInt(int idReporteMaquina);

}
