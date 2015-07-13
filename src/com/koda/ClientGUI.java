package com.koda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(22, 85, 72, 14);
		contentPane.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setBounds(104, 84, 146, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(22, 116, 72, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(104, 110, 146, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleClient client = new SimpleClient("192.168.1.93", 8000);
				client.sendLogin(usernameField.getText(), new String(passwordField.getPassword()));
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(44, 159, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignUp.setBounds(143, 159, 89, 23);
		contentPane.add(btnSignUp);
	}
}
