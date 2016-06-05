package service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class TrominoUI extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int a[][] = new int[500][500];
	static Rectangle box[][] = new Rectangle[500][500];
	static int count = 1;
	static int d;
	static Graphics2D g1;

	@SuppressWarnings("static-access")
	public TrominoUI(int a[][], int x) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				this.a[i][j] = a[i][j];
			}
		}
		d = x;
		setPreferredSize(new Dimension(500, 500));// Inserting 2D components
													// into a Panel

	}

	public void paintComponent(Graphics g) {
		g1 = (Graphics2D) g;
		int k = 0, h = 0;

		for (int i = 0, x = 120; i < d; i++, x = x + 30, k++) {
			h = 0;
			for (int j = 0, y = 120; j < d; j++, y = y + 30) {

				box[k][h] = new Rectangle(x, y, 30, 30);
				g1.draw(box[k][h]);
				h++;
			}
		}

		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (a[i][j] == 0) {
					g1.setColor(Color.BLACK);
					g1.fill(box[j][i]);
				}
			}
		}

	}
}

class GUI extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int a[][] = new int[500][500];
	static Rectangle box[][] = new Rectangle[500][500];
	static int count = 2;
	static int d;
	static Graphics2D g1;

	@SuppressWarnings("static-access")
	public GUI(int a[][], int x) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				this.a[i][j] = a[i][j];
			}
		}
		d = x;
		setPreferredSize(new Dimension(500, 500));
	}

	public void paintComponent(Graphics g) {
		g1 = (Graphics2D) g;
		int k = 0, h = 0;

		for (int i = 0, x = 120; i < d; i++, x = x + 30, k++) {
			h = 0;
			for (int j = 0, y = 120; j < d; j++, y = y + 30) {

				box[k][h] = new Rectangle(x, y, 30, 30);
				g1.draw(box[k][h]);
				h++;
			}
		}

		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (a[i][j] == 0) {
					g1.setColor(Color.BLACK);
					g1.fill(box[j][i]);
				}
			}
		}
		int g5 = 1;
		for (int z = 0; z < count - 1; z++) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (a[i][j] == g5) {

						if (g5 % 5 == 0) {
							g1.setColor(Color.CYAN);
							g1.fill(box[j][i]);
						}
						if (g5 % 5 == 1) {
							g1.setColor(Color.RED);
							g1.fill(box[j][i]);
						}
						if (g5 % 5 == 2) {
							g1.setColor(Color.YELLOW);
							g1.fill(box[j][i]);
						}

						if (g5 % 5 == 3) {
							g1.setColor(Color.GREEN);
							g1.fill(box[j][i]);
						}
						if (g5 % 5 == 4) {
							g1.setColor(Color.MAGENTA);
							g1.fill(box[j][i]);
						}
					}
				}
			}
			g5++;
		}
		count++;
	}
}
