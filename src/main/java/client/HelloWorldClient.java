package client;

import entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 41. Hibernate as JPA provider - Udemy
 */

public class HelloWorldClient {
  public static void main(String[] args) {

    // Using an entity manager to persist the content

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
    EntityManager em = emf.createEntityManager();
    EntityTransaction txn = em.getTransaction();
    try {
      txn.begin();

      Message msg = new Message("Hello World with Hibernate as JPA Provider");
      em.persist(msg);

      txn.commit();
    } catch (Exception e) {
      if (txn != null) {
        txn.rollback();
      }
      e.printStackTrace();
    } finally {
      if (em != null) {
        em.close();
      }
    }
    System.exit(0);
  }
}