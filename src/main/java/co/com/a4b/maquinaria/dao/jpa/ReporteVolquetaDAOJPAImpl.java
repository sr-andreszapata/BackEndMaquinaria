package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.ReporteVolqueta;
import co.com.a4b.maquinaria.dao.ReporteVolquetaDAO;

public class ReporteVolquetaDAOJPAImpl extends GenericDAOJPAImpl<ReporteVolqueta, String>
    implements ReporteVolquetaDAO {

  @Override
  public ReporteVolqueta buscarPorClaveInt(int idReporteMaquina) {
    return super.buscarPorClaveInt(idReporteMaquina);
  }

  @Override
  public List<ReporteVolqueta> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(ReporteVolqueta reporteVolqueta) {
    super.borrar(reporteVolqueta);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(ReporteVolqueta reporteVolqueta) {
    super.actualizar(reporteVolqueta);
  }

  @Override
  public void insertar(ReporteVolqueta reporteVolqueta) {
    super.insertar(reporteVolqueta);
  }

}
