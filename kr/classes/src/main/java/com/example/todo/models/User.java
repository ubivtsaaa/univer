package com.example.todo.models;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user;

    private Long id;
    private String login;
    private String Name;
    private String Surname;
    private String birthday;
    private LocalDate createdDate;
    private LocalDate updatedDate;


    private Set<Task> tasks;

    public User(String user, Long id, String login, String Name, String Surname, String birthday, LocalDate createdDate, LocalDate updatedDate){
        this.user = user;
        this.login = login;
        this.Name = Name;
        this.Surname = Surname;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return id;
    }
    public void setUser(String user) {

        this.user = user;
    }

    public void setUserId(Long id) {

        this.id = id;
    }
}
