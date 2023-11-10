package hibernate_case_study_1.entity;

import java.util.Scanner;

import hibernate_case_study_1.dao.ServiceDAO;

public class App 
{
	public static void main( String[] args )
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 to add Products\n"
				+ "press 2 to GetProducts By ID\n"
				+ "press 3 to getAll Products\n"
				+ "press 4 to update Product\n"
				+ "press 5 to Delete Products\n"
				+ "press 6 to Add Product to Cart\n"
				+ "press 7 to Update Product to Cart\n"
				+ "press 8 to Remove Product to Cart\n"
				+ "press 9 to Terminate the App");
		int num = sc.nextInt();

		switch(num) 
		{
		case 1 :
			ServiceDAO.addProduct();
			break;

		case 2 : 
			ServiceDAO.getProductById();
			break;

		case 3:
			ServiceDAO.getAllProducts();
			break;

		case 4 :
			ServiceDAO.updateProduct();
			break;
		case 5 :
			ServiceDAO.deleteProducts();
			break;
			
		case 6 :
			ServiceDAO.addProductToCart();
			break;
		case 7 :
			ServiceDAO.updateProductToCart();
			break;
		case 8 :
			ServiceDAO.removeCart();
			break;
		case 9 :
			System.out.println("Terminated...");
			break;

		default: System.out.println("Oops! Invalid Selection...");
		}
		sc.close();
	}
}











