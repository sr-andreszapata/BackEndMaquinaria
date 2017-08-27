package co.com.a4b.maquinaria.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.a4b.maquinaria.dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

  private Class<T> claseDePersistencia;

  @SuppressWarnings("unchecked")
  public GenericDAOJPAImpl() {
    this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  @Override
  public T buscarPorClaveString(String id) {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    T objeto = null;

    try {
      objeto = (T) entityManager.find(claseDePersistencia, id);
      return objeto;
    } catch (PersistenceException e) {
      entityManager.close();
      throw new DataBaseException(e.getMessage(), e);
    } finally {
      entityManager.close();
    }
  }


  public T buscarPorClaveInt(int id) {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    T objeto = null;

    try {
      objeto = (T) entityManager.find(claseDePersistencia, id);
      return objeto;
    } catch (PersistenceException e) {
      entityManager.close();
      throw new DataBaseException(e.getMessage(), e);
    } finally {
      entityManager.close();
    }
  }

  @Override
  public List<T> buscarTodos() {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    List<T> listaDeObjetos = null;

    try {
      TypedQuery<T> consulta = entityManager.createQuery(
          "select o from " + claseDePersistencia.getSimpleName() + " o", claseDePersistencia);

      listaDeObjetos = consulta.getResultList();
      return listaDeObjetos;

    } catch (PersistenceException e) {
      entityManager.close();
      throw new DataBaseException(e.getMessage(), e);
    }
  }

  public void borrar(T objeto) {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = null;

    try {
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.remove(entityManager.merge(objeto));
      entityTransaction.commit();
    } catch (PersistenceException e) {
      entityTransaction.rollback();
      entityManager.close();
      throw new DataBaseException(e.getMessage(), e);
    } finally {
      entityManager.close();
    }
  }

  public void borrarTodos() {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    try {
      TypedQuery<T> consulta = entityManager.createQuery(
          "Delete o from " + claseDePersistencia.getSimpleName() + " o", claseDePersistencia);

      consulta.executeUpdate();

    } catch (PersistenceException e) {
      entityManager.close();
      throw new DataBaseException(e.getMessage(), e);
    } finally {
      entityManager.close();
    }
  }

  public void actualizar(T objeto) {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = null;

    try {
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.merge(objeto);
      entityTransaction.commit();

    } catch (PersistenceException e) {
      entityTransaction.rollback();
      throw e;
    } finally {
      entityManager.close();
    }
  }

  public void insertar(T objeto) {

    EntityManagerFactory entityManagerFactory = JPAHelper.getJPAFactory();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = null;

    try {
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(objeto);
      entityTransaction.commit();

    } catch (PersistenceException e) {
      entityTransaction.rollback();
      throw e;
    } finally {
      entityManager.close();
    }
  }
}
