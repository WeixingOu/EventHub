package com.mindhub.eventhub.models;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customerId;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false, length = 254)
    private String password;

    @Column(nullable = false)
    private short age;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, boolean active, String password, short age, Gender gender, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void addCustomerEvent(CustomerEvent customerEvent) {
        customerEvent.setCustomer(this);
        customerEvents.add(customerEvent);
    }

    public void addComment(Comment comment) {
        comment.setCustomer(this);
        comments.add(comment);
    }

    public void addRating(Rating rating) {
        rating.setCustomer(this);
        this.ratings.add(rating);
    }
}
