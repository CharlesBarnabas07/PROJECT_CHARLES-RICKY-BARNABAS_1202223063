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

public class EditItem {

	public EditItem(ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Edit item");
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 20, 20));
		
		JLabel l_index = Main.label("Item index:");
		JTextField index = Main.textField();
		panel.add(l_index);
		panel.add(index);
		
		JLabel l_name = Main.label("Name:");
		JTextField name = Main.textField();
		panel.add(l_name);
		panel.add(name);
		
		JLabel l_price = Main.label("Price:");
		JTextField price = Main.textField();
		panel.add(l_price);
		panel.add(price);
		
		JButton cancel = Main.button("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(cancel);
		
		JButton edit = Main.button("Edit");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = index.getText().toString();
				String ne = name.getText().toString();
				String pe = price.getText().toString();
				try {
					Integer.parseInt(id);
				} catch (Exception w) {
					JOptionPane.showMessageDialog(null, "Index must be integer");
					return;
				}
				if (ne.equals("")) {
					JOptionPane.showMessageDialog(null, "Name cannot be empty");
					return;
				}
				try {
					Double.parseDouble(pe);
				} catch (Exception w) {
					JOptionPane.showMessageDialog(null, "Price must be number");
					return;
				}
				menu.get(Integer.parseInt(id) - 1).setItemName(ne);
				menu.get(Integer.parseInt(id) - 1).setPrice(Double.parseDouble(pe));
				JOptionPane.showMessageDialog(null, "Item edited successfully");
				frame.dispose();
			}
		});
		panel.add(edit);
		
		panel.setBorder(BorderFactory.createEmptyBorder(140, 100, 140, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
}
