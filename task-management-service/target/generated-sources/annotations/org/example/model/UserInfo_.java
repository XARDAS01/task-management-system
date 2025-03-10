package org.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import org.example.enums.UserRole;

@StaticMetamodel(UserInfo.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserInfo_ {

	
	/**
	 * @see org.example.model.UserInfo#password
	 **/
	public static volatile SingularAttribute<UserInfo, String> password;
	
	/**
	 * @see org.example.model.UserInfo#role
	 **/
	public static volatile SingularAttribute<UserInfo, UserRole> role;
	
	/**
	 * @see org.example.model.UserInfo#credentialsNonExpired
	 **/
	public static volatile SingularAttribute<UserInfo, Boolean> credentialsNonExpired;
	
	/**
	 * @see org.example.model.UserInfo#accountNonExpired
	 **/
	public static volatile SingularAttribute<UserInfo, Boolean> accountNonExpired;
	
	/**
	 * @see org.example.model.UserInfo
	 **/
	public static volatile EmbeddableType<UserInfo> class_;
	
	/**
	 * @see org.example.model.UserInfo#enabled
	 **/
	public static volatile SingularAttribute<UserInfo, Boolean> enabled;
	
	/**
	 * @see org.example.model.UserInfo#username
	 **/
	public static volatile SingularAttribute<UserInfo, String> username;
	
	/**
	 * @see org.example.model.UserInfo#accountNonLocked
	 **/
	public static volatile SingularAttribute<UserInfo, Boolean> accountNonLocked;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String CREDENTIALS_NON_EXPIRED = "credentialsNonExpired";
	public static final String ACCOUNT_NON_EXPIRED = "accountNonExpired";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";
	public static final String ACCOUNT_NON_LOCKED = "accountNonLocked";

}

