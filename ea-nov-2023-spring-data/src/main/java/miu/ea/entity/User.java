package miu.ea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users",
            uniqueConstraints = {
                    @UniqueConstraint(
                            name = "email_unique",
                            columnNames = "email"
                    )
            }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    // default fetch type for one to many is LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user",
                orphanRemoval = true)
    private List<Review> reviewList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "user")
    private Set<Address> addresses;

}
