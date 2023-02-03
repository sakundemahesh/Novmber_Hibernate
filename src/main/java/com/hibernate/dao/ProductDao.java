
package com.hibernate.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.OrderBy;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.config.HibernateConfig;
import com.hibernate.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
	Scanner scanner = new Scanner(System.in);

	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		boolean isAdded = false;
		try {
			Product dbProduct = getProductById(product.getProductId());
			if (dbProduct == null) {
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isAdded;

	}

	public Product getProductById(long productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return product;

	}

	public boolean deleteProductById(long productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product product = new Product();
			product.setProductId(productId);
			session.delete(product);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdate = false;
		try {
			Product product2 = getProductById(product.getProductId());
			if (product2 != null) {
				session.update(product);
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isUpdate;
	}

	public List<Product> getAllProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(2);
			criteria.addOrder(Order.desc("productName"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public List<Product> priceGreterThan() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", 1000d));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return list;
	}

	public List<Product> equalToProductName() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", "bag"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return list;
	}

	public List<Product> likeProductName() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "p%r"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getProductGretarThanEqual() {

		System.out.println("enter column name");
		String name = scanner.next();
		System.out.println("enter valu");
		long no = scanner.nextLong();
		if (no > 0) {
			System.out.println(no);
		} else {
			System.out.println("not valid");
		}
		Session session = sessionFactory.openSession();
		List<Product> list = null;

		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.ge(name, no));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getProductGretarThan() {
		System.out.println("enter column name");
		String name = scanner.next();
		System.out.println("enter valu");
		long no = scanner.nextLong();
		if (no > 0) {
			System.out.println(no);
		} else {
			System.out.println("not valid");
		}

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt(name, no));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getProductLessThanEqual() {
		System.out.println("enter column name");
		String name = scanner.next();
		System.out.println("enter valu");
		long no = scanner.nextLong();
		if (no > 0) {
			System.out.println(no);
		} else {
			System.out.println("not valid");
		}

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.le(name, no));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getProductLessThan() {

		System.out.println("enter column name");
		String name = scanner.next();
		System.out.println("enter valu");
		long no = scanner.nextLong();
		if (no > 0) {
			System.out.println(no);
		} else {
			System.out.println("not valid");
		}

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.lt(name, no));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	public List<Product> sameProductName() {

		System.out.println("enter column name");
		String columnname = scanner.next();
		System.out.println("enter valu");
		String ch = scanner.next();

		if (ch == "string") {
			System.out.println(ch);
		} else {
			System.out.println("not valid");
		}

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like(columnname, ch));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> producOrderByAsce() {

		System.out.println("enter column name");
		String name = scanner.next();
		

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc(name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public List<Product> producOrderByDesc() {
		
		System.out.println("enter column name");
		String name = scanner.next();
		

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.desc(name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> producIsNotPresent() {
		
		System.out.println("enter column name");
		String name = scanner.next();
		
		System.out.println("enter value");
		String value = scanner.next();
		

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.ne(name, value));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> producIsPresent() {
		
		
		System.out.println("enter column name");
		String name = scanner.next();
		
		System.out.println("enter value");
		String value = scanner.next();
		

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.in(name, value));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> productInBetween() {
		
		System.out.println("enter column name");
		String name = scanner.next();
		
		System.out.println("enter value");
		Long value1 = scanner.nextLong();
		
		System.out.println("enter value");
		Long value2 = scanner.nextLong();
		
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between(name, value1, value2));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> productIsNull() {
		System.out.println("enter column name");
		String name = scanner.next();
		
		
		
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.isNull(name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> productIsNotNull() {
		System.out.println("enter column name");
		String name = scanner.next();
		
	
		
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.isNotNull(name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> productIsEmpty() {
		System.out.println("enter column name");
		String name = scanner.next();
		
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.isEmpty(name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> productTotalRowCount() {
		
		
		  /*System.out.println("enter column name");
		  String name = scanner.next();*/
		 
		
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.max("Product"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
