package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.TarifaSubproyectoTurnoMaquina;
import co.com.a4b.maquinaria.dao.TarifaSubproyectoTurnoMaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.TarifaSubproyectoTurnoMaquinaDAOJPAImpl;

public class TarifaSubproyectoTurnoMaquinaNegocio {

  TarifaSubproyectoTurnoMaquinaDAO tarifaSubproyectoTurnoMaquinaDAO =
      new TarifaSubproyectoTurnoMaquinaDAOJPAImpl();

  public void crearTarifaSubproyectoTurnoMaquina(
      TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    tarifaSubproyectoTurnoMaquinaDAO.insertar(tarifaSubproyectoTurnoMaquina);
  }

  public void actualizarTarifaSubproyectoTurnoMaquina(
      TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    tarifaSubproyectoTurnoMaquinaDAO.actualizar(tarifaSubproyectoTurnoMaquina);
  }

  public void eliminarTarifaSubproyectoTurnoMaquina(
      TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    tarifaSubproyectoTurnoMaquinaDAO.borrar(tarifaSubproyectoTurnoMaquina);
  }

  public List<TarifaSubproyectoTurnoMaquina> consultarTarifasSubproyectosTurnosMaquinas() {
    return tarifaSubproyectoTurnoMaquinaDAO.buscarTodos();
  }

  public TarifaSubproyectoTurnoMaquina consultarTarifaSubproyectoTurnoMaquina(
      int idtarifaSubproyectoTurnoMaquina) {
    return tarifaSubproyectoTurnoMaquinaDAO.buscarPorClaveInt(idtarifaSubproyectoTurnoMaquina);
  }

  public boolean validarSiExisteSubproyecto(
      TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    if (this.consultarTarifaSubproyectoTurnoMaquina(
        (tarifaSubproyectoTurnoMaquina.getIdTarifaSubproyectoTurnoMaquina())) != null) {
      return true;
    } else {
      return false;
    }
  }
}
