package co.com.a4b.maquinaria.dao;


import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, Id extends Serializable> {

  List<T> buscarTodos();

  void actualizar(T objeto);

  void borrar(T objeto);

  void insertar(T objeto);

  T buscarPorClaveString(String id);

  T buscarPorClaveInt(int id);

}

