package hibernate_case_study_1.dao;

import java.util.Scanner;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate_case_study_1.entity.Cart;
import hibernate_case_study_1.entity.Product;

public class ServiceDAO 
{
	static Scanner sc = new Scanner(System.in);
	
	static Configuration cfg = new Configuration().configure()
			.addAnnotatedClass(Product.class).addAnnotatedClass(Cart.class);
	static SessionFactory sessionFactory = cfg.buildSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();
	public static void addProduct() 
	{	 
		
		Product product = new Product();
		System.out.println("enter Product ID");
		product.setProductId(sc.nextInt());
		System.out.println("enter Your Product Name");
		product.setProductName(sc.next());
		System.out.println("enter Your Product Price");
		product.setProductPrice(sc.nextDouble());
		System.out.println("enter Your Product Quantity");
		product.setProductQuantity(sc.nextInt());
		
		ProductDAO.addProduct(product);		
	}

	public static void getProductById() 
	{
		System.out.println("Enter Your Product ID:");
		ProductDAO.getProductById(sc.nextInt());
	}

	public static void getAllProducts() 
	{
		ProductDAO.getAllProducts();
	}

	public static void updateProduct() 
	{
		System.out.println("press 1 to update Product Name\n"
				+ "press 2 to update Product Price\n"
				+ "press 3 to Update Product Quantity");
		switch(sc.nextInt()) 
		{
		case 1:
			System.out.println("Enter Id");
			int id = sc.nextInt();
			
			Product product = session.get(Product.class, id);
			if(product != null) {
			System.out.println(product);
			System.out.println("enter Product Name");
			ProductDAO.updateProduct(id, sc.next());
			}
			else {
				System.out.println("There is No Data....");
			}
			break;

		case 2:
			System.out.println("Enter Id");
			int id1 = sc.nextInt();
			
			Product product1 = session.get(Product.class, id1);
			if(product1 != null) {
			System.out.println(product1);
			
			System.out.println("Enter Product Price");
			ProductDAO.updateProduct(id1,sc.nextDouble());
			}else {
				System.out.println("There is No Data....");
			}
			break;

		case 3:
			System.out.println("Enter Id");
			int id2 = sc.nextInt();
			Product product2 = session.get(Product.class, id2);
			if(product2 != null) {
			System.out.println(product2);
			
			System.out.println("Enter Quantity");
			ProductDAO.updateProduct(id2, sc.nextInt());
			}else {
				System.out.println("There is No Data....");
			}
			break;
		default : System.out.println("Oops! Invalid Selection...");
		}
	}

	public static void deleteProducts() {
		System.out.println("enter Id");
		ProductDAO.deleteProducts(sc.hashCode());
	}
	
	/* >>>>>>>>>>>>>>>>Cart<<<<<<<<<<<<<<<<<<< */

	public static void addProductToCart() 
	{
		System.out.println("Enter Your Cart Id");
		int id = sc.nextInt();
		Cart cartt = session.get(Cart.class, id);
		
		if(cartt == null) {
			Cart cart = new Cart();
			cart.setCartId(id);
			
			System.out.println(">>>>>>>>>>Cart Got Created<<<<<<<<<<");	
			
			System.out.print("How Many Products add to cart: ");
			int numberOfProducts = sc.nextInt();
			while(numberOfProducts !=0) {
				CartDAO.addProduct();
				numberOfProducts--;
			}
			session.save(cart);
		}else {
			System.out.println("Already Cart is there...");
			System.out.print("How Many Products add to cart: ");
			int numberOfProducts = sc.nextInt();
			while(numberOfProducts !=0) {
				CartDAO.addProduct();
				numberOfProducts--;
			}
		}
		transaction.commit();
		session.close();
	}

	public static void updateProductToCart() {

	}

	public static void removeCart() {
		
	}
}













