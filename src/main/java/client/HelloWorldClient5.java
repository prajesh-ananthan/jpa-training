package client;

import entity.Guide;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 47. Lazy fetching
 */

public class HelloWorldClient5 {
  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      Guide guide = em.find(Guide.class, 6L);
      int noOfStudents = guide.getStudents().size();
      System.out.println(noOfStudents);

    } finally {
      em.close();
    }
    System.exit(0);
  }
}