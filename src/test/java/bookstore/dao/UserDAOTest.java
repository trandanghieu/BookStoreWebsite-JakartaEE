package java.bookstore.dao;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class UserDAOTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;

    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);

    }


    @Test
    public void testCreateUsers() {
        User user = new User();
        user.setFullName("Ronny");
        user.setEmail("ronney@gmail.com");
        user.setPassword("123456");

        user = userDAO.create(user);


        Assert.assertTrue(user.getId() > 0);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setFullName("Ronny");
        user.setEmail("ronney@gmail.com");
        user.setPassword("mysrect");
        user = userDAO.update(user);

        String expected = "mysrect";
        String actual = user.getPassword();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsersFound() {
        Integer userId = 22;
        User user = userDAO.get(userId);

        if (user != null) {
            System.out.println(user.getEmail());
        }
        Assert.assertNotNull(user);


    }

    @Test(expected = Exception.class)
    public void testDeleteNonExistUsers() {
        Integer userId = 55;
        userDAO.delete(userId);
    }

    @Test
    public void testGetUserNotFound() {
        Integer userId = 101;
        User user = userDAO.get(userId);
        Assert.assertNull(user);
    }

    @Test
    public void testDeleteUsers() {
        Integer userId = 21;
        userDAO.delete(userId);

        User user = userDAO.get(userId);

        Assert.assertNull(user);
    }

    @Test
    public void testListAll() {
        List<User> userList = userDAO.listAll();
        for (User user : userList) {
            System.out.println(user.getFullName());
        }
        Assert.assertTrue(userList.size() > 0);

    }

    @Test
    public void testCount() {
        long numberOfUsers = userDAO.count();
        System.out.println(numberOfUsers);
        Assert.assertTrue(numberOfUsers > 0);

    }


    @AfterClass
    public static void tearDownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
