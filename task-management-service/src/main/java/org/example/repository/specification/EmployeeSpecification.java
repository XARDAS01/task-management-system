package org.example.repository.specification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;
import org.example.api.query.TaskQueryParams;
import org.example.model.Employee;
import org.example.model.Task;
import org.example.model.Task_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class EmployeeSpecification extends AbstractJpaSpecification {

    @NonNull
    public Specification<Task> buildSpecification(@NonNull TaskQueryParams queryParams) {
        return (r, cq, cb) -> {
            final var predicates = new ArrayList<Predicate>();

            Optional.ofNullable(queryParams.title())
                    .ifPresent(title -> predicates.add(cb.equal(r.get(Task_.title), title)));

            Optional.ofNullable(queryParams.assignEmployeeId())
                    .ifPresent(employeeId -> {
                        Employee employee = new Employee();
                        employee.setId(employeeId);
                        predicates.add(cb.isMember(employee, r.get(Task_.assignees)));
                    });

            if (predicates.isEmpty()) {
                log.warn("No predicates were added, returning default predicate.");
                return cb.equal(cb.literal(1), 1);
            }

            log.info("Building specification with {} predicates.", predicates.size());
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}