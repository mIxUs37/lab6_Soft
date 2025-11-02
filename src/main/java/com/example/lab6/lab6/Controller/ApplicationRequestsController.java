package com.example.lab6.lab6.Controller;

import com.example.lab6.lab6.model.ApplicationRequests;
import com.example.lab6.lab6.Service.ApplicationRequestsService;
import com.example.lab6.lab6.Service.CoursesService;
import com.example.lab6.lab6.Service.OperatorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/requests")
public class ApplicationRequestsController {

    private final ApplicationRequestsService requestsService;
    private final CoursesService coursesService;
    private final OperatorsService operatorsService;

    public ApplicationRequestsController(ApplicationRequestsService requestsService,
                                         CoursesService coursesService,
                                         OperatorsService operatorsService) {
        this.requestsService = requestsService;
        this.coursesService = coursesService;
        this.operatorsService = operatorsService;
    }

    @GetMapping
    public String listRequests(Model model) {
        model.addAttribute("requests", requestsService.getAllRequests());
        return "requests";
    }

    @GetMapping("/add")
    public String addRequestForm(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        model.addAttribute("request", new ApplicationRequests());
        return "add-request";
    }

    @PostMapping("/add")
    public String addRequest(@ModelAttribute ApplicationRequests request, @RequestParam Long courseId) {
        requestsService.addRequest(request, courseId);
        return "redirect:/requests";
    }

    @GetMapping("/{id}/process")
    public String processRequest(@PathVariable Long id, Model model) {
        model.addAttribute("request", requestsService.getRequestById(id));
        model.addAttribute("operators", operatorsService.getAllOperators());
        return "process-request";
    }

    @PostMapping("/{id}/assign")
    public String assignOperator(@PathVariable Long id, @RequestParam Long operatorId) {
        requestsService.assignOperator(id, operatorId);
        return "redirect:/requests";
    }


    @PostMapping("/{requestId}/removeOperator/{operatorId}")
    public String removeOperator(@PathVariable Long requestId, @PathVariable Long operatorId) {
        requestsService.removeOperator(requestId, operatorId);
        return "redirect:/requests/" + requestId + "/process";
    }

    @PostMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestsService.deleteRequest(id);
        return "redirect:/requests";
    }
}
