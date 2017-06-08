package client;

import entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 44. Caching objects
 */

public class HelloWorldClient4 {
  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Message message = em.find(Message.class, 20L);
    System.out.println(message.getText());

    em.close();

    System.exit(0);
  }
}