package client;

import entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 42. Working with objects - Udemy
 */

public class HelloWorldClient2 {
  public static void main(String[] args) {

    // First transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    Message msg1 = new Message("Hello");
    em.persist(msg1);

    em.getTransaction().commit();
    em.close();

    // Second transaction
    msg1.setText("Hi");

    EntityManager em2 = emf.createEntityManager();
    em2.getTransaction().begin();

    em2.merge(msg1);

    em2.getTransaction().commit();
    em2.close();

    System.exit(0);
  }
}