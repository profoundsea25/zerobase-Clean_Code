package study.houseutils.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.houseutils.repository.ApartmentRepository;

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public Long getPriceOrThrow(Long apartmentId) {
        return null;
    }
}
