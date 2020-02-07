import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InsertDataDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		
		//Menu per demanar al usuari que vol fer
		System.out.println("1= Inserir alumne || 2= Modificar alumne || 3= Esborrar alumne");
		Scanner teclado = new Scanner(System.in);
		int menu = teclado.nextInt();
		
		//Menu per demanar al usuari que vol fer
		System.out.println("1= Inserir poblacio || 2= Modificar poblacio || 3= Esborrar poblacio");
		int menu2 = teclado.nextInt();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/alumnes", "root", "");

			stmt = connection.createStatement();
			
			//Si vol inserir
			if(menu == 1){
				try{
					stmt.execute("INSERT INTO ALUMNES (NOM, DNI, DATA_NAIXEMENT, ADREÇA, CODI_POSTAL) VALUES ('PEPE', '82984728P', '1992-12-21', 'C/ CIUTAT 3', '43840')");
					System.out.println("Inserit correctament");
				}catch(MySQLIntegrityConstraintViolationException e){
					e.printStackTrace();
					System.out.println("Codi postal no valid");
				}
				
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
			
			//Si vol inserir
			if(menu2 == 1){	
				try{
					stmt.execute("INSERT INTO POBLACIO (NOM, CODI_POSTAL) VALUES ('SALOU', '43840')");
					System.out.println("Inserit correctament");
				}catch(MySQLIntegrityConstraintViolationException e){
					e.printStackTrace();
					System.out.println("Codi postal no valid");
				}
			//Si vol modificar
			}else if(menu2 == 2){
				stmt.execute("SELECT NOM WHERE CODI_POSTAL = '43840'");
				System.out.println("Llistat correctament");
			//Si vol eliminar
			}else if(menu2 == 3){
				stmt.execute("DELETE FROM POBLACIO WHERE CODI_POSTAL = '43840'");
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