package com.bookstore.entity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManagerFactory);

        User user = new User();
        user.setFullName("Messiii");
        user.setPassword("123456");
        user.setEmail("msioii@gmail.com");
        System.out.println(user);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("A user object is persisted successfully");
    	System.out.println("Hello");


    }
}
