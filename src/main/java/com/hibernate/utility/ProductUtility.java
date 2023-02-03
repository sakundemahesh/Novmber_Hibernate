package com.hibernate.utility;

import java.util.Scanner;

import com.hibernate.entity.Product;

public class ProductUtility {

	public static Product preparedProductData(Scanner scanner) {
		System.out.println("Enter product id");
		long productId=scanner.nextLong();
		
		System.out.println("Enter productName");
		String productName=scanner.next();
		
		System.out.println("Enter supplier Id");
		long supplierId=scanner.nextLong();
		
		System.out.println("Enter category Id");
		long categoryId=scanner.nextLong();
		
		System.out.println("Enter product Qty");
		int productQty=scanner.nextInt();
		
		System.out.println("Enter product price");
		double produtPrice=scanner.nextDouble();
		
		Product product= new Product(productId, productName, supplierId, categoryId, productQty,produtPrice);
		
		return product;
		 
		
	}
	
}
