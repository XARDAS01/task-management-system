package org.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;
import java.util.UUID;

@StaticMetamodel(Employee.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Employee_ {

	
	/**
	 * @see org.example.model.Employee#userInfo
	 **/
	public static volatile SingularAttribute<Employee, UserInfo> userInfo;
	
	/**
	 * @see org.example.model.Employee#tasksAssignedToMe
	 **/
	public static volatile SetAttribute<Employee, Task> tasksAssignedToMe;
	
	/**
	 * @see org.example.model.Employee#created
	 **/
	public static volatile SingularAttribute<Employee, Instant> created;
	
	/**
	 * @see org.example.model.Employee#id
	 **/
	public static volatile SingularAttribute<Employee, UUID> id;
	
	/**
	 * @see org.example.model.Employee#commentsWrittenByMe
	 **/
	public static volatile ListAttribute<Employee, Comment> commentsWrittenByMe;
	
	/**
	 * @see org.example.model.Employee
	 **/
	public static volatile EntityType<Employee> class_;
	
	/**
	 * @see org.example.model.Employee#tasksAssignedByMe
	 **/
	public static volatile ListAttribute<Employee, Task> tasksAssignedByMe;

	public static final String USER_INFO = "userInfo";
	public static final String TASKS_ASSIGNED_TO_ME = "tasksAssignedToMe";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String COMMENTS_WRITTEN_BY_ME = "commentsWrittenByMe";
	public static final String TASKS_ASSIGNED_BY_ME = "tasksAssignedByMe";

}

