package com.m1iii.cybersecu.projettroue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;
    private String creditCardNumber;
    private Date creditCardDate;
    private String creditCardSecurityCode;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Transient
    boolean isLoggedIn = false;

    @ManyToMany(mappedBy = "owners")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Book> booksOwned;

    public User() {
    }

    public User(String firstName, String lastName, String address, String postalCode, String city, String phoneNumber, String creditCardNumber, Date creditCardDate, String creditCardSecurityCode, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardDate = creditCardDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Long id, String firstName, String lastName, String address, String postalCode, String city, String phoneNumber, String creditCardNumber, Date creditCardDate, String creditCardSecurityCode, String email, String password, UserRole userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardDate = creditCardDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Long id, String firstName, String lastName, String address, String postalCode, String city, String phoneNumber, String creditCardNumber, Date creditCardDate, String creditCardSecurityCode, String email, String password, UserRole userRole, boolean isLoggedIn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardDate = creditCardDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.isLoggedIn = isLoggedIn;
    }

    public User(Long id, String firstName, String lastName, String address, String postalCode, String city, String phoneNumber, String creditCardNumber, Date creditCardDate, String creditCardSecurityCode, String email, String password, UserRole userRole, boolean isLoggedIn, Set<Book> booksOwned) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardDate = creditCardDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.isLoggedIn = isLoggedIn;
        this.booksOwned = booksOwned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getCreditCardDate() {
        return creditCardDate;
    }

    public void setCreditCardDate(Date creditCardDate) {
        this.creditCardDate = creditCardDate;
    }

    public String getCreditCardSecurityCode() {
        return creditCardSecurityCode;
    }

    public void setCreditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Set<Book> getBooksOwned() {
        return booksOwned;
    }

    public void setBooksOwned(Set<Book> booksOwned) {
        this.booksOwned = booksOwned;
    }
}
