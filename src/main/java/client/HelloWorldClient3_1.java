package client;

import entity.Guide;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 25. Cascades - Persist/Delete the whole object graph, meaning the relationship of the object
 */

public class HelloWorldClient3_1 {
  private static final String DATABASE_NAME = "hello-world";

  public static void main(String[] args) {

    final Guide guide = new Guide("2000MO10790", "Mike Tyson", 500);
    final Student student = new Student("2014JT50124", "John Cena", guide);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE_NAME);
    EntityManager entityManager = emf.createEntityManager();

    try {
      entityManager.getTransaction().begin();
//      persistObject(em, student);
      removeObject(entityManager);

      entityManager.getTransaction().commit();

    } catch (Exception e) {
      if (entityManager.getTransaction() != null) {
        entityManager.getTransaction().rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
    System.exit(0);
  }

  private static void persistObject(EntityManager em, Student student) {
    em.persist(student);
  }

  private static void removeObject(EntityManager entityManager) {
    final long primaryKey = 3L;
    final Student student = entityManager.find(Student.class, primaryKey);
    entityManager.remove(student);

    if (entityManager.find(Student.class, primaryKey) == null)
      System.out.println("Student object has been removed!");
  }
}