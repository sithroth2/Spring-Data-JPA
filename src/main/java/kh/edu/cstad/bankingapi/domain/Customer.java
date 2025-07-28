package kh.edu.cstad.bankingapi.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String gender;

    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private Boolean isDeleted;

    // has a
    @ManyToOne
    @JoinColumn(name="cus_segment_id")
    private CustomerSegment customerSegment;

    @OneToOne(cascade = CascadeType.ALL)
    private KYC kyc;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
}


//Spring Web, Validation, PostgreSQL driver, Spring Data JPA, Lumbok