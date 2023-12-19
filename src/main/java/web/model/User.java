package web.model;

import org.hibernate.ObjectNotFoundException;

import javax.persistence.*;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be less than or equal to 50 characters")
    @Column(name = "name")
    @NotNull
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 50, message = "Surname must be less than or equal to 50 characters")
    @Column(name = "surname")
    @NotNull
    private String surname;

    @NotBlank(message = "Email is required")
    @Column(name = "email")
    @NotNull
    private String email;

    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() throws ObjectNotFoundException {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname()  {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}