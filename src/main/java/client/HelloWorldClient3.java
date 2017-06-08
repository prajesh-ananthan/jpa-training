package client;

import entity.Guide;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 42. Working with objects - Udemy
 */

public class HelloWorldClient3 {
  public static void main(String[] args) {

    Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
    Student student = new Student("2014JT50123", "John Smith", guide);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(guide);
      em.persist(student);
      em.getTransaction().commit();

    } catch (Exception e) {
      if (em.getTransaction() != null) {
        em.getTransaction().rollback();
      }
      e.printStackTrace();
    } finally {
      em.close();
    }
    System.exit(0);
  }
}