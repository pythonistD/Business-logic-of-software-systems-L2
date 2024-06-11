package cheboksarov.blps_lab2.repository;

import cheboksarov.blps_lab2.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository  extends JpaRepository<Statistics, Long> {
}
