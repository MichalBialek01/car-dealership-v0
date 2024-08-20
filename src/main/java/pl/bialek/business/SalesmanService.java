package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.SalesmanDAO;
import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database..Salesman;

import java.util.Optional;

@AllArgsConstructor
public class SalesmanService {
    private final SalesmanDAO salesmanDAO;

    public Salesman findSalesman(String pesel) {
        Optional<Salesman> salesman = salesmanDAO.findByPesel(pesel);
        if (salesman.isEmpty()) {
            throw new RuntimeException("Provided salesman with pesel: [%s] doesn't exist".formatted(pesel));
        }
        return salesman.get();
    }

}
