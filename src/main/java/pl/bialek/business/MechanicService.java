package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.menagement.MechanicDAO;
import pl.bialek.infrastructure.database.entity.MechanicEntity;

import java.util.Optional;
@AllArgsConstructor
public class MechanicService {

    private final MechanicDAO mechanicDAO ;

    public MechanicEntity findMechanic(String pesel) {
        Optional<MechanicEntity> mechanic = mechanicDAO.findByPesel(pesel);
        if (mechanic.isEmpty()) {
            throw new RuntimeException("Provided mechanic with pesel: [%s] doesn't exist".formatted(pesel));
        }
        return mechanic.get();
    }
}
