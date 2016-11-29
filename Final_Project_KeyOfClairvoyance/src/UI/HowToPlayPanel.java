package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Render.Resource;
import Render.Resource2;
import Render.Resource6;

@SuppressWarnings("serial")
public class HowToPlayPanel extends JPanel {

	static boolean draw;
	static int index = 0;

	public HowToPlayPanel() {
		draw = true;
		setBackground(new Color(200, 200, 200, 100));
		setLayout(null);
		JLabel d = new JLabel(new ImageIcon(Resource6.bg));
		d.setSize(d.getPreferredSize());
		d.setLocation(25, 40);

		JLabel htp = new JLabel(new ImageIcon(Resource6.htp1));
		htp.setSize(htp.getPreferredSize());
		htp.setLocation(25, 150);

		JLabel p = new JLabel(new ImageIcon(Resource.nullimage));
		p.setSize(p.getPreferredSize());
		p.setLocation(45, 550);

		JLabel n = new JLabel(new ImageIcon(Resource6.img4));
		n.setSize(n.getPreferredSize());
		n.setLocation(835, 550);

		p.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
			}

			public void mouseExited(MouseEvent e2) {
			}

			public void mouseClicked(MouseEvent e2) {
				if (index == 0)
					return;
				if (index == Resource6.im.length - 1) {
					n.setIcon(new ImageIcon(Resource6.img4));
				}
				if (index == 1) {
					p.setIcon(new ImageIcon(Resource.nullimage));
				}
				index--;
				htp.setIcon(new ImageIcon(Resource6.im[index]));
				Resource6.clip2.play();
				repaint();
				draw = false;
			}

		});

		n.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
			}

			public void mouseExited(MouseEvent e2) {
			}

			public void mouseClicked(MouseEvent e2) {
				if (index == Resource6.im.length - 1)
					return;
				if (index == Resource6.im.length - 2) {
					n.setIcon(new ImageIcon(Resource.nullimage));
				}
				index++;
				p.setIcon(new ImageIcon(Resource6.img3));
				htp.setIcon(new ImageIcon(Resource6.im[index]));
				Resource6.clip2.play();
				repaint();
				draw = false;
			}

		});

		JLabel e = new JLabel(new ImageIcon(Resource2.img));
		e.setSize(e.getPreferredSize());
		e.setLocation(880, 20);
		e.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				e.setIcon(new ImageIcon(Resource2.img2));
				Resource.exit.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				e.setIcon(new ImageIcon(Resource2.img));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				ControlPanel.controlcards.first(ControlPanel.controlPanel);
			}

		});

		add(e);
		add(n);
		add(p);
		add(htp);
		add(d);
	}

	public void paintComponent(Graphics g) {
		if (draw) {
			g.setColor(this.getBackground());
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}

}
