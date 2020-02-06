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
					.getConnection("jdbc:mysql://localhost:3306/alumnes", "root", "");

			stmt = connection.createStatement();
			
			//Si vol inserir
			if(menu == 1){
				stmt.execute("INSERT INTO ALUMNES (NOM, DNI, DATA_NAIXEMENT, ADREÇA, CODI_POSTAL, POBLACIO) VALUES ('PEPE', '82984728P', '1992-12-21', 'C/ CIUTAT 3', '43840', 'TARRAGONA')");
				System.out.println("Inserit correctament");
			//Si vol modificar
			}else if(menu == 2){
				stmt.execute("SELECT NOM,DATA_NAIXEMENT,ADREÇA FROM ALUMNES WHERE DNI = '82984728P'");
				System.out.println("Llistat correctament");
			//Si vol eliminar
			}else if(menu == 3){
				stmt.execute("DELETE FROM ALUMNES WHERE DNI = '82984728P'");
				System.out.println("Eliminat correctament");
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