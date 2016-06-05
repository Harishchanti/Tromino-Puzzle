package service;

import javax.swing.JComponent;

public class TrominoLogic extends JComponent implements ITromono

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int h;
	static int fill = 1;

	public TrominoLogic(int h) {
		this.h = h;
	}

	public void display(int[][] a, int x) {
		int i, j;
		for (i = 0; i < x; i++) {
			System.out.println("\n");
			for (j = 0; j < x; j++) {
				System.out.print("\t" + a[i][j]);
			}
		}
	}

	public static int pow(int n, int x) {
		int i;
		int y = 1;
		for (i = 1; i <= x; i++)
			y = y * n;
		return y;
	}

	public void trominoLogic(int br, int[][] k, int n) {

		int i, j, x, flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, c, d;
		x = pow(2, n);
		int[][] b = new int[(x / 2)][(x / 2)];

		for (i = 0; i < (x / 2); i++)
			for (j = 0; j < (x / 2); j++) {
				if (k[i][j] != 0)
					flag1 = 1;
			}

		for (i = (x / 2); i < x; i++)
			for (j = 0; j < (x / 2); j++) {
				if (k[i][j] != 0)
					flag2 = 1;
			}

		for (i = 0; i < (x / 2); i++)
			for (j = (x / 2); j < x; j++) {
				if (k[i][j] != 0)
					flag3 = 1;
			}

		for (i = (x / 2); i < x; i++)
			for (j = (x / 2); j < x; j++) {
				if (k[i][j] != 0)
					flag4 = 1;
			}

		if (flag1 == 1) {
			k[(x / 2)][(x / 2)] = fill;
			k[((x / 2) - 1)][(x / 2)] = fill;
			k[(x / 2)][((x / 2) - 1)] = fill;
			fill++;
		}

		else if (flag2 == 1) {
			k[(x / 2)][(x / 2)] = fill;
			k[((x / 2) - 1)][(x / 2)] = fill;
			k[((x / 2) - 1)][((x / 2) - 1)] = fill;
			fill++;
		}

		else if (flag3 == 1) {
			k[(x / 2)][(x / 2)] = fill;
			k[(x / 2)][((x / 2) - 1)] = fill;
			k[((x / 2) - 1)][((x / 2) - 1)] = fill;
			fill++;
		}

		else {
			k[(x / 2)][((x / 2) - 1)] = fill;
			k[((x / 2) - 1)][(x / 2)] = fill;
			k[((x / 2) - 1)][((x / 2) - 1)] = fill;
			fill++;
		}

		if (br <= (n + h)) {
			for (i = 0; i < (x / 2); i++)
				for (j = 0; j < (x / 2); j++) {
					b[i][j] = k[i][j];
				}

			trominoLogic((br + 1), b, (n - 1));

			for (i = 0; i < (x / 2); i++)
				for (j = 0; j < (x / 2); j++) {
					k[i][j] = b[i][j];
				}

			for (c = 0, i = (x / 2); i < x && c < (x / 2); i++, c++)
				for (j = 0; j < (x / 2); j++)
					b[c][j] = k[i][j];

			trominoLogic((br + 1), b, (n - 1));

			for (c = 0, i = (x / 2); i < x && c < (x / 2); i++, c++)
				for (j = 0; j < (x / 2); j++)
					k[i][j] = b[c][j];

			for (i = 0; i < (x / 2); i++)
				for (d = 0, j = (x / 2); j < x && d < (x / 2); j++, d++)
					b[i][d] = k[i][j];

			trominoLogic((br + 1), b, (n - 1));

			for (i = 0; i < (x / 2); i++)
				for (d = 0, j = (x / 2); j < x && d < (x / 2); j++, d++)
					k[i][j] = b[i][d];

			for (c = 0, i = (x / 2); i < x && c < (x / 2); i++, c++)
				for (d = 0, j = (x / 2); j < x && d < (x / 2); j++, d++)
					b[c][d] = k[i][j];

			trominoLogic((br + 1), b, (n - 1));

			for (c = 0, i = (x / 2); i < x && c < (x / 2); i++, c++)
				for (d = 0, j = (x / 2); j < x && d < (x / 2); j++, d++)
					k[i][j] = b[c][d];

		}
	}
}