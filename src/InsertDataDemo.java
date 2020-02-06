import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDataDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		
		//Menu per demanar al usuari que vol fer
		System.out.println("1= Inserir || 2= Modificar || 3= Esborrar");
		Scanner teclado = new Scanner(System.in);
		int menu = teclado.nextInt();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/JDBCDemo", "root", "admin");

			stmt = connection.createStatement();
			
			//Si vol inserir
			if(menu == 1){
				stmt.execute("INSERT INTO ALUMNES (NOM, DNI, DATA_NAIXEMENT, ADREÇA, CODI_POSTAL, POBLACIO) "
						+ "VALUES (PEPE, 829384728P, 20/12/1992, C/ CIUTAT 3, 43840, TARRAGONA)");
			//Si vol modificar
			}else if(menu == 2){
				
			//Si vol eliminar
			}else if(menu == 3){
				stmt.execute("DELETE FROM ALUMNES WHERE DNI == 829384728P");
			//Si no entra al menu
			}else{
				System.out.println("error");
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}