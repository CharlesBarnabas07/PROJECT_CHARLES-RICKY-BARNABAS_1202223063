package TanahAbangStore;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Login {
	
	public Login(ArrayList<Account> accounts, ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Login");
		try {
			System.setProperty("sun.awt.noerasebackground", "true");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {e.printStackTrace();}
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 20, 20));
		
		JLabel l_phone = Main.label("Phone number:");
		JTextField phone = Main.textField();
		panel.add(l_phone);
		panel.add(phone);
		
		JLabel l_email = Main.label("Email:");
		JTextField email = Main.textField();
		panel.add(l_email);
		panel.add(email);
		
		JLabel l_password = Main.label("Password:");
		JTextField password = Main.textField();
		panel.add(l_password);
		panel.add(password);
		
		JButton newacc = Main.button("Create new account");
		newacc.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewAcc(accounts, menu);
				frame.dispose();
			}
		});
		panel.add(newacc);
		
		JButton Login = Main.button("Login");
		Login.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String pn = phone.getText().toString();
				String em = email.getText().toString();
				String pass = password.getText().toString();
				
				try {
					Long.parseLong(pn);
				} catch (Exception w) {
					JOptionPane.showMessageDialog(null, "Phone number must be integers");
					return;
				}
				if (em.equals("")) {
					JOptionPane.showMessageDialog(null, "Email cannot be empty");
					return;
				}
				if (pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Password cannot be empty");
					return;
				}
				
				Account acc = new Guest();
				for (Account a : accounts) {
					if (a.getPhonenumber() == Long.parseLong(pn) && 
							a.getEmail().equals(em) && a.getPassword().equals(pass)) {
						acc = a;
						break;
					}
				}
				if (acc.getName() != null) {
					acc.menu(accounts, menu);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Acount doesn't exist!");
				}
			}
		});
		panel.add(Login);
		
		panel.setBorder(BorderFactory.createEmptyBorder(140, 100, 140, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
