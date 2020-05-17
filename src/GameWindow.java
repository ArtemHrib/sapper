

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Map map = new Map();
	But but[][] = new But[16][16];
	int mass[][] = map.getMass();
	static int statusMass[][] = new int[16][16];
	public void startGame() {
		frame.setSize(538, 660);
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		
		repaint(panel,statusMass,mass,but, frame);
		
		frame.setVisible(true);
		frame.setContentPane(panel);
	}
	
	static void repaint(JPanel panel,int statusMass[][],int mass[][],But butt[][],JFrame frame) {
	panel.removeAll();
	JButton button = new JButton(new ImageIcon("menuBut.png"));
	button.setSize(183, 61);
	button.setLocation(180,25);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int bool = JOptionPane.showConfirmDialog(null, "Do you want to restart game?","Restart Game?",JOptionPane.OK_CANCEL_OPTION);
			if(bool==0) {
				frame.dispose();
				GameWindow wind = new GameWindow();
				for(int i = 0;i<16;i++) {
					for(int j = 0;j<16;j++) {
						GameWindow.statusMass[i][j]=0;
					}
				}
				wind.startGame();
			}
			
		}
	});
	panel.add(button);
		for(int i = 0;i<16;i++) {
			for(int j = 0;j<16;j++) {
				butt[i][j] = new But(statusMass[i][j],panel,mass,butt,frame);
			}
		}
		for(int i = 0,l=100;i<16;i++,l+=32) {
			for(int j = 0,k=10;j<16;j++,k+=32) {
				panel.add(butt[i][j].getBut(k, l, mass[i][j],i,j));
			}
		}
	
	}
	static void clearSpace(int i,int j,int mass[][],int k) {
		if(i>-1&&j>-1&&i<16&&j<16&&mass[i][j]==0&&k<200) {
			if(i>-1&&j>-1&&i<16&&j<16&&i-1>-1&&statusMass[i-1][j]==0) {
				statusMass[i-1][j]=1;
				clearSpace(i-1,j,mass,k+1);
			}
			if(i>-1&&j>-1&&i<16&&j<16&&i+1<16&&statusMass[i+1][j]==0) {
				statusMass[i+1][j]=1;
				clearSpace(i+1,j,mass,k+1);
			}
			if(i>-1&&j>-1&&i<16&&j<16&&j-1>-1&&statusMass[i][j-1]==0) {
				statusMass[i][j-1]=1;
				clearSpace(i,j-1,mass,k+1);
			}
			if(i>-1&&j>-1&&i<16&&j<16&&j+1<16&&statusMass[i][j+1]==0) {
				statusMass[i][j+1]=1;
				clearSpace(i,j+1,mass,k+1);
			}
		}
	}
}
