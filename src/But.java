import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class But {
	JButton but = new JButton();
	JPanel panel = new JPanel();
	JFrame frame;
	int mass[][];
	int status = 0;
	But butt[][];
	public But(int status,JPanel panel,int mass[][],But butt[][],JFrame frame) {
		this.status = status;
		this.mass = mass;
		this.panel = panel;
		this.butt = butt;
		this.frame = frame;
	}
	JButton getBut(int x,int y,int stat,int I,int J) {
		but.setSize(32, 32);
		but.setLocation(x, y);
		but.setIcon(new ImageIcon("simplebut.png"));
		if(GameWindow.statusMass[I][J]==1) {
			switch(stat) {
			case 0:
				but.setIcon( new ImageIcon("clearbut.png"));
			break;
			case 10:
				but.setIcon( new ImageIcon("wrongbomb.png"));
			break;
			default:
				but.setIcon( new ImageIcon("butwithnum"+stat+".png"));
			break;	
			}
		}
		
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(stat) {
				case 0:
					GameWindow.statusMass[I][J]=1;
					GameWindow.clearSpace(I, J, mass, 0);
					but.setIcon( new ImageIcon("clearbut.png"));
					GameWindow.repaint(panel, GameWindow.statusMass, mass,butt,frame);
					panel.repaint();
				break;
				case 10:
					GameWindow.statusMass[I][J]=1;
					but.setIcon( new ImageIcon("wrongbomb.png"));
					JOptionPane.showMessageDialog(null, "Game over: You lose");
					frame.dispose();
					GameWindow wind = new GameWindow();
					for(int i = 0;i<16;i++) {
						for(int j = 0;j<16;j++) {
							GameWindow.statusMass[i][j]=0;
						}
					}
					wind.startGame();
				break;
				default:
					GameWindow.statusMass[I][J]=1;
					but.setIcon( new ImageIcon("butwithnum"+stat+".png"));
				break;	
				}
			}
		});
		return but;
	}
	
}
