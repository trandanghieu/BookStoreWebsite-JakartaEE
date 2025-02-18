package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = User.GET_ALL_USERS,
                    query = "SELECT u FROM User u ORDER BY u.fullName"),
        @NamedQuery(name = User.COUNT_ALL_USERS,
                query = "SELECT count(*) FROM User u")
})
public class User {

    public static final String GET_ALL_USERS="GET_ALL_USERS";
    public static final String COUNT_ALL_USERS="COUNT_ALL_USERS";



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "full_name", nullable = false, length = 30)
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}