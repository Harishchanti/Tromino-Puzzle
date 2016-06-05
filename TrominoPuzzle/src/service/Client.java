package service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame, pass, controllingFrame, pass5;
	static JTextField tname, tno, board, dest, trname, trno, name, age,
			trname1, trno1;
	static JButton TOKK;
	static JTextField n, i, j;
	static TrominoUI o;
	static int[][] a = new int[10][10];
	static int x1;
	@SuppressWarnings("rawtypes")
	static JComboBox f;

	public static void main(String[] arg) {

		JPanel top, content;
		top = new JPanel();// Create the main Panel
		top.setLayout(null);

		content = new JPanel(null);// Create a Panel for Buttons
		content.setSize(500, 250);
		content.setBackground(Color.GRAY);
		content.setLayout(null);
		top.add(content);

		JLabel heading = new JLabel(" TROMINO PUZZLE ");
		heading.setFont(new Font("BOLD", Font.BOLD, 25));
		heading.setLocation(120, 10);
		heading.setSize(250, 100);
		content.add(heading);

		JButton Admin = new JButton(" START ");
		Admin.setLocation(175, 100);
		Admin.setSize(100, 50);
		content.add(Admin);
		Admin.addActionListener(new AdminSelect());

		frame = new JFrame("TROMINO PUZZLE");
		frame.add(top);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 280);
		frame.setVisible(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
				/ 2 - frame.getSize().height / 2);

	}

	static class AdminSelect implements ActionListener {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void actionPerformed(ActionEvent e) {

			frame.setVisible(false);

			pass5 = new JFrame(" DETAILS ");
			// pass5.setVisible(false);
			pass5.dispose();
			JPanel p5 = new JPanel(null);

			pass5.setSize(500, 250);

			// pass5.setVisible(true);
			// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			// pass5.setLocation(dim.width/2-pass5.getSize().width/2,
			// dim.height/2-pass5.getSize().height/2);
			JLabel f2 = new JLabel("Plese Enter Valid Input");
			// f2.add(f5);
			f2.setFont(new Font("BOLD", Font.BOLD, 25));
			f2.setLocation(120, 10);
			f2.setSize(250, 100);
			p5.add(f2);

			JButton Admin5 = new JButton(" OK ");
			Admin5.setLocation(175, 100);
			Admin5.setSize(100, 50);
			p5.add(Admin5);
			pass5.add(p5);
			Admin5.addActionListener(new AdminSelect());

			pass = new JFrame(" DETAILS ");
			pass.setSize(500, 500);
			pass.setVisible(true);

			JPanel d = new JPanel(null);
			d.setSize(500, 500);
			d.setLayout(null);
			d.setBackground(Color.GRAY);

			f = new JComboBox();
			f.addItem("1");
			f.addItem("2");
			f.addItem("3");
			f.setLocation(185, 80);
			f.setSize(150, 20);

			i = new JTextField(10);
			i.setSize(150, 20);
			i.setLocation(185, 140);

			j = new JTextField(10);
			j.setSize(150, 20);
			j.setLocation(185, 170);

			d.add(f);
			d.add(i);
			d.add(j);

			JLabel theading = new JLabel("Please Enter the Following details");
			theading.setFont(new Font("BOLD", Font.BOLD, 15));
			theading.setLocation(20, 20);
			theading.setSize(250, 50);
			d.add(theading);

			JLabel t1 = new JLabel("Select value for n((2^n)*(2^n))");
			t1.setLocation(20, 65);
			t1.setSize(250, 50);
			d.add(t1);

			JLabel theading1 = new JLabel(
					"Enter Co-ordinates of the Empty Block");
			theading1.setFont(new Font("BOLD", Font.BOLD, 15));
			theading1.setLocation(20, 95);
			theading1.setSize(280, 50);
			d.add(theading1);

			JLabel t2 = new JLabel("Enter value for i ");
			t2.setLocation(20, 125);
			t2.setSize(150, 50);
			d.add(t2);

			JLabel t3 = new JLabel("Enter value for j");
			t3.setLocation(20, 155);
			t3.setSize(150, 50);
			d.add(t3);

			JButton select = new JButton("ENTER");
			select.setLocation(180, 250);
			select.setSize(100, 50);
			d.add(select);
			select.addActionListener(new Correct());

			JButton select3 = new JButton("Next");
			select3.setLocation(180, 350);
			select3.setSize(100, 50);
			select3.addActionListener(new Right());
			d.add(select3);

			pass.add(d);
			pass.setVisible(true);

		}
	}

	static class Correct implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int h, n1, i1, j1;

			/*
			 * pass5=new JFrame(" DETAILS "); pass5.setSize(500,250);
			 * //pass5.setVisible(true); //Dimension dim =
			 * Toolkit.getDefaultToolkit().getScreenSize();
			 * //pass5.setLocation(dim.width/2-pass5.getSize().width/2,
			 * dim.height/2-pass5.getSize().height/2); JLabel f2=new
			 * JLabel("Plese Enter Valid Input"); //f2.add(f5); f2.setFont(new
			 * Font("BOLD",Font.BOLD, 25)); f2.setLocation(120,10);
			 * f2.setSize(250,100); pass5.add(f2);
			 * 
			 * JButton Admin5=new JButton(" OK "); Admin5.setLocation(175,100);
			 * Admin5.setSize(100,50); pass5.add(Admin5);
			 * Admin5.addActionListener(new AdminSelect2());
			 */
			int flg = 0, flg2 = 0;
			char k = '\0';
			n1 = 0;
			j1 = 0;
			i1 = 0;
			String s = i.getText();
			String s1 = j.getText();
			int i8;

			for (i8 = 0; i8 < s.length(); i8++) {
				k = s.charAt(i8);
				if (k == 'a' || k == 'z') {
					flg2 = 1;
				}
			}
			for (i8 = 0; i8 < s1.length(); i8++) {
				k = s1.charAt(i8);
				if (k == 'a' || k == 'z') {
					flg2 = 1;
				}
			}

			if (flg2 == 0) {
				i1 = Integer.parseInt(i.getText());
				String r = (String) f.getSelectedItem();
				n1 = Integer.parseInt(r);
				j1 = Integer.parseInt(j.getText());
			}

			// pass5.setVisible(false);
			if (n1 == 1) {
				if (i1 < 0 || i1 > 1 || j1 < 0 || j1 > 1 || flg2 == 1) {
					// JOptionPane.showMessageDialog(controllingFrame,"Please Enter Valid Input");
					pass5.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					pass5.setLocation(
							dim.width / 2 - pass5.getSize().width / 2,
							dim.height / 2 - pass5.getSize().height / 2);
					flg = 1;
				}
			} else if (n1 == 2) {
				if (i1 < 0 || i1 > 3 || j1 < 0 || j1 > 3 || flg2 == 1) {
					pass5.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					pass5.setLocation(
							dim.width / 2 - pass5.getSize().width / 2,
							dim.height / 2 - pass5.getSize().height / 2);
					flg = 1;
					// JOptionPane.showMessageDialog(controllingFrame,"Please Enter Valid Input");
				}
			} else if (n1 == 3) {
				if (i1 < 0 || i1 > 7 || j1 < 0 || j1 > 7 || flg2 == 1) {
					pass5.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					pass5.setLocation(
							dim.width / 2 - pass5.getSize().width / 2,
							dim.height / 2 - pass5.getSize().height / 2);
					flg = 1;
					// JOptionPane.showMessageDialog(controllingFrame,"Please Enter Valid Input");
				}
			}

			if (flg == 0) {
				x1 = (int) Math.pow(2, n1);
				h = n1 - 3;
				TrominoLogic t = new TrominoLogic(h);

				for (int i2 = 0; i2 < x1; i2++) {
					for (int j2 = 0; j2 < x1; j2++) {
						a[i2][j2] = 0;
					}
				}

				a[i1][j1] = 10000;

				t.trominoLogic(1, a, n1);

				a[i1][j1] = 0;

				t.display(a, x1);

				JFrame frame5 = new JFrame();
				JPanel p = new JPanel();
				p.setSize(500, 500);
				frame5.setSize(500, 500);
				frame5.setTitle(" Tromino ");
				frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JButton next = new JButton("Solve");
				next.setSize(100, 100);
				next.setLocation(50, 50);
				o = new TrominoUI(a, x1);

				p.add(o);
				frame5.add(p);
				p.setBackground(Color.GRAY);
				frame5.setVisible(true);

				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame5.setLocation(dim.width / 2 - frame5.getSize().width / 2,
						dim.height / 2 - frame5.getSize().height / 2);
			}

		}
	}

	/*
	 * static class AdminSelect2 implements ActionListener { public void
	 * actionPerformed(ActionEvent e) { pass5.dispose(); pass.dispose();
	 * pass.setVisible(true); } }
	 */

	static class Right implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame frame6 = new JFrame();
			frame6.setSize(500, 500);
			frame6.setTitle(" Tromino ");
			frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel p1 = new JPanel();
			p1.setBackground(Color.GRAY);
			GUI s = new GUI(a, x1);
			p1.add(s);
			frame6.add(p1);
			frame6.setVisible(true);

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame6.setLocation(dim.width / 2 - frame6.getSize().width / 2,
					dim.height / 2 - frame6.getSize().height / 2);

		}
	}
}
