package com.kyle.netChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPassword;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("SquadChat Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(273, 268);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(60, 29, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(60, 87, 93, 15);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(57, 56, 161, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER && !(txtName.getText().equals(""))){
						txtPassword.requestFocus();
				}
				
			}
			
		}); //changes the input focus to the password field if enter is pressed
		
		txtPassword = new JTextField();
		txtPassword.setBounds(60, 114, 161, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER && !(txtPassword.getText().equals(""))){
					login(txtName.getText(), txtPassword.getText());	
				}
				
			}
			
		}); //Key listener to log in if enter is pressed
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.setBounds(97, 167, 93, 25);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = txtName.getText();
				String pass = txtPassword.getText();
				login(name, pass);
				
			}
		}); //alternate button login
	}
	
	private void login(String name, String pass){
		dispose();
		new Client(name);
	}
}
