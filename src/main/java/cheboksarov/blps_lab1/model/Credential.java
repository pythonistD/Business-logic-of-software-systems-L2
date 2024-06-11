package cheboksarov.blps_lab1.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long credentialId;
    @Column(unique = true)
    private String userName;
    private String password;
    @ColumnDefault("USER")
    private String role;
}
