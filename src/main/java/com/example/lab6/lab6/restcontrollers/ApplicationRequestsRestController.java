package com.example.lab6.lab6.restcontrollers;

import com.example.lab6.lab6.model.ApplicationRequests;
import com.example.lab6.lab6.Service.ApplicationRequestsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApplicationRequestsRestController {

    private final ApplicationRequestsService requestsService;

    public ApplicationRequestsRestController(ApplicationRequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping
    public List<ApplicationRequests> getAll() {
        return requestsService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ApplicationRequests getById(@PathVariable Long id) {
        return requestsService.getRequestById(id);
    }

    @PostMapping
    public ApplicationRequests add(@RequestBody ApplicationRequests request) {
        return requestsService.saveRequest(request);
    }

    @PutMapping("/{id}")
    public ApplicationRequests update(@PathVariable Long id, @RequestBody ApplicationRequests updated) {
        ApplicationRequests existing = requestsService.getRequestById(id);
        if (existing != null) {
            existing.setUserName(updated.getUserName());
            existing.setPhone(updated.getPhone());
            existing.setComment(updated.getComment());
            existing.setHandled(updated.isHandled());
            return requestsService.saveRequest(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        requestsService.deleteRequest(id);
    }
}
