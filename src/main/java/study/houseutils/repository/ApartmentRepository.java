package study.houseutils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.houseutils.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
