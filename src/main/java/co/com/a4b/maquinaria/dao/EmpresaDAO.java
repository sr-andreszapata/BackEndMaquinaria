package co.com.a4b.maquinaria.dao;

import java.util.List;

import co.com.a4b.maquinaria.bo.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa, String> {

  @Override
  List<Empresa> buscarTodos();

  @Override
  void insertar(Empresa empresa);

  @Override
  void actualizar(Empresa empresa);

  @Override
  void borrar(Empresa empresa);

  @Override
  Empresa buscarPorClaveString(String dni);

  @Override
  Empresa buscarPorClaveInt(int dni);
}

