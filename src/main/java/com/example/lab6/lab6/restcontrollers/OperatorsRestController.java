package com.example.lab6.lab6.restcontrollers;

import com.example.lab6.lab6.model.Operators;
import com.example.lab6.lab6.model.ApplicationRequests;
import com.example.lab6.lab6.Service.OperatorsService;
import com.example.lab6.lab6.Service.ApplicationRequestsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/operators")
public class OperatorsRestController {

    private final OperatorsService operatorsService;
    private final ApplicationRequestsService requestsService;

    public OperatorsRestController(OperatorsService operatorsService, ApplicationRequestsService requestsService) {
        this.operatorsService = operatorsService;
        this.requestsService = requestsService;
    }

    @GetMapping
    public List<Operators> getAll() {
        return operatorsService.getAllOperators();
    }

    @PostMapping
    public Operators add(@RequestBody Operators operator) {
        return operatorsService.saveOperator(operator);
    }

    @GetMapping("/{id}")
    public Operators getOperatorById(@PathVariable Long id) {
        return operatorsService.getOperatorById(id);
    }


    @PutMapping("/{id}/assign/{requestId}")
    public ApplicationRequests assignOperatorToRequest(@PathVariable Long id,
                                                       @PathVariable Long requestId) {
        return operatorsService.assignOperatorToRequest(id, requestId);
    }
}
