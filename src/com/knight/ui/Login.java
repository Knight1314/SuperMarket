package com.knight.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.knight.beans.User;
import com.knight.serviceImp.LoginImp;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Login window = new Login();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 450);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel pic = new JPanel();
		pic.setBackground(Color.CYAN);
		pic.setBounds(0, 0, 600, 200);
		frame.getContentPane().add(pic);

		JPanel pic2 = new JPanel();
		pic2.setBackground(Color.CYAN);
		pic2.setBounds(132, 258, 87, 89);
		frame.getContentPane().add(pic2);

		tfUsername = new JTextField();
		tfUsername.setBounds(231, 262, 180, 32);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		JLabel lbUsername = new JLabel("用户名");
		lbUsername.setBounds(415, 266, 69, 24);
		frame.getContentPane().add(lbUsername);

		JLabel lbPassword = new JLabel("密    码");
		lbPassword.setBounds(415, 323, 69, 24);
		frame.getContentPane().add(lbPassword);

		JButton btLogin = new JButton("登录");
		btLogin.setForeground(Color.BLACK);
		btLogin.setBackground(Color.CYAN);
		btLogin.setBounds(231, 365, 180, 42);
		btLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUserName(tfUsername.getText());
				user.setPassword(new String(tfPassword.getPassword()));
				System.out.println(user);
				if (new LoginImp().checkLogin(user)) {
					System.out.println("success");
					// TODO
				} else {
					System.out.println("failed");
					// TODO
				}
			}
		});
		frame.getContentPane().add(btLogin);

		tfPassword = new JPasswordField();
		tfPassword.setBounds(231, 319, 180, 32);
		frame.getContentPane().add(tfPassword);
	}

}
