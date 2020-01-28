package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.daoapi.DaoApi;
import com.spring.entities.Book;
import com.spring.entities.FileUploadBean;
import com.spring.entities.Users;

@Repository
@Transactional
public class DaoImpl implements DaoApi {
	@Autowired
	private SessionFactory factory;
	private static final Log LOG = LogFactory.getLog(DaoImpl.class);

	/*
	 * public List<Users> getUsers() {
	 * 
	 * List l; l = factory.getCurrentSession().createCriteria(Users.class).list();
	 * System.out.println(l); return l;
	 * 
	 * 
	 * }
	 */

	public List<Users> getUsers() {

		Query query = factory.getCurrentSession().createQuery("from Users");
		//query.setCacheable(true);
		return query.list();

	}

	public boolean saveFile(Users user) {
		Query query = factory.getCurrentSession().createQuery("update Users set file=:file" + " where id=:id");
		query.setBinary("file", user.getFile());
		query.setParameter("id", user.getUserId());
		query.executeUpdate();

		return true;
	}

	public boolean signUpUser(Users user) {

		try {
			System.out.println("singup");
			String u = user.getUserEmail();
			LOG.info(u);
			LOG.info("inside dao");
			if (!findDuplicateEmail(u)) {
				factory.getCurrentSession().persist(user);
				return true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Users getUserByEmail(String email) {

		List<Users> list = new ArrayList<Users>();
		list = factory.getCurrentSession().createQuery("from Users where userEmail=:email").setParameter("email", email)
				.list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public boolean findDuplicateEmail(String email) {
		System.out.println("fing");
		Query query = factory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Users  WHERE email=:email");
		query.setString("email", email);
		int count = (int) (long) (Long) query.uniqueResult();
		if (count > 1) {
			System.out.println(count);
			return true;
		}
		return false;
	}

	public boolean addBook(Book book) {
		int n = (Integer) factory.getCurrentSession().save(book);
		if(n>1) {
			return true;
		}
		//System.out.println(b);
		return false;
	}

}