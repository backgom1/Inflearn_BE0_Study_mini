package learn.ensmini.domain.commute.repository;

import learn.ensmini.domain.commute.domain.Commute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuteJpaRepository extends JpaRepository<Commute,Long> {
}
