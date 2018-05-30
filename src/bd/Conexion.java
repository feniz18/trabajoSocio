package bd;

import java.sql.*;

public class Conexion {
	
	public static Connection conexion;
	
	public static String url = "jdbc:mysql://localhost:3306/perrito?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static String usuario = "root";
	
	public static String contrasena = "";
	
	public static Statement estado;
	
	public static Statement irConexion()
	{
		
		try 
		{

			conexion = DriverManager.getConnection(url,usuario,contrasena);
			
			estado = conexion.createStatement();
		
			
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return estado;
		
	}
	
	
	

}
