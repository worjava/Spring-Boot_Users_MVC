package com.UsersMVC.users.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;




@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "поле не должны быть пустым")
    @Size( max = 30, message = "превышено количество символов")
    @Column(name = "name")
    private String name;
    @Min(value = 0, message = "Поле не может быть пустым")
    @Max(value = 30, message = "Максимальный возраст не более 30")
    @Column(name = "age")
    private int age;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Email(message = "Некоректный email")
    @Column(name = "email")
    private String email;
    public User() {}
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
