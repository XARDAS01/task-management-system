package org.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;
import java.util.UUID;

@StaticMetamodel(Comment.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Comment_ {

	
	/**
	 * @see org.example.model.Comment#task
	 **/
	public static volatile SingularAttribute<Comment, Task> task;
	
	/**
	 * @see org.example.model.Comment#created
	 **/
	public static volatile SingularAttribute<Comment, Instant> created;
	
	/**
	 * @see org.example.model.Comment#id
	 **/
	public static volatile SingularAttribute<Comment, UUID> id;
	
	/**
	 * @see org.example.model.Comment#text
	 **/
	public static volatile SingularAttribute<Comment, String> text;
	
	/**
	 * @see org.example.model.Comment#employee
	 **/
	public static volatile SingularAttribute<Comment, Employee> employee;
	
	/**
	 * @see org.example.model.Comment
	 **/
	public static volatile EntityType<Comment> class_;

	public static final String TASK = "task";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String TEXT = "text";
	public static final String EMPLOYEE = "employee";

}

