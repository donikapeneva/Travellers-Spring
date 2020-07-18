package com.dreamix.travelers.data;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private Set<Adventure> adventures = new HashSet<>();

   public User(String username,
           String email,
           String password,
           String firstName,
            String lastName) {
       this.username = username;
       this.email = email;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
   }
}
