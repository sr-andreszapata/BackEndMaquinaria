package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteVolqueta;

public interface ReporteVolquetaDAO extends GenericDAO<ReporteVolqueta, String> {

  @Override
  List<ReporteVolqueta> buscarTodos();

  @Override
  void actualizar(ReporteVolqueta reporteVolqueta);

  @Override
  void borrar(ReporteVolqueta reporteVolqueta);

  @Override
  void insertar(ReporteVolqueta reporteVolqueta);

  @Override
  ReporteVolqueta buscarPorClaveInt(int idReporteVolqueta);


}
