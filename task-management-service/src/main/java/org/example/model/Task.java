package org.example.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.TaskPriorityType;
import org.example.enums.TaskStatusType;
import org.example.jpa.domain.DbId;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tasks")
public class Task implements DbId<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private String comment;

    @Enumerated(value = EnumType.STRING)
    private TaskStatusType status;
    @Enumerated(value = EnumType.STRING)
    private TaskPriorityType priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee assigner;

    @ManyToMany
    @JoinTable(
            name = "task_assignee",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> assignees = new HashSet<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments;

    @CreationTimestamp
    private Instant created;
}
