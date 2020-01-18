package com.isil.productmanagement.util;

public class Constants {
	//Constantes
   public static final String JDBC_CLASS="com.mysql.jdbc.Driver";
   public static final String JDBC_URL="jdbc:mysql://localhost:3306/practica?useSSL=false&&serverTimezone=UTC";
   public static final String JDBC_USERNAME="mysql1";
   public static final String JDBC_PASSWORD="123456";
   
   
    public static final String INSERT_USERS_SQL = "INSERT INTO products" + "  (nameproduct, nameprov, producttype) VALUES "
			+ " (?, ?, ?);";
	public static final String SELECT_USER_BY_ID = "select id,nameproduct,nameprov,producttype from products where id =?";
	public static final String SELECT_ALL_USERS = "select * from products";
	public static final String DELETE_USERS_SQL = "delete from products where id = ?;";
	public static final String UPDATE_USERS_SQL = "update products set name = ?,email= ?, country =? where id = ?;";
   
}
