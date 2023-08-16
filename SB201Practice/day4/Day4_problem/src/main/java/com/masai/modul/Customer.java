package com.masai.modul;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({
        @NamedQuery(
                name = "customer by id",
                query = "select c from Customer c where c.CustomerId = :id"
        ),
        @NamedQuery(
                name = "List of All the customers",
                query = "select c from Customer c"
        )
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerId;
    private String name;
    private String address;
    private int budget;

    public Customer() {
    }

    public Customer(int customerId, String name, String address, int budget) {
        CustomerId = customerId;
        this.name = name;
        this.address = address;
        this.budget = budget;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                '}';
    }
}
