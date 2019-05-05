package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1 - Insert department ===");
		Department dep = new Department(null, "Support");
		depDao.insert(dep);
		System.out.println("Insertion completed!");
		
		System.out.println("=== Test 2 - Update department ===");
		dep = depDao.findById(3);
		dep.setName("HelpDesk");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("=== Test 3 - FindById department ===");
		dep = depDao.findById(4);
		System.out.println(dep);
		
		System.out.println("=== Test 4 - FindAll department ===");
		list = depDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 5 - DeleteById department ===");
		System.out.print("Enter an Id to delete:");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("delete completed!");
		sc.close();
	}
}
