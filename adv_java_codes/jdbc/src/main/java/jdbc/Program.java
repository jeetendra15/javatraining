package jdbc;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> employees = JdbcRepository.getEmployee();
		int rowInserted = JdbcRepository.addEmployee();
		
		System.out.println(employees);
		System.out.println(rowInserted);
	}

}
