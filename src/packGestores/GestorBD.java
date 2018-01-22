package packGestores;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class GestorBD {
	
	private static GestorBD miGestorBD;
	//private String ConexionBD = "jdbc:mysql://158.227.106.21:3306/Xavelez012_AdminEvoSudoku";
	//private String db= "Battleship";
	private String ConexionBD = "jdbc:mysql://localhost:3306/Battleship";
	private String SentenciaSQL;
	private String user = "root";
	private String password = "";
	private Connection CanalBD;
	private Statement Instruccion;
	private ResultSet Resultado;
	
	private GestorBD(){
		try{
			
			this.CanalBD = DriverManager.getConnection(this.ConexionBD, user, password);
			this.Instruccion = this.CanalBD.createStatement();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error en la conexion con BD\nERROR : "+e.getMessage());
		}
	}
	
	/*
	 * devolver la bd
	 */
	public static GestorBD getGestorBD(){
		if(miGestorBD == null){
			miGestorBD = new GestorBD();
		}
		return miGestorBD;
	}
	
	/*
	 * sentencia update, insert y delete
	 */
	public void Update(String SentenciaSQL){
		this.SentenciaSQL = SentenciaSQL;
		try{
			this.Instruccion.executeUpdate(this.SentenciaSQL);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error Al modificar\nERROR : "+e.getMessage());			
		}
	}
		/*
		 * sentencias select que lo devuelve en un resulset
		 */
	public ResultSet Select(String SentenciaSQL){
		this.SentenciaSQL = SentenciaSQL;
		
		try{
			this.Resultado = Instruccion.executeQuery(this.SentenciaSQL);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al cargar los datos\nERROR : "+e.getMessage());			
		}
		
		return Resultado;
	}	
	
	
}
