package com.kyle.netChat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtMessage;
	private JButton btnSend;
	public JTextArea txtrMesshist;
	private String userName;
	private static NetClient netCli;
	

	/**
	 * Create the frame.
	 */
	public Client(String userName) {
		createWindow();
		this.userName = userName;
		netCli = new NetClient(userName);
		updateConsole(netCli.receiveMessage());

		txtMessage.requestFocus();
	}
	
	/**
	 * Updates the message history console with the new messages
	 * @param str
	 */
	public void updateConsole(String str){
		txtrMesshist.append(str+"\n");
	}
	
	private void createWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,400,100};
		gbl_contentPane.rowHeights = new int[]{10,440,50};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtrMesshist = new JTextArea();
		txtrMesshist.setEditable(false);
		txtrMesshist.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(txtrMesshist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setPreferredSize(new Dimension(400,440));
		GridBagConstraints scrollConstraints = new GridBagConstraints();
		scrollConstraints.insets = new Insets(5, 5, 0, 5);
		scrollConstraints.fill = GridBagConstraints.BOTH;
		scrollConstraints.gridx = 0;
		scrollConstraints.gridy = 0;
		scrollConstraints.gridwidth = 3;
		scrollConstraints.gridheight =2;
		contentPane.add(scroller, scrollConstraints);
		
		txtMessage = new JTextField();
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.insets = new Insets(0, 15, 0, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 0;
		gbc_txtMessage.gridy = 2;
		gbc_txtMessage.gridwidth = 2;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);
		txtMessage.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER && !(txtMessage.getText().equals(""))){
					netCli.sendMessage(txtMessage.getText());
					updateConsole(netCli.receiveMessage());
					txtMessage.setText("");			
				}
				
			}
			
		});
		
		btnSend = new JButton("send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
		btnSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource() == btnSend && !(txtMessage.getText().equals(""))){
					//updateConsole(NetClient.communicate(userName+": "+txtMessage.getText())); //should send message
					netCli.sendMessage(txtMessage.getText());
					updateConsole(netCli.receiveMessage());
					txtMessage.setText("");
				}
				
			}
		}); //adds an actionlistener
	}
	

}
