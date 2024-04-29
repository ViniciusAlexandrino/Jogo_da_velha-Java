import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	
	// Objetos e variáveis globais para a interface do jogo
	Random random = new Random();// Para determinar quem começa o jogo
	JFrame frame = new JFrame();// A janela principal do jogo
	JPanel title_panel = new JPanel();// Painel para o título do jogo
	JPanel button_panel = new JPanel();// Painel para os botões do jogo da velha
	JLabel textfield = new JLabel();// Campo de texto para exibir mensagens de status
	JButton[] buttons = new JButton[9];// Os botões para cada posição do jogo da velha
	boolean player1_turn;// Os botões para cada posição do jogo da velha

	TicTacToe() {
		
        // Configuração da janela principal
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free", Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Jogo da Velha");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		// Configuração dos botões do jogo da velha
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		// Adiciona o campo de texto e o painel de botões à janela principal
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	 public void actionPerformed(ActionEvent e) {
		 
		 for(int i=0;i<9;i++) {
			 if(e.getSource()==buttons[i]) {
				 if(player1_turn) {
					 if(buttons[i].getText()=="") {
						 buttons[i].setForeground(new Color(255,0,0));
						 buttons[i].setText("X");
						 player1_turn=false;// Passa a vez para o jogador 2
						 textfield.setText("Vez do O");
						 check();// Checa se há um vencedor
					 }
				 }
				 else {// Se é a vez do jogador 2
					 if(buttons[i].getText()=="") {
						 buttons[i].setForeground(new Color(0,0,255));
						 buttons[i].setText("O");
						 player1_turn=true;
						 textfield.setText("Vez do X");
						 check();// Checa se há um vencedor
				 }
			 }
		 }
			 
		 }
	 }
	
	 public void firstTurn() {
		// Define aleatoriamente quem começa o jogo
		 try {
			Thread.sleep(2000);// Atraso de 2 segundos para suspense
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// Captura exceções de interrupção
		}
		 
		 if(random.nextInt(2)==0) {
			 player1_turn=true;
			 textfield.setText("Vez do X");// Atualiza o texto para indicar a vez do X
		 }
		 else {
			 player1_turn=false;
			 textfield.setText("Vez do O");// Atualiza o texto para indicar a vez do O
		 }
	 }
	 
	 public void check() {
		 //Checar as condições de vitoria do X
		 if((buttons[0].getText()=="X") &&
			(buttons[1].getText()=="X") &&
			(buttons[2].getText()=="X")
			){
			 xWins(0,1,2);
		 }
		 if((buttons[3].getText()=="X") &&
			(buttons[4].getText()=="X") &&
			(buttons[5].getText()=="X")
			){
			 xWins(3,4,5);
				 }
		 if((buttons[6].getText()=="X") &&
			(buttons[7].getText()=="X") &&
			(buttons[8].getText()=="X")
			){
			 xWins(6,7,8);
			}
		 if((buttons[0].getText()=="X") &&
			(buttons[3].getText()=="X") &&
			(buttons[6].getText()=="X")
			){
			 xWins(0,3,6);
			 }
		 if((buttons[1].getText()=="X") &&
			(buttons[4].getText()=="X") &&
			(buttons[7].getText()=="X")
			){
			 xWins(1,4,7);
			}
		 if((buttons[2].getText()=="X") &&
			(buttons[5].getText()=="X") &&
			(buttons[8].getText()=="X")
			){
			 xWins(2,5,8);
			 }
		 if((buttons[0].getText()=="X") &&
			(buttons[4].getText()=="X") &&
			(buttons[8].getText()=="X")
			){
			 xWins(0,4,8);
			}
		 if((buttons[2].getText()=="X") &&
			(buttons[4].getText()=="X") &&
			(buttons[6].getText()=="X")
			){
			 xWins(2,4,6);
			 }
		 //Checar as condições de vitoria do O
		 
		 if((buttons[0].getText()=="O") &&
			(buttons[1].getText()=="O") &&
			(buttons[2].getText()=="O")
			){
			 oWins(0,1,2);
			 }
		 if((buttons[3].getText()=="O") &&
			(buttons[4].getText()=="O") &&
			(buttons[5].getText()=="O")
			){
     		 oWins(3,4,5);
			  }
		 if((buttons[6].getText()=="O") &&
			(buttons[7].getText()=="O") &&
			(buttons[8].getText()=="O")
			){
			 oWins(6,7,8);
			}
		if((buttons[0].getText()=="O") &&
		   (buttons[3].getText()=="O") &&
		   (buttons[6].getText()=="O")
			){
		     oWins(0,3,6);
			 }
			if((buttons[1].getText()=="O") &&
			   (buttons[4].getText()=="O") &&
			   (buttons[7].getText()=="O")
			   ){
			   oWins(1,4,7);
				}
			if((buttons[2].getText()=="O") &&
			   (buttons[5].getText()=="O") &&
			   (buttons[8].getText()=="O")
			   ){
			   oWins(2,5,8);
			    }
			if((buttons[0].getText()=="O") &&
			   (buttons[4].getText()=="O") &&
			   (buttons[8].getText()=="O")
			   ){
			    oWins(0,4,8);
				}
			 if((buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				){
				 oWins(2,4,6);
				 }
	 }
	 
	 public void xWins(int a,int b,int c) {
		 buttons[a].setBackground(Color.GREEN);// Muda a cor dos botões vencedores
		 buttons[b].setBackground(Color.GREEN);
		 buttons[c].setBackground(Color.GREEN);
		 
		 for(int i=0;i<9;i++) {
			 buttons[i].setEnabled(false); // Desabilita todos os botões após a vitória
		 }
		 textfield.setText("X Venceu");// Exibe mensagem de vitória para X
	 }
	 
	 public void oWins(int a,int b,int c) {
		 buttons[a].setBackground(Color.GREEN); // Muda a cor dos botões vencedores
		 buttons[b].setBackground(Color.GREEN);
		 buttons[c].setBackground(Color.GREEN);
		 
		 for(int i=0;i<9;i++) {
			 buttons[i].setEnabled(false); // Desabilita todos os botões após a vitória
		 }
		 textfield.setText("O Venceu"); // Exibe mensagem de vitória para O
	 }
}
