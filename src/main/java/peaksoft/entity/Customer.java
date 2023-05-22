package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    @Column(name = "pnone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToMany(cascade = {DETACH, MERGE, REFRESH,REMOVE})
    private List<Agency> agencies;
    @OneToMany(mappedBy = "customer",cascade = {DETACH, MERGE, REFRESH})
    private List<Booking> bookings;

}

