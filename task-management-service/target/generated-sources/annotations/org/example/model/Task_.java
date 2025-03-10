package org.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;
import java.util.UUID;
import org.example.enums.TaskPriorityType;
import org.example.enums.TaskStatusType;

@StaticMetamodel(Task.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Task_ {

	
	/**
	 * @see org.example.model.Task#comments
	 **/
	public static volatile ListAttribute<Task, Comment> comments;
	
	/**
	 * @see org.example.model.Task#created
	 **/
	public static volatile SingularAttribute<Task, Instant> created;
	
	/**
	 * @see org.example.model.Task#assigner
	 **/
	public static volatile SingularAttribute<Task, Employee> assigner;
	
	/**
	 * @see org.example.model.Task#description
	 **/
	public static volatile SingularAttribute<Task, String> description;
	
	/**
	 * @see org.example.model.Task#assignees
	 **/
	public static volatile SetAttribute<Task, Employee> assignees;
	
	/**
	 * @see org.example.model.Task#comment
	 **/
	public static volatile SingularAttribute<Task, String> comment;
	
	/**
	 * @see org.example.model.Task#id
	 **/
	public static volatile SingularAttribute<Task, UUID> id;
	
	/**
	 * @see org.example.model.Task#title
	 **/
	public static volatile SingularAttribute<Task, String> title;
	
	/**
	 * @see org.example.model.Task#priority
	 **/
	public static volatile SingularAttribute<Task, TaskPriorityType> priority;
	
	/**
	 * @see org.example.model.Task
	 **/
	public static volatile EntityType<Task> class_;
	
	/**
	 * @see org.example.model.Task#status
	 **/
	public static volatile SingularAttribute<Task, TaskStatusType> status;

	public static final String COMMENTS = "comments";
	public static final String CREATED = "created";
	public static final String ASSIGNER = "assigner";
	public static final String DESCRIPTION = "description";
	public static final String ASSIGNEES = "assignees";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String PRIORITY = "priority";
	public static final String STATUS = "status";

}

