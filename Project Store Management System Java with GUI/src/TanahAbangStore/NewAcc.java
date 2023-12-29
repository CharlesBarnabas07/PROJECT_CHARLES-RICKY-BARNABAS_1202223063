package TanahAbangStore;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewAcc {
	
	public NewAcc(ArrayList<Account> accounts, ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Create new account");
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 20, 20));
		
		JLabel l_name = Main.label("Name:");
		JTextField name = Main.textField();
		panel.add(l_name);
		panel.add(name);
		
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
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton admin = new JRadioButton("Admin");
		admin.setHorizontalAlignment(SwingConstants.CENTER);
		admin.setFont(new Font("Helvetica", Font.BOLD, 17));
		admin.setBackground(null);
		bg.add(admin);
		panel.add(admin);
		
		JRadioButton guest = new JRadioButton("Guest");
		guest.setHorizontalAlignment(SwingConstants.CENTER);
		guest.setFont(new Font("Helvetica", Font.BOLD, 17));
		guest.setBackground(null);
		bg.add(guest);
		panel.add(guest);
		
		JButton cancel = Main.button("Cancel");
		cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login(accounts, menu);
				frame.dispose();
			}
		});
		panel.add(cancel);
		
		JButton createacc = Main.button("Create account");
		createacc.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String ne = name.getText().toString();
				String pn = phone.getText().toString();
				String em = email.getText().toString();
				String pass = password.getText().toString();
				
				if (ne.equals("")) {
					JOptionPane.showMessageDialog(null, "Name cannot be empty");
					return;
				}
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
				if (!admin.isSelected() && !guest.isSelected()) {
					JOptionPane.showMessageDialog(null, "Account type must be selected");
					return;
				}
				
				Account account;
				if (admin.isSelected()) {
					account = new Admin();
				} else {
					account = new Guest();
				}
				account.setName(ne);
				account.setEmail(em);
				account.setPassword(pass);
				account.setPhonenumber(Long.parseLong(pn));
				accounts.add(account);
				account.menu(accounts, menu);
				frame.dispose();
			}
		});
		panel.add(createacc);
		
		panel.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
