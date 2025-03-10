package org.example.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.example.api.dto.CommentDto;
import org.example.api.dto.TaskDto;
import org.example.api.request.CreateTaskRequest;
import org.example.enums.TaskPriorityType;
import org.example.enums.TaskStatusType;
import org.example.model.Comment;
import org.example.model.Employee;
import org.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:44:20+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Task mapToEntity(CreateTaskRequest source, Employee employee) {
        if ( source == null && employee == null ) {
            return null;
        }

        Task task = new Task();

        if ( source != null ) {
            task.setTitle( source.title() );
            task.setDescription( source.description() );
            task.setComment( source.comment() );
            task.setPriority( source.priority() );
        }
        if ( employee != null ) {
            task.setAssigner( employee );
            task.setCreated( employee.getCreated() );
        }
        task.setStatus( TaskStatusType.TODO );

        return task;
    }

    @Override
    public TaskDto mapToDto(Task source) {
        if ( source == null ) {
            return null;
        }

        UUID assigner = null;
        List<UUID> assignees = null;
        UUID id = null;
        String title = null;
        String description = null;
        String comment = null;
        TaskStatusType status = null;
        TaskPriorityType priority = null;
        List<CommentDto> comments = null;
        Instant created = null;

        assigner = sourceAssignerId( source );
        assignees = assigneesToUuid( source.getAssignees() );
        id = source.getId();
        title = source.getTitle();
        description = source.getDescription();
        comment = source.getComment();
        status = source.getStatus();
        priority = source.getPriority();
        comments = commentListToCommentDtoList( source.getComments() );
        created = source.getCreated();

        TaskDto taskDto = new TaskDto( id, title, description, comment, status, priority, assigner, assignees, comments, created );

        return taskDto;
    }

    @Override
    public void update(Task target, TaskDto source) {
        if ( source == null ) {
            return;
        }

        target.setTitle( source.title() );
        target.setDescription( source.description() );
        target.setComment( source.comment() );
        target.setStatus( source.status() );
        target.setPriority( source.priority() );
    }

    private UUID sourceAssignerId(Task task) {
        Employee assigner = task.getAssigner();
        if ( assigner == null ) {
            return null;
        }
        return assigner.getId();
    }

    protected List<CommentDto> commentListToCommentDtoList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDto> list1 = new ArrayList<CommentDto>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentMapper.mapToDto( comment ) );
        }

        return list1;
    }
}
