package org.example.repository;

import org.example.enums.TaskStatusType;
import org.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Modifying
    @Query(value = "update Task task set task.status = :status where task.id = :taskId")
    void changeTaskStatus(UUID taskId, TaskStatusType status);

    @Query(value = """
            select exists (
            select 1
            from task_assignee assignee
            where assignee.task_id = :taskId and assignee.employee_id = :employeeId
        )
        """, nativeQuery = true)
    boolean isTaskOwner(UUID taskId, UUID employeeId);
}
