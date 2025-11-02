package com.example.lab6.lab6.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "application_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String phone;
    private String comment;

    private boolean handled;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "request_operators",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operators> operators;
}
