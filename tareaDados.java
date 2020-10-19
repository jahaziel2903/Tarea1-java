import javax.swing.JOptionPane;

public class tareaDados {
	public static void main(String[] args)
	{
		//Se declaran los dos tiros del dado
		int primerTiro, segundoTiro;
		
		//Se generan los dos números del dado de manera aleatorio
		primerTiro = (int) ((Math.random()*6)+1);
		segundoTiro = (int) ((Math.random()*6)+1);

		//System.out.println(primerTiro);
		
		//Se suman los dos lanzamientos para tener el resultado y saber el outcome
		int res = primerTiro + segundoTiro;

		//Si se cumple esta condición el usuario ganó la apuesta y se le muestra que ganó
		if(res == 7 || res == 11)
		{
			JOptionPane.showMessageDialog(null,"Lanzaste "+ primerTiro + "," + segundoTiro +  ".\n Ganaste la apuesta");   
		}
		//Si se cumple esta condición el usuario perdió la apuesta y se le muestra el mensaje
		else if( res == 2 || res == 3 || res == 12)
		{
			JOptionPane.showMessageDialog(null,"Lanzaste "+ primerTiro + "," + segundoTiro +  ".\n Pierdes la apuesta: craps");   
		}
		//Cualquier otra condición se le muestra al usuario que ganó un punto 
		else
		{
			JOptionPane.showMessageDialog(null,"Lanzaste "+ primerTiro + "," + segundoTiro +  ".\n Ganas un punto");   

		}
	}
}
