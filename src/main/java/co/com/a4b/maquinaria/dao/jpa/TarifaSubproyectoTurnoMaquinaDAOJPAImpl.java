package co.com.a4b.maquinaria.dao.jpa;

import java.util.List;

import co.com.a4b.maquinaria.bo.TarifaSubproyectoTurnoMaquina;
import co.com.a4b.maquinaria.dao.TarifaSubproyectoTurnoMaquinaDAO;

public class TarifaSubproyectoTurnoMaquinaDAOJPAImpl
    extends GenericDAOJPAImpl<TarifaSubproyectoTurnoMaquina, String>
    implements TarifaSubproyectoTurnoMaquinaDAO {

  @Override
  public TarifaSubproyectoTurnoMaquina buscarPorClaveInt(int idTarifaSubproyectoTurnoMaquina) {
    return super.buscarPorClaveInt(idTarifaSubproyectoTurnoMaquina);
  }

  @Override
  public List<TarifaSubproyectoTurnoMaquina> buscarTodos() {
    return super.buscarTodos();
  }

  @Override
  public void borrar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    super.borrar(tarifaSubproyectoTurnoMaquina);
  }

  @Override
  public void borrarTodos() {
    super.borrarTodos();
  }

  @Override
  public void actualizar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    super.actualizar(tarifaSubproyectoTurnoMaquina);
  }

  @Override
  public void insertar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina) {
    super.insertar(tarifaSubproyectoTurnoMaquina);
  }

}
