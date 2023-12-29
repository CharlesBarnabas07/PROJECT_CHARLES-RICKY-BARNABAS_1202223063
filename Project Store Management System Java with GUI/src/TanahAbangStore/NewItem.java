package TanahAbangStore;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewItem {
	
	String filepath = "Data/logo.png";
	
	public NewItem(ArrayList<Item> menu) {
		
		JFrame frame = new JFrame("Add new item");
		frame.getContentPane().setBackground(Main.foregroundColor);
		frame.setSize(700, 550);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 20, 20));
		
		JLabel l_name = Main.label("Name:");
		JTextField name = Main.textField();
		panel.add(l_name);
		panel.add(name);
		
		JLabel l_price = Main.label("Price:");
		JTextField price = Main.textField();
		panel.add(l_price);
		panel.add(price);
		
		JLabel pic = new JLabel();
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(pic);
		
		JButton pick = Main.button("Pick image");
		pick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ne = name.getText().toString();
				String pe = price.getText().toString();
				
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
				File dir = new File("Data/");
				if (!dir.exists()) dir.mkdir();
				pickFile("Data/" + ne, pic);
			}
		});
		panel.add(pick);
		
		JButton save = Main.button("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n = name.getText().toString();
				String p = price.getText().toString();
				Item m = new Item(n, Double.parseDouble(p), filepath);
				menu.add(m);
				JOptionPane.showMessageDialog(null, "Item added successfully");
				frame.dispose();
			}
		});
		panel.add(save);
		
		JButton cancel = Main.button("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(cancel);
		
		panel.setBorder(BorderFactory.createEmptyBorder(140, 100, 140, 100));
		panel.setBackground(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	private void pickFile(String filename, JLabel lb) {
		JFileChooser a = new JFileChooser();
		a.setFileSelectionMode(JFileChooser.FILES_ONLY);
		a.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
		a.setAcceptAllFileFilterUsed(true);
		int i = a.showOpenDialog(null);
		if (i==JFileChooser.APPROVE_OPTION) {
			File f = a.getSelectedFile();
			filepath = filename + getFileExtension(f);
			File dest = new File(filepath);
			if (f.getName().contains(".jpg") || f.getName().contains(".png")) {
				try {
					if (!dest.exists()) dest.createNewFile();
					Files.copy(f.toPath(), new FileOutputStream(dest));
					BufferedImage img = ImageIO.read(dest);
					Image dimg = img.getScaledInstance(lb.getHeight(),
											lb.getHeight(), Image.SCALE_AREA_AVERAGING);
					lb.setIcon(new ImageIcon(dimg));
				} catch (Exception r) {
					r.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, ".jpg or .png only");
			}
		}
	}

	private static String getFileExtension(File file) {
		String name = file.getName();
		int lastindexOf = name.lastIndexOf(".");
		if (lastindexOf==-1) {
			return "";
		}
		return name.substring(lastindexOf);
	}
	
}
