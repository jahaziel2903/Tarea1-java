import javax.swing.JOptionPane;
import java.text.Normalizer; 

public class RFC 
{
	public static void main(String[] args)
	{
		String RFC;		//cadena RFC final
		String noMaterno = "";
		//Se pide año de nacimiento al usuario
		String añoNacimiento = JOptionPane.showInputDialog("Año de nacimiento (1920-1999)").trim(); 

		//Se pide mes de nacimiento del usuario 
		String mesNacimiento = JOptionPane.showInputDialog("Mes de nacimiento (1-12)").trim();;

		//Se pide dia de nacimiento del usaurio
		String diaNacimiento = JOptionPane.showInputDialog("Día de nacimiento (1-31)").trim();

		//Pasar a int el año para hacer verificaciones
		int year = Integer.parseInt(añoNacimiento); 
		//Si cumple alguna de las 2 condiciones presentadas los  digitos del año seran 0020
		if(year < 1920 || year > 2000)
			añoNacimiento = "0020";
		//Se obtienen los 2 ult digitos de la cadena
		String añosRFC = añoNacimiento.substring(2,4);

		//Pasar a int el mes para hacer verificaciones
		int month = Integer.parseInt(mesNacimiento); 
		//Si cumple la siguiente condiciones el mes pasará a ser 01
		if(month > 12)
			mesNacimiento = "01";
		//Si es menor a 10 se le agrega un 0 a la izquierda
		if(month > 0 && month < 10)
			mesNacimiento = '0' + mesNacimiento ;

		//Pasar a int el dia para hacer verificaciones
		int day = Integer.parseInt(diaNacimiento); 
		//Si cumple la siguiente condiciones el dia pasará a ser 01
		if(day > 31)
			diaNacimiento = "01";
		//Si es menor a 10 se le agrega un 0 a la izquierda
		if(day > 0 && day < 10)
			diaNacimiento = '0' + diaNacimiento ;

		//Pedir el nombre
		String name = JOptionPane.showInputDialog("Nombre").trim();
		//String copiaName = name;
		//Obtener la primer letra del nombre
		String rfcNombre = name.substring(0,1);
		rfcNombre = rfcNombre.toUpperCase();
		//Se eliminan acentos 
		rfcNombre = rfcNombre.replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U");  

		//String cadenaNombre = Normalizer.normalize(rfcNombre, Normalizer.Form.NFD);   
		//String cleanNombre = cadenaNombre.replaceAll("[^\\p{ASCII}]", ""); 

		//Pedir apellido Paterno
		String apellidoPaterno = JOptionPane.showInputDialog("Apellido Paterno").trim();
		String copiaPaterno = apellidoPaterno;
		apellidoPaterno = apellidoPaterno.toUpperCase().trim();
		//System.out.println(apellidoPaterno);

		//Se eliminan preposiciones, conjunciones y demás del apellido 
		apellidoPaterno = apellidoPaterno.replace("DE", "").replace("LA", "").replace("LAS", "").replace("EL", "").replace("LOS", "").replace("Y", "");  
		
		
		//System.out.println(apellidoPaterno);
		//Se elimina el espacio por si se haya eliminado una preposición
		apellidoPaterno = apellidoPaterno.trim();
		//Se sacan las primeras dos letras del apellido paterno 
		String rfcPaterno = apellidoPaterno.substring(0,2);
		//Se limpian los acentos del apellido
		rfcPaterno = rfcPaterno.replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U");  
		//String cleanPaterno = Normalizer.normalize(rfcPaterno, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");    
		//String cleanPaterno = cadenaPaterno.replaceAll("[^\\p{ASCII}]", ""); 


		//Pedir apellido Materno
		String apellidoMaterno = JOptionPane.showInputDialog("Apellido Materno").trim();
		String copiaMaterno = apellidoMaterno;
		apellidoMaterno = apellidoMaterno.toUpperCase().trim();

		//Si no ingresa apellido,se tomarán las primeras 2 letras del nombre
		if(apellidoMaterno.contentEquals(noMaterno)) 
		{
			apellidoMaterno = name.substring(0,2);  
			RFC = rfcPaterno.toUpperCase() + apellidoMaterno.toUpperCase() +
					 añosRFC + mesNacimiento + diaNacimiento ;
		}
		else
		{
		//System.out.println(apellidoMaterno);
		System.out.println(apellidoMaterno);

		//Se eliminan preposiciones, conjunciones y demás del apellido 
		apellidoMaterno = apellidoMaterno.replace("DE", "").replace("LA", "").replace("LAS", "").replace("EL", "").replace("LOS", "").replace("Y", "");  
		//System.out.println(apellidoMaterno);
		//System.out.println(apellidoMaterno);
		//Se elimina el espacio por si se haya eliminado una preposición
		apellidoMaterno = apellidoMaterno.trim();
		//Se obtiene la primer letra del apellido
		apellidoMaterno = apellidoMaterno.substring(0,1);
		//Se limpian los acentos del apellido
		apellidoMaterno = apellidoMaterno.replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U");  
		RFC = rfcPaterno + apellidoMaterno +
				rfcNombre + añosRFC + mesNacimiento + diaNacimiento ;
		//System.out.println(apellidoMaterno);
		}
		//Se unen todas las partes del RFC
		//RFC = cleanPaterno.toUpperCase() + apellidoMaterno.toUpperCase() +
			//	cleanNombre.toUpperCase() + añosRFC + mesNacimiento + diaNacimiento ;

		//Se imprime el RFC con el msj que se muestra a comtinuación
		System.out.println(RFC);
		JOptionPane.showMessageDialog(null,"El RFC de " + name.toUpperCase() + " "+  copiaPaterno.toUpperCase() + " " + copiaMaterno.toUpperCase() +" es: "+ RFC); 
	}
}
