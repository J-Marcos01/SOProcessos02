package controller;
/*
		A classe KillController.java deve ter 4 métodos.
		1) O primeiro, chamado os, que identifica e retorna o nome do Sistema Operacional (Fazê-lo
		privado)
		2) O segundo, chamado listaProcessos, que verifica o SO e, de acordo com SO, selecione o
		comando para listar os processos ativos.
		O método deve receber todas as linhas de saída do processo de listagem e exibi-las em console
		3) O terceiro, chamado mataPid, que recebe um PID como parâmetro de entrada, verifica o SO
		e, de acordo com SO, selecione o comando para matar o processo e o finalize
		4) O quarto, chamado mataNome, que recebe um nome de processo como parâmetro de
		entrada, verifica o SO e, de acordo com SO, selecione o comando para matar o processo e o
		finalize

		Dicas:
		1) Chamada de processo para listagem da tabela de processos:
		Windows: TASKLIST /FO TABLE
		Linux: ps -ef
		2) Chamada de processo que mata processo por PID:
		Windows: TASKKILL /PID pid_do_processo
		Linux: kill -9 pid_do_processo
		3) Chamada de processo que mata processo por Nome:
		Windows: TASKKILL /IM nome_do_processo
		Linux: pkill -f nome_do_processo
		*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController
{

	public KillController() 
	{
		super();
		
	}
	
	private String os()
	{
		String so;
		so=System.getProperty("os.name");
		System.out.println(so);
		return so;
		
	}
	
	public void listaProcessos()
	{
	
		String so=os();
		
		if(so.contains("Windows"))
		{
			String proc="tasklist /fo table";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				
				while(linha!=null)
				{	
					System.out.println(linha);
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}catch(Exception e) {
				String msg=e.getMessage();
				if(msg.contains("740"))
				{
					StringBuffer buffer =new StringBuffer();
					buffer.append("cmd /c");
					buffer.append(" ");
					buffer.append(proc);
				}
				
			}
			
			
			
		}
		else if(so.contains("Linux"))
		{
			String proc="ps -ef";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				
				while(linha!=null)
				{	
					System.out.println(linha);
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}catch(Exception e) {
				System.err.println(e);
			}
			
		}
		
	
	}
	public void mataPid()
	{
	
		String so=os();
		
		if(so.contains("Windows"))
		{
			String proc=JOptionPane.showInputDialog("Digite o PID");
			StringBuffer buffer =new StringBuffer();
			buffer.append("taskkill /pid");
			buffer.append(" ");
			buffer.append(proc);
			String kill=buffer.toString();
			String [] arrProc=kill.split(" ");		
			try {
				Runtime.getRuntime().exec(arrProc);
			}catch(Exception e) {
				System.err.println(e);
			}
							
			
		}
		else if(so.contains("Linux"))
		{
			String proc=JOptionPane.showInputDialog("Digite o PID");
			StringBuffer buffer =new StringBuffer();
			buffer.append("kill -9");
			buffer.append(" ");
			buffer.append(proc);
			String kill=buffer.toString();
			String [] arrProc=kill.split(" ");		
			try {
				Runtime.getRuntime().exec(arrProc);
			}catch(Exception e) {
				System.err.println(e);
			}
			
		}
		
	
	}
	
	public void mataNome()
	{
	String so=os();
	
	if(so.contains("Windows"))
	{
		String proc=JOptionPane.showInputDialog("Digite o Nome do processo");
		StringBuffer buffer =new StringBuffer();
		buffer.append("taskkill /im");
		buffer.append(" ");
		buffer.append(proc);
		String kill=buffer.toString();
		String [] arrProc=kill.split(" ");		
		try {
			Runtime.getRuntime().exec(arrProc);
		}catch(Exception e) {
			System.err.println(e);
		}
						
		
	}
	else if(so.contains("Linux"))
	{
		String proc=JOptionPane.showInputDialog("Digite o Nome do processo");
		StringBuffer buffer =new StringBuffer();
		buffer.append("pkill -f");
		buffer.append(" ");
		buffer.append(proc);
		String kill=buffer.toString();
		String [] arrProc=kill.split(" ");		
		try {
			Runtime.getRuntime().exec(arrProc);
		}catch(Exception e) {
			System.err.println(e);
		}
		
	}
}
	
}
	



