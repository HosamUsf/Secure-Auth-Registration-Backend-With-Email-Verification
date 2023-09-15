package com.hossam.login_tutorial.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")

public class User {


    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id ;
    private String firstName;
    private String lastName;
    private String email ;
    private String password ;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked =false;
    private Boolean enabled= false  ;


    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password =user.password;
        this.userRole = user.userRole;
        this.locked = user.locked;
        this.enabled = user.enabled;
    }


    public User(String firstName, String lastName, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;

    }
}
