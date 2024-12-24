package user_management_app.com.demo.model;

import jakarta.persistence.*;
import lombok.*;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String username;
    private String email;

    @Embedded
    private Address address;

    private String phone;
    private String website;

    @Embedded
    private Company company;

    private Integer age;
    private Double salary;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;

}

//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class Geo {
    private String lat;
    private String lng;

}

//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class Company {
    // Getters and Setters
    private String name;
    private String catchPhrase;
    private String bs;

}


