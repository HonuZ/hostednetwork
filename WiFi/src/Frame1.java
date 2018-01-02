import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.Box;

public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 331, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStartHostedNetwork = new JButton("Start Hosted Network");
		btnStartHostedNetwork.setContentAreaFilled(false);
		btnStartHostedNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
	                Main.main(new String[0]);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
				JOptionPane.showMessageDialog(null, "The network has been started");
			}
			
		});
		frame.getContentPane().add(btnStartHostedNetwork, BorderLayout.EAST);
		
		JButton btnStop = new JButton("Stop Hosted Network");
		btnStop.setContentAreaFilled(false);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
	                Stop.main(new String[0]);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
				JOptionPane.showMessageDialog(null, "The network has been stopped");
		}});
		frame.getContentPane().add(btnStop, BorderLayout.WEST);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
