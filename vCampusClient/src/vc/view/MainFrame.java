package vc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.srv.IClientUserSrv;
import vc.srv.impl.IClientUserSrvImpl;
import vc.vo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(30, 26, 54, 15);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(94, 23, 163, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(30, 72, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(96, 69, 161, 21);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		});
		btnNewButton.setBounds(108, 159, 93, 23);
		contentPane.add(btnNewButton);
	}

	
	protected  void doLogin() {
		String username = this.txtUserName.getText();
		if ( username.trim().isEmpty() ) {
			JOptionPane.showMessageDialog(this, "Cannot");
			return;
		}
		System.out.println("User name : " + username);
		String password = this.txtPassword.getText();
		System.out.println("Password : " + password);
		//
		IClientUserSrv icus = new IClientUserSrvImpl();
		//
		User user = icus.login(username, password);
		
		System.out.println(user);
	}
}
