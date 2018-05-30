package bd;

import java.sql.*;

public class BaseDatos {

	public static void main(String[] args) {
		
		try 
		{
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/perrito?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			
			Statement miEstado = miConexion.createStatement();
			
			ResultSet miResultado = miEstado.executeQuery("SELECT * FROM usuario;");
			
			while(miResultado.next()) 
			{
				System.out.println(miResultado.getInt("id") + " " + miResultado.getString("nombres") + " " + miResultado.getString("apellidos") );
			}
			
			
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
