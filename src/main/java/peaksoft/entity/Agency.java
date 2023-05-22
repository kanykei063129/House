package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agencies")
@Getter  @Setter
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(length = 100000000)
    private String imageLink;
    private String email;
    @OneToMany(mappedBy = "agency",cascade = {DETACH, MERGE, REFRESH})
    private List<House> houses;
    @ManyToMany(mappedBy = "agencies",cascade = {DETACH, MERGE, REFRESH})
    private List<Customer> customers;

    public Agency(String name, String country, String phoneNumber, String imageLink, String email, List<House> houses, List<Customer> customers) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.imageLink = imageLink;
        this.email = email;
        this.houses = houses;
        this.customers = customers;
    }
}
