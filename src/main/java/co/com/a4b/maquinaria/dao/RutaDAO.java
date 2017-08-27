package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Ruta;

public interface RutaDAO extends GenericDAO<Ruta, String> {

  List<Ruta> buscarTodos();

  void insertar(Ruta ruta);

  void actualizar(Ruta ruta);

  void borrar(Ruta ruta);

  Ruta buscarPorClaveInt(int idRuta);

}
