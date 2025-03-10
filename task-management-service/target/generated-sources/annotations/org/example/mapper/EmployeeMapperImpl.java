package org.example.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.example.api.dto.CommentDto;
import org.example.api.dto.EmployeeDto;
import org.example.api.dto.TaskDto;
import org.example.api.dto.UserInfoDto;
import org.example.enums.UserRole;
import org.example.model.Comment;
import org.example.model.Employee;
import org.example.model.Task;
import org.example.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:13:43+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public EmployeeDto mapToDto(Employee source) {
        if ( source == null ) {
            return null;
        }

        UUID id = null;
        UserInfoDto userInfo = null;
        List<TaskDto> tasksAssignedByMe = null;
        Set<TaskDto> tasksAssignedToMe = null;
        Set<CommentDto> commentsWrittenByMe = null;
        Instant created = null;

        id = source.getId();
        userInfo = userInfoToUserInfoDto( source.getUserInfo() );
        tasksAssignedByMe = taskListToTaskDtoList( source.getTasksAssignedByMe() );
        tasksAssignedToMe = taskSetToTaskDtoSet( source.getTasksAssignedToMe() );
        commentsWrittenByMe = commentListToCommentDtoSet( source.getCommentsWrittenByMe() );
        created = source.getCreated();

        EmployeeDto employeeDto = new EmployeeDto( id, userInfo, tasksAssignedByMe, tasksAssignedToMe, commentsWrittenByMe, created );

        return employeeDto;
    }

    @Override
    public Employee mapToEntity(UserInfo source) {
        if ( source == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setUserInfo( source );

        return employee;
    }

    protected UserInfoDto userInfoToUserInfoDto(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        String username = null;
        UserRole role = null;
        boolean accountNonExpired = false;
        boolean accountNonLocked = false;
        boolean credentialsNonExpired = false;
        boolean enabled = false;

        username = userInfo.getUsername();
        role = userInfo.getRole();
        accountNonExpired = userInfo.isAccountNonExpired();
        accountNonLocked = userInfo.isAccountNonLocked();
        credentialsNonExpired = userInfo.isCredentialsNonExpired();
        enabled = userInfo.isEnabled();

        UserInfoDto userInfoDto = new UserInfoDto( username, role, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled );

        return userInfoDto;
    }

    protected List<TaskDto> taskListToTaskDtoList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDto> list1 = new ArrayList<TaskDto>( list.size() );
        for ( Task task : list ) {
            list1.add( taskMapper.mapToDto( task ) );
        }

        return list1;
    }

    protected Set<TaskDto> taskSetToTaskDtoSet(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskDto> set1 = new LinkedHashSet<TaskDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Task task : set ) {
            set1.add( taskMapper.mapToDto( task ) );
        }

        return set1;
    }

    protected Set<CommentDto> commentListToCommentDtoSet(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        Set<CommentDto> set = new LinkedHashSet<CommentDto>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : list ) {
            set.add( commentMapper.mapToDto( comment ) );
        }

        return set;
    }
}
