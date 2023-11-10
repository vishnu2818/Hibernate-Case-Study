package hibernate_case_study_1.entity;

import java.util.*;
import javax.persistence.*;

@Entity
public class Cart 
{
	@Id
	private int cartId;
	
	@OneToMany
	private List<Product> products = new ArrayList<Product>();
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}
}
