package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JdbcRepository {

	public static List<String> getEmployee() {

		List<String> listOfEmployee = new ArrayList<String>();
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "jeetendra", "");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");

			while (resultSet.next()) {

				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setEmpName(resultSet.getString("empName"));

				ObjectMapper objectMapper = new ObjectMapper();
				String data = objectMapper.writeValueAsString(employee);

				listOfEmployee.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listOfEmployee;
	}

	public static int addEmployee() {

		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setEmpName("ram");

		Connection con = null;

		int inerted = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "jeetendra", "");
			PreparedStatement preparedStatement = con.prepareStatement("insert into employee values(?,?)");
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());

			inerted = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return inerted;
	}
}
