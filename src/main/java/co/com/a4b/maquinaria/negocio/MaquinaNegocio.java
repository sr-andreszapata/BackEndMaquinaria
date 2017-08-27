package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.HistoricoEmpleadoMaquina;
import co.com.a4b.maquinaria.bo.Maquina;
import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.bo.TarifaSubproyectoTurnoMaquina;
import co.com.a4b.maquinaria.dao.MaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.MaquinaDAOJPAImpl;

public class MaquinaNegocio {

  MaquinaDAO maquinaDAO = new MaquinaDAOJPAImpl();

  public Maquina buscarMaquinaPorId(String idMaquina) {
    return maquinaDAO.buscarPorClaveString(idMaquina);
  }

  public void crearMaquina(Maquina maquina) {
    maquinaDAO.insertar(maquina);
  }

  public void actualizarMaquina(Maquina maquina) {
    maquinaDAO.actualizar(maquina);
  }

  public void eliminarMaquina(Maquina maquina) {
    maquinaDAO.borrar(maquina);
  }

  public List<Maquina> consultarMaquinas() {
    return maquinaDAO.buscarTodos();
  }

  public boolean validarSiExisteLaMaquina(Maquina maquina) {

    if (this.buscarMaquinaPorId(maquina.getIdMaquina()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarLaMaquina(Maquina maquina) {

    ReporteMaquinaNegocio reporteMaquinaNegocio = new ReporteMaquinaNegocio();
    HistoricoEmpleadoMaquinaNegocio historicoEmpleadoMaquinaNegocio =
        new HistoricoEmpleadoMaquinaNegocio();
    TarifaSubproyectoTurnoMaquinaNegocio tarifaSubproyectoTurnoMaquinaNegocio =
        new TarifaSubproyectoTurnoMaquinaNegocio();

    List<ReporteMaquina> reportesMaquinas = reporteMaquinaNegocio.consultarReportesMaquinas();
    for (ReporteMaquina reporteMaquina : reportesMaquinas) {
      if (reporteMaquina.getMaquina().getIdMaquina().equals(maquina.getIdMaquina())) {
        return false;
      }
    }

    List<HistoricoEmpleadoMaquina> historicosEmpleadosMaquinas =
        historicoEmpleadoMaquinaNegocio.consultarHistoricosEmpleadosMaquinas();
    for (HistoricoEmpleadoMaquina historicoEmpleadoMaquina : historicosEmpleadosMaquinas) {
      if (historicoEmpleadoMaquina.getMaquina().getIdMaquina() == maquina.getIdMaquina()) {
        return false;
      }
    }

    List<TarifaSubproyectoTurnoMaquina> tarifaSubproyectoTurnoMaquinas =
        tarifaSubproyectoTurnoMaquinaNegocio.consultarTarifasSubproyectosTurnosMaquinas();

    for (TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina : tarifaSubproyectoTurnoMaquinas) {
      if (tarifaSubproyectoTurnoMaquina.getMaquina().getIdMaquina() == maquina.getIdMaquina()) {
        return false;
      }
    }
    return true;
  }
}
