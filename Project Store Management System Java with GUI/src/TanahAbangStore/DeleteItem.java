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

public class DeleteItem {
	
	public DeleteItem(ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Delete item");
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
		
		JLabel l_index = Main.label("Item index:");
		JTextField index = Main.textField();
		panel.add(l_index);
		panel.add(index);
		
		JButton cancel = Main.button("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(cancel);
		
		JButton delete = Main.button("Delete");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = index.getText().toString();
				try {
					Integer.parseInt(id);
				} catch (Exception w) {
					JOptionPane.showMessageDialog(null, "Index must be integer");
					return;
				}
				int ind = Integer.parseInt(id);
				if (menu.size()>ind) {
					menu.remove(ind);
					JOptionPane.showMessageDialog(null, "Item deleted successfully");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Item doesn't exist");
					frame.dispose();
				}
			}
		});
		panel.add(delete);
		
		panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}

}
