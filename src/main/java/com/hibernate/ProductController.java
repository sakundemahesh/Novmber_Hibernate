package com.hibernate;

import java.util.List;
import java.util.Scanner;

import com.hibernate.entity.Product;
import com.hibernate.service.ProductService;
import com.hibernate.utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {

		char ch;
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();

		do {
			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for get product by id");
			System.out.println("Press 3 for delete product by id");
			System.out.println("Press 4 for update product");
			System.out.println("Press 5 get all product");
			System.out.println("Press 6 for greter than product price");
			System.out.println("press 7 for equal to product name");
			System.out.println("press 8 for like operation");
			System.out.println("press 9 for inbuild criteria operation ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("insert record");
				Product product = ProductUtility.preparedProductData(scanner);
				boolean isAdded = service.saveProduct(product);
				if (isAdded) {
					System.out.println("Saved!!");
				} else {
					System.out.println("Product Already Exists with Id " + product.getProductId());
				}

				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				long productId = scanner.nextLong();
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Product not Exists !!Id=" + productId);

				}
				break;
			}
			case 3: {
				System.out.println("Enter product id");
				long productId = scanner.nextLong();
				boolean isDeleted = service.deleteProductById(productId);
				if (isDeleted) {
					System.out.println("deleted");
				} else {
					System.out.println("Not Deleted");
				}
				break;
			}
			case 4: {
				System.out.println("Enter product id for update");
				Product product = ProductUtility.preparedProductData(scanner);
				boolean isUpdated = service.updateProduct(product);
				if (isUpdated) {
					System.out.println("update");
				} else {
					System.out.println("not update");
				}
				break;
			}
			case 5: {
				System.out.println("get all List");
				List<Product> product = service.getAllProduct();
				if (product.isEmpty() || product == null) {
					System.out.println("no record");
				} else {
					for (Product product2 : product) {
						System.out.println(product2);
					}
				}
				break;
			}
			case 6: {
				System.out.println("price is more than ");
				List<Product> list = service.priceGreterThan();
				if (list.isEmpty()) {
					System.out.println("not available !!");

				} else {
					for (Product product : list) {
						System.out.println(product);
					}

				}
				break;
			}
			case 7: {
				System.out.println("fetch detail by product name");
				List<Product> list = service.equalToProductName();
				if (list.isEmpty()) {
					System.out.println("Product not found");

				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;
			}
			case 8: {
				System.out.println("fetch product");
				List<Product> list = service.likeProductName();
				if (list.isEmpty()) {
					System.out.println("not fount");

				} else {
					for (Product product : list) {
						System.out.println(product);
					}

				}
				break;
			}
			case 9: {
				do {
					System.out.println("criteria inbuild method ");
					System.out.println("press 1 for product grethar than equal");
					System.out.println("press 2 for product grethar than");
					System.out.println("press 3 for product less than equal");
					System.out.println("press 4 for less than");
					System.out.println("press 5 for like operation");
					System.out.println("press 6 product order by asc");
					System.out.println("press 7 product order by desc");
					System.out.println("press 8 product not in present");
					System.out.println("press 9 product in present");
					System.out.println("press 10 for Between");
					System.out.println("press 11 for To check if the given property is null");
					System.out.println("press 12 for To check if the given property isNotnull");
					System.out.println("press 13 for To check if the given property is empty");
					System.out.println("press 14 for To get total row count");
					 
					int no = scanner.nextInt();
					if (no>0) {
						System.out.println(no);
					}else {
						System.out.println("enter valid no");
					}

					switch (no) {
					case 1: {
						System.out.println("gretar than equal to");
						List<Product> list = service.getProductGretarThanEqual();
						if (list.isEmpty()) {
							System.out.println("not available ");

						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}

						break;
					}
					case 2: {
						System.out.println("gretar than equal to");
						List<Product> list = service.getProductGretarThan();
						if (list.isEmpty()) {

						} else {
							for (Product product : list) {
								System.out.println(product);
							}
						}
						break;
					}
					
					case 3:{
						System.out.println("less than equal to");
						List<Product> list=service.getProductLessThanEqual();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						break;
					
					}
					
					case 4 :{
						System.out.println("less than equal");
						List<Product> list=service.getProductLessThan();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 5 :{
						System.out.println("like operation");
						List<Product> list=service.sameProductName();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 6 :{
						System.out.println("product order by asc");
						List<Product> list=service.producOrderByAsce();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 7 :{
						System.out.println("roduct order by desc");
						List<Product> list=service.producOrderByDesc();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					case 8 :{
						System.out.println("product not in present");
						List<Product> list=service.producIsNotPresent();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 9:{
						System.out.println("product in present");
						List<Product> list=service.producIsPresent();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 10:{
						System.out.println("product between");
						List<Product> list=service.productInBetween();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 11:{
						System.out.println("product is not null");
						List<Product> list=service.productIsNull();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 12:{
						System.out.println("product is not null");
						List<Product> list=service.productIsNotNull();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 13:{
						System.out.println("To check if the given property is empty");
						List<Product> list=service.productIsEmpty();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					
					case 14:{
						System.out.println("To get total row count");
						List<Product> list=service.productTotalRowCount();
						if (list.isEmpty()) {
							System.out.println("not available");
							
						} else {
							for (Product product : list) {
								System.out.println(product);
							}

						}
						
						break;
					
					}
					default:
						break;
					}

					System.out.println("Do You Want To Continue with Criteria y/n");
					ch = scanner.next().charAt(0);
				} while (ch == 'y' || ch == 'Y');
				System.out.println("Exist Criteria !!! ");
				break;
			}
			
			default:
				break;
			}

			System.out.println("do you want to continue y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		System.out.println("terminated");
	}
}
