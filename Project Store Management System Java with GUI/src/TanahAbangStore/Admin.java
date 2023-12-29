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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Admin extends Account {
	
	public Admin() {
		
	}

	public Admin(String name, long phonenumber, String email, String password) {
		super(name, phonenumber, email, password);
	}

	@Override
	void menu(ArrayList<Account> accounts, ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Admin");
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(5, 1, 20, 20));
		
		JButton showmenu = Main.button("Show Menu");
		showmenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				if (menu.size()!=0) {
					for (Item m : menu) {
						int index = menu.indexOf(m) + 1;
						msg = msg + index + ". " + m.getItemName() +" "
															+ m.getPrice() + " $\n";
					}
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		JButton additem = Main.button("Add new item");
		additem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewItem(menu);
			}
		});
		JButton edititem = Main.button("Edit item");
		edititem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditItem(menu);
			}
		});
		JButton delitem = Main.button("Delete item");
		delitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteItem(menu);
			}
		});
		JButton exit = Main.button("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login(accounts, menu);
				frame.dispose();
			}
		});
		
		panel.add(showmenu);
		panel.add(additem);
		panel.add(edititem);
		panel.add(delitem);
		panel.add(exit);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}
