package TanahAbangStore;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Guest extends Account {
	
	private ArrayList<Item> Cart;
	
	public Guest() {
		Cart = new ArrayList<>();
	}

	public Guest(String name, long phonenumber, String email, String password) {
		super(name, phonenumber, email, password);
		Cart = new ArrayList<>();
	}

	@Override
	void menu(ArrayList<Account> accounts, ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Store Management System");
		frame.getContentPane().setBackground(Main.backgroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(4, 5, 3, 3));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
		
		JLabel checkout = new JLabel("0 item added");
		checkout.setFont(new Font("Helvetica", Font.BOLD, 18));
		checkout.setHorizontalAlignment(SwingConstants.CENTER);
		checkout.setBackground(Main.foregroundColor);
		checkout.setOpaque(true);
		checkout.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		checkout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkout.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}	
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (Cart.size()!=0) {
					String msg = "";
					double sum = 0;
					for (Item i : Cart) {
						sum = sum + i.getPrice();
						msg = msg + i.getItemName() + " " + i.getPrice() + " $\n";
					}
					JOptionPane.showMessageDialog(null, msg);
					int d = JOptionPane.showConfirmDialog(null, "Are you sure that "
							+ "you want to buy these items?");
					if (d==JOptionPane.YES_OPTION) {
						Cart.clear();
						checkout.setText("0 item added");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cart is empty");
				}
			}
		});
		frame.add(checkout, BorderLayout.SOUTH);
		
		for (int i=0;i<menu.size();i++) {
			Item item = menu.get(i);
			JPanel p = new JPanel(new BorderLayout());
			p.setBackground(Main.foregroundColor);
			
			JLabel label = new JLabel();
			try {
				BufferedImage img = ImageIO.read(new File(item.getPic()));
				Image im = img.getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING);
				label.setIcon(new ImageIcon(im));
			} catch (Exception y) {y.printStackTrace();}
			p.add(label, BorderLayout.WEST);
			
			JPanel c = new JPanel(new GridLayout(3, 1, 2, 2));
			c.setBackground(null);
			c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			JLabel title = new JLabel(item.getItemName());
			title.setFont(new Font("Helvetica", Font.BOLD, 17));
			c.add(title);
			
			JLabel price = new JLabel(String.valueOf(item.getPrice()) + " $");
			price.setFont(new Font("Helvetica", Font.PLAIN, 14));
			c.add(price);
			
			JButton add = Main.button("Add");
			add.setFont(new Font("Helvetica", Font.BOLD, 13));
			add.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Cart.add(item);
					if (checkout.getText().toString().equals("0 item added")) {
						checkout.setText("1 item added. Click here to checkout");
					} else {
						checkout.setText(Cart.size() + " items added. Click here to checkout");
					}
				}
			});
			c.add(add);
			
			p.add(c, BorderLayout.CENTER);
			panel.add(p);
		}
		
		for (int i=0;i<12-menu.size();i++) {
			JPanel p = new JPanel();
			p.setBackground(Main.foregroundColor);
			panel.add(p);
		}
		frame.add(panel, BorderLayout.CENTER);
		
		JLabel title = new JLabel("Store Management System");
		title.setFont(new Font("Helvetica", Font.BOLD, 22));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(Main.foregroundColor);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		frame.add(title, BorderLayout.NORTH);
		frame.setVisible(true);
	}
	
}
