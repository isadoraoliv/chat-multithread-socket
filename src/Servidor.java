import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Servidor extends Thread{

	private static ArrayList<BufferedWriter>clientes;
	private static ServerSocket server;
	private String nome;
	private Socket conexao;
	private InputStream in;  
	private InputStreamReader inr;
	private BufferedReader bfr;

	/*
	 * metodo construtor
	 */
	public Servidor(Socket conexao){
		this.conexao = conexao;
		try{
			in  = conexao.getInputStream();
	        inr = new InputStreamReader(in);
	        bfr = new BufferedReader(inr);
	   }
	   catch(IOException e){
		   e.printStackTrace();
	   }
	}

	/*
	 * é acionado e colocado em um thread quando chega um novo cliente
	 * e verifica se tem novas mensagens
	 */
	public void run(){

		try{
			String msg;
			OutputStream ou =  this.conexao.getOutputStream();
			Writer ouw = new OutputStreamWriter(ou);
			BufferedWriter bfw = new BufferedWriter(ouw);
			clientes.add(bfw);
			nome = msg = bfr.readLine();

			while(!"Sair".equalsIgnoreCase(msg) && msg != null){
				msg = bfr.readLine();
				sendToAll(bfw, msg);
				System.out.println(msg);
	       }
		}
		catch (Exception e){
			e.printStackTrace();
	   }
	}

	/*
	 * quando o cliente envia uma mensagem, o servidor
	 * recebe e manda para todos os clientes conectados
	 */
	public void sendToAll(BufferedWriter bwSaida, String msg) throws IOException{

		BufferedWriter bwS;

		for(BufferedWriter bw : clientes){
			bwS = (BufferedWriter)bw;
			if(!(bwSaida == bwS)){
					bw.write(nome + " -> " + msg+"\r\n");
					bw.flush();
			}
		}
	}

	/*
	 * servidor inicia o metodo main e faz
	 * a configuração do servidor socket
	 */
	public static void main(String []args) {

		try{
			JLabel lblMessage = new JLabel("Porta do Servidor:");
			JTextField txtPorta = new JTextField("5000");
			Object[] texts = {lblMessage, txtPorta };
			JOptionPane.showMessageDialog(null, texts);
			server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
			clientes = new ArrayList<BufferedWriter>();
			JOptionPane.showMessageDialog(null,"Servidor ativo na porta: "+
			txtPorta.getText());

		while(true){
			System.out.println("Aguardando conexão...");
	    	Socket conexao = server.accept();
	    	System.out.println("Cliente conectado...");
	    	Thread thread = new Servidor(conexao);
	    	thread.start();
	    }
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
	}
}
