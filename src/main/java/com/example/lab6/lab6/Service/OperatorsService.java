package com.example.lab6.lab6.Service;

import com.example.lab6.lab6.model.Operators;
import com.example.lab6.lab6.model.ApplicationRequests;
import com.example.lab6.lab6.Repository.OperatorsRepository;
import com.example.lab6.lab6.Repository.ApplicationRequestsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OperatorsService {

    private final OperatorsRepository operatorsRepository;
    private final ApplicationRequestsRepository requestsRepository;

    public OperatorsService(OperatorsRepository operatorsRepository, ApplicationRequestsRepository requestsRepository) {
        this.operatorsRepository = operatorsRepository;
        this.requestsRepository = requestsRepository;
    }

    public Operators addOperator(Operators operator) {
        return operatorsRepository.save(operator);
    }

    public Operators getOperatorById(Long id) {
        return operatorsRepository.findById(id).orElse(null);
    }

    public void deleteOperator(Long id) {
        operatorsRepository.deleteById(id);
    }

    public List<Operators> getAllOperators() {
        return operatorsRepository.findAll();
    }

    public Operators saveOperator(Operators operator) {
        return operatorsRepository.save(operator);
    }

    public ApplicationRequests assignOperatorToRequest(Long operatorId, Long requestId) {
        Operators operator = operatorsRepository.findById(operatorId).orElse(null);
        ApplicationRequests request = requestsRepository.findById(requestId).orElse(null);

        if (operator != null && request != null) {
            request.getOperators().add(operator);  // добавляем оператора к заявке
            return requestsRepository.save(request); // сохраняем обновлённую заявку
        }

        return null;
    }
}
