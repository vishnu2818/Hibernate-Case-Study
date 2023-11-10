package hibernate_case_study_1.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate_case_study_1.entity.Cart;
import hibernate_case_study_1.entity.Product;

public class CartDAO 
{
	static Scanner sc = new Scanner(System.in);
	static Configuration cf = new Configuration().configure().
			addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	static SessionFactory sf = cf.buildSessionFactory();
	static Session session =  sf.openSession();
	static Transaction transaction = session.beginTransaction();

    //createCart
	//  updateProduct3
	//	addProductToCart1
	//	removeCard2
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void addProduct()
	{
		
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> productList = criteria.list();
		System.out.println("<<<<<<<<<<<Product List>>>>>>>>>>>");
		productList.forEach(System.out::println);
		
		System.out.print("select Product Enter Product ID: ");
		
		Product productById = session.get(Product.class, sc.nextInt());
		Cart cart = new Cart();
		cart.getProducts().add(productById);
		
//		session.save(cart);
//		
//		transaction.commit();
//		session.close();
//		cart.getProducts().add(product);
//		cart.setProducts();
	}
}
