package org.example.mapper;

import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.example.api.dto.CommentDto;
import org.example.model.Comment;
import org.example.model.Employee;
import org.example.model.Task;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:13:43+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto mapToDto(Comment source) {
        if ( source == null ) {
            return null;
        }

        UUID employee = null;
        UUID id = null;
        String text = null;
        Instant created = null;

        employee = sourceEmployeeId( source );
        id = source.getId();
        text = source.getText();
        created = source.getCreated();

        CommentDto commentDto = new CommentDto( id, text, employee, created );

        return commentDto;
    }

    @Override
    public Comment mapToEntity(String source, Task task, Employee employee) {
        if ( source == null && task == null && employee == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( source );
        comment.setTask( task );
        comment.setEmployee( employee );

        return comment;
    }

    private UUID sourceEmployeeId(Comment comment) {
        Employee employee = comment.getEmployee();
        if ( employee == null ) {
            return null;
        }
        return employee.getId();
    }
}
