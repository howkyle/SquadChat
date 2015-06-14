package com.kyle.netChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtMessage;
	private JButton btnSend;

	/**
	 * Create the frame.
	 */
	public Client() {
		createWindow();
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
		gbl_contentPane.rowHeights = new int[]{50,400,50};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTextArea txtrMesshist = new JTextArea();
		txtrMesshist.setEditable(false);
		GridBagConstraints gbc_txtrMesshist = new GridBagConstraints();
		gbc_txtrMesshist.insets = new Insets(0, 5, 5, 5);
		gbc_txtrMesshist.fill = GridBagConstraints.BOTH;
		gbc_txtrMesshist.gridx = 1;
		gbc_txtrMesshist.gridy = 1;
		gbc_txtrMesshist.gridwidth = 2;
		contentPane.add(txtrMesshist, gbc_txtrMesshist);
		
		txtMessage = new JTextField();
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.insets = new Insets(0, 15, 0, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 1;
		gbc_txtMessage.gridy = 2;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);
		
		btnSend = new JButton("send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
	}

}
