package hibernate_case_study_1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate_case_study_1.entity.Cart;
import hibernate_case_study_1.entity.Product;

public class ProductDAO 
{
	static Configuration cf = new Configuration().configure().
			addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	static SessionFactory sf = cf.buildSessionFactory();
	static Session session = sf.openSession();
	static Transaction trans = session.beginTransaction();

	public static void addProduct(Product product) 
	{	 	
		session.save(product);	
		
		trans.commit();
		session.close();
	}

	public static Product getProductById(int id) 
	{
		Product find = session.find(Product.class, id);
		System.out.println(find);

		trans.commit();
		session.close();
		return find;
	}

	@SuppressWarnings("unchecked")
	public static void getAllProducts() 
	{
		Query<Product> query = session.createQuery("from Product");
		List<Product> pList = query.list();
		for(Product product : pList) 
		{
			System.out.println(product.getProductName()+" "+product.getProductId()+" "+product.getProductQuantity());
		}
//		Criteria criteria = session.createCriteria(Product.class);
//		List list = criteria.list();
//		list.forEach(System.out::println);

		trans.commit();
		session.close();

	}
	
	@SuppressWarnings("unchecked")
	public static void updateProduct(int id,int quantity) 
	{
		Query<Product> query = session.createQuery("update Product set productQuantity="+quantity+" where productId="+id);
		int updateCount = query.executeUpdate();
		System.out.println(updateCount+" product Quantity Updated....");
		
		trans.commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public static void updateProduct(int id,double price) 
	{
		Query<Product> query = session.createQuery("update Product set productPrice="+price+" where productId="+id);
		int update = query.executeUpdate();
		System.out.println(update+" Product Price Updated....");
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void updateProduct(int id,String name) 
	{	
		Query<Product> query = session.createQuery("update Product p set p.productName="+"'"+name+"'"+" where p.productId="+id);
		int updateCount = query.executeUpdate();
		System.out.println(updateCount+" productName Updated....");
		
		trans.commit();
		session.close();
	}
	
	public static void deleteProducts(int id) 
	{
		session.delete(Product.class);
		System.out.println("Successfully Deleted...!");
		
		trans.commit();
		session.close();
	}
}
