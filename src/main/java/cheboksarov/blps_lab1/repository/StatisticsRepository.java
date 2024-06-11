package cheboksarov.blps_lab1.repository;

import cheboksarov.blps_lab1.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository  extends JpaRepository<Statistics, Long> {
}
