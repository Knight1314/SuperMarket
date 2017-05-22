package com.knight.start;

import java.awt.EventQueue;

import com.knight.ui.Login;

public class Client {
	public static void main(String[] args) {
		// UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
