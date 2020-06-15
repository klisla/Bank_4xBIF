package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domain.BankAccountException;

public class OracleConnection 
{
	
	private Connection con;
	//einbinden des JDBL treibers ins projekt
	public OracleConnection() throws BankAccountException
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} 
		catch (ClassNotFoundException e)
		{
			throw new BankAccountException("Couldn´t find database driver!");
		}
	}
	//Öffnen der Datenbankverbindung
	public void open() throws BankAccountException
	{
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "DEMO", "oracle");
		} 
		catch (SQLException e) 
		{
			throw new BankAccountException("Couldn´t open database connection!");
		}
	}
	
	public void close() throws BankAccountException
	{
		try {
			con.close();
		} catch (SQLException e) 
		{
			throw new BankAccountException("Couldnt close!");
		}
	}
	
	public Connection getConnection()
	{
		return con;
	}
	
	
	
}