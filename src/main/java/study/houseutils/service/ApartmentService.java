package study.houseutils.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.houseutils.exception.ErrorCode;
import study.houseutils.exception.HouseUtilsException;
import study.houseutils.repository.ApartmentRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                .getPrice();
    }
}
