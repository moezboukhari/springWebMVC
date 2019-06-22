package com.spring.springWeb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.springWeb.model.User;

@Repository
public class UserDaoImpl  implements UserDao {
	@PersistenceContext
	EntityManager entityManager;
	//SessionFactory sessionFactory;

//	public Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}

	public User authenticate(User user) {
		String query="FROM User WHERE userId=:userId AND password=:password";
		return (User) entityManager.createQuery(query)
				.setParameter("userId", user.getUserId())
				.setParameter("password", user.getPassword()).getSingleResult();

//		return (User) getSession().createCriteria(User.class).add(Restrictions
//				.and(Restrictions.eq("userId", user.getUserId()), Restrictions.eq("password", user.getPassword())))
//				.uniqueResult();
		// System.out.println(usr.toString());
	}

	public List<User> list() {
		//return getSession().createCriteria(User.class).list();
		return entityManager.createQuery("FROM User").getResultList();
	}

	public User getOneUser(Long id) {
		return (User)entityManager.find(User.class,id);
		//return (User) getSession().get(User.class, id);
	}

	public User save(User user) {
//		getSession().saveOrUpdate(user);
		if (user.getId()==null) {
			entityManager.persist(user);
		}
		else {
			entityManager.merge(user);
		}
		
		return user;
		
	}

	public void delete(Long id ) {
		//getSession().delete(user);
		
		entityManager.remove(getOneUser(id));
	}

}
