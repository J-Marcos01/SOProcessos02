package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main
{

	public static void main(String[] args) 
	{
		KillController kill = new KillController();
		
		int opc=0;
		
		while(opc!=9)
		{
			opc=Integer.parseInt(JOptionPane.showInputDialog("Digite:\n1-Listar processos\n2-Matar por PID\n3-Matar por nome\n9-Finalizar."));
			switch(opc)
			{
			case 1:
			{
				kill.listaProcessos();
				break;
			}
			case 2:
			{
				kill.mataPid();
				break;
			}
			case 3:
			{
				kill.mataNome();
				break;
			}
			case 9:
			{
				System.out.println("FIM");
				break;
			}
			default:
			{
				System.out.println("Valor inválido");
			}
			
			}
		}		
	}
}

