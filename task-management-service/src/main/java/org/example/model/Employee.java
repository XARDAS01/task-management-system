package org.example.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@Table(name = "employees")
public class Employee implements DbId<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    private UserInfo userInfo;

    @OneToMany(mappedBy = "assigner")
    private List<Task> tasksAssignedByMe;

    @ManyToMany(mappedBy = "assignees")
    private Set<Task> tasksAssignedToMe = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> commentsWrittenByMe;

    @CreationTimestamp
    private Instant created;
}
