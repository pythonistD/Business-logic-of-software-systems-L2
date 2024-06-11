package cheboksarov.blps_lab1.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long match_id;
    private String hosts;
    private String guests;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_coeff_id", referencedColumnName = "coeff_id")
    private Coefficient coefficient;
    private Status status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_statistic_hosts", referencedColumnName = "stat_id")
    private Statistics hostsStat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_statistic_guests", referencedColumnName = "stat_id")
    private Statistics guestsStat;
    private enum Status {
        NotStarted,
        Going,
        Ended
    }
}
