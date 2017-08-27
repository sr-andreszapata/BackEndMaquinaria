package co.com.a4b.maquinaria.dao.jpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {

  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = buildEntityManagerFactory();

  private static EntityManagerFactory buildEntityManagerFactory() {

    try {
      return Persistence.createEntityManagerFactory("MySqlMaquinaria");
    } catch (Throwable ex) {
      throw new RuntimeException("Error al crear la factoria de JPA");
    }
  }

  public static EntityManagerFactory getJPAFactory() {
    return ENTITY_MANAGER_FACTORY;
  }
}
