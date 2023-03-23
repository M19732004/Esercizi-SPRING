package co.develhope.mockdb.entities;

import javax.persistence.*;

@Entity
@Table
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true,name = "StudentEmail",length = 100)
    private String email;

    public Student(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}