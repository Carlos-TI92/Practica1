package com.isil.productmanagment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isil.productmanagement.model.Product;
import com.isil.productmanagement.util.Constants;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Abel Huarca [Isil]
 *
 */
public class ProductDAO {

	public ProductDAO() {
	}


	public void insertProduct(Product product) throws SQLException {
		System.out.println(Constants.INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Conexion.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_USERS_SQL)) {
			preparedStatement.setString(1, product.getNameproduct());
			preparedStatement.setString(2, product.getNameprov());
			preparedStatement.setString(3, product.getProducttype());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Product selectProduct(int id) {
		Product user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("nameproduct");
				String email = rs.getString("nameprov");
				String country = rs.getString("producttype");
				user = new Product(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Product> selectAllProducts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Product> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nameproduct");
				String email = rs.getString("nameprov");
				String country = rs.getString("producttype");
				users.add(new Product(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateProduct(Product product) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_USERS_SQL);) {
			statement.setString(1, product.getNameproduct());
			statement.setString(2, product.getNameprov());
			statement.setString(3, product.getProducttype());
			statement.setInt(4, product.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
