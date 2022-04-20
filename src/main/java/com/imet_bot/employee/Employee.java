package com.imet_bot.employee;

import javax.persistence.*;

@Table
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contingent;
    private String position;
    private String fullName;
    private String address;
    private String contacts;
    private String email;

    public Employee() {
    }

    public Employee(Long id,
                    String contingent,
                    String position,
                    String fullName,
                    String address,
                    String contacts,
                    String email) {
        this.id = id;
        this.contingent = contingent;
        this.position = position;
        this.fullName = fullName;
        this.address = address;
        this.contacts = contacts;
        this.email = email;
    }

    public Employee(String contingent,
                    String position,
                    String fullName,
                    String address,
                    String contacts,
                    String email) {
        this.contingent = contingent;
        this.position = position;
        this.fullName = fullName;
        this.address = address;
        this.contacts = contacts;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContingent() {
        return contingent;
    }

    public void setContingent(String contingent) {
        this.contingent = contingent;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fullName + '\n' + position + '\n' + "\nКонтакты:\n" + contacts + '\n' + email;
    }
}

