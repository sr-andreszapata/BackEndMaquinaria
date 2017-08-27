package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.TarifaSubproyectoTurnoMaquina;

public interface TarifaSubproyectoTurnoMaquinaDAO
    extends GenericDAO<TarifaSubproyectoTurnoMaquina, String> {

  @Override
  List<TarifaSubproyectoTurnoMaquina> buscarTodos();

  @Override
  void actualizar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina);

  @Override
  void borrar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina);

  @Override
  void insertar(TarifaSubproyectoTurnoMaquina tarifaSubproyectoTurnoMaquina);

  @Override
  TarifaSubproyectoTurnoMaquina buscarPorClaveInt(int idTarifaSubproyectoTurnoMaquina);


}
