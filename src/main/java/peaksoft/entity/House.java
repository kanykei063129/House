package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.HouseType;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "houses")
@Getter @Setter
@NoArgsConstructor

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen",sequenceName = "house_seq",allocationSize = 1)
    private Long id;
    private HouseType houseType;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private String imageLink;
    @ManyToOne(cascade = {DETACH, MERGE, REFRESH,REMOVE})
    private Agency agency;
    @OneToOne(mappedBy = "house",cascade = {DETACH, MERGE, REFRESH})
    private Booking booking;
}
