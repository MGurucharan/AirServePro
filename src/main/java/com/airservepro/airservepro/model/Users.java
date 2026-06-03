package com.airservepro.airservepro.model;

import com.airservepro.airservepro.enums.Roles;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String name;

    // A user can have multiple bookings , hence oneTomany bookings !
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Enumerated(EnumType.STRING)
    private Roles role;

    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDate.now();
    }

}
