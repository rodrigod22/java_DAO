package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
					
		Scanner sc = new Scanner(System.in);
		
			SellerDao sellerDao = DaoFactory.createSellerDao();			
			System.out.println("====== TEST 1: seller findById =====");			
			Seller seller = sellerDao.findById(3);			
			System.out.println(seller);
			
			System.out.println();
			
			System.out.println("====== TEST 2: seller findByDepartment =====");			
			Department department = new Department(2, null);			
			List<Seller> list = sellerDao.findByDepartment(department);			
			for (Seller obj : list) {
				System.out.println(obj);
			}
			
			System.out.println();
			
			System.out.println("====== TEST 3: seller findByAll =====");			
		    list = sellerDao.findAll();			
			for (Seller obj : list) {
				System.out.println(obj);
			}
			
			System.out.println("====== TEST 4: seller INSERT =====");			
		    Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted New id = " + newSeller.getId());
			
			
			System.out.println("====== TEST 5: seller UPDATE =====");	
			seller = sellerDao.findById(9);
			seller.setName("Maria de Jesus");
			sellerDao.update(seller);
			System.out.println("Update completed");
			
			
			System.out.println("====== TEST 6: seller DELETE=====");	
			System.out.println("Enter id for delete teste: ");
			int id =sc.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Delete completed");
			sc.close();
	}
}
