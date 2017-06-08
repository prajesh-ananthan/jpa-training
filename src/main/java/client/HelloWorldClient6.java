package client;

import entity.Guide;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

/**
 * 27. One to many relationship
 */

public class HelloWorldClient6 {

  private static final long PRIMARY_KEY = 4L;
  private static final String DATABASE_NAME = "hello-world";

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE_NAME);
    EntityManager em = emf.createEntityManager();
    PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

    Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
    Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);

    Student student1 = new Student("2014JT50123", "John Smith", guide1);
    Student student2 = new Student("2014AL50456", "Amy Gill", guide1);

    try {
      em.getTransaction().begin();
      guide1.getStudents().add(student1);
      guide1.getStudents().add(student2);

      em.persist(guide1);
      em.getTransaction().commit();

      boolean isObjectLoaded = persistenceUtil.isLoaded(guide1);
      String result = isObjectLoaded ? "Guide1 is loaded" : "Guide1 is not loaded";
      System.out.println(result);

    } finally {
      em.close();
    }
    System.exit(0);
  }
}