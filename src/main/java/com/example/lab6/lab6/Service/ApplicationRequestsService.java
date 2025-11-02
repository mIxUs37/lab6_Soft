package com.example.lab6.lab6.Service;

import com.example.lab6.lab6.model.ApplicationRequests;
import com.example.lab6.lab6.model.Courses;
import com.example.lab6.lab6.model.Operators;
import com.example.lab6.lab6.Repository.ApplicationRequestsRepository;
import com.example.lab6.lab6.Repository.CoursesRepository;
import com.example.lab6.lab6.Repository.OperatorsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationRequestsService {

    private final ApplicationRequestsRepository requestsRepository;
    private final CoursesRepository coursesRepository;
    private final OperatorsRepository operatorsRepository;

    public ApplicationRequestsService(ApplicationRequestsRepository requestsRepository,
                                      CoursesRepository coursesRepository,
                                      OperatorsRepository operatorsRepository) {
        this.requestsRepository = requestsRepository;
        this.coursesRepository = coursesRepository;
        this.operatorsRepository = operatorsRepository;
    }

    public List<ApplicationRequests> getAllRequests() {
        return requestsRepository.findAll();
    }

    public ApplicationRequests getRequestById(Long id) {
        return requestsRepository.findById(id).orElse(null);
    }

    public void addRequest(ApplicationRequests request, Long courseId) {
        Courses course = coursesRepository.findById(courseId).orElse(null);
        if (course != null) {
            request.setCourse(course);
            requestsRepository.save(request);
        }
    }

    public void assignOperator(Long requestId, Long operatorId) {
        ApplicationRequests request = requestsRepository.findById(requestId).orElse(null);
        Operators operator = operatorsRepository.findById(operatorId).orElse(null);

        if (request != null && operator != null) {
            request.getOperators().add(operator);
            request.setHandled(true);
            requestsRepository.save(request);
        }
    }

    public void removeOperator(Long requestId, Long operatorId) {
        ApplicationRequests request = requestsRepository.findById(requestId).orElse(null);
        Operators operator = operatorsRepository.findById(operatorId).orElse(null);

        if (request != null && operator != null) {
            request.getOperators().remove(operator);
            requestsRepository.save(request);
        }
    }

    public ApplicationRequests saveRequest(ApplicationRequests request) {
        return requestsRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestsRepository.deleteById(id);
    }
}

