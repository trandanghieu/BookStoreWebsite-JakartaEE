package com.bookstore.dao;

import com.bookstore.entity.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User> {
    public UserDAO(EntityManager entityManager) {
        super(entityManager);
        System.out.println(entityManager);
    }

    @Override
    public User create(User entity) {
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        return super.update(entity);
    }


    @Override
    public User get(Object id) {
        return super.find(User.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    @Override
    public List<User> listAll() {
        return super.findWithNamedQuery(User.GET_ALL_USERS);
    }

    @Override
    public long count() {
        return super.countWithNamedQuery(User.COUNT_ALL_USERS);
    }
}
