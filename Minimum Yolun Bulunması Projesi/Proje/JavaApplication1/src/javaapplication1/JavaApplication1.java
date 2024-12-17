package javaapplication1;
/**
 *
 * @author EMİRHAN
 */
public class JavaApplication1 {
public static int MinimumYolunBulunması(int[][] değer)
	{                  
   // M x N matrix
		int Maksimum = değer.length;
		int Minimum = değer[0].length;
		// T [i] [j], hücreye ulaşmak için minimum maliyeti korur (i, j)
                // hücreden (0, 0)
		int[][] T = new int[Maksimum][Minimum];               
		// matrisi aşağıdan yukarıya doldur
		for (int i = 0; i < Maksimum; i++)
		{
			for (int j = 0; j < Minimum; j++)
			{
				T[i][j] = değer[i][j];
                                // ilk satırı doldur (herhangi bir hücreye ulaşmanın yalnızca bir yolu vardır
                                // ilk satırda, yani bitişik sol hücresindendir)
				if (i == 0 && j > 0) {
					T[0][j] += T[0][j - 1];
				}
				// ilk sütunu doldur (herhangi bir hücreye ulaşmanın yalnızca bir yolu var
                                // ilk sütunda, yani bitişik üst hücresindendir)
				else if (j == 0 && i > 0) {
					T[i][0] += T[i - 1][0];
				}
				// ilk sütunu doldur (herhangi bir hücreye ulaşmanın yalnızca bir yolu var
                                // ilk sütunda, yani bitişik üst hücresindendir)
				else if (i > 0 && j > 0) {
					T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
				}
			}
		}
		return T[Maksimum - 1][Minimum - 1];}
    public static void main(String[] args) {
       int[][] matris =
		{
			{ 0, 7, 8, 0, 0 },
			{ 6, 0, 3, 9, 0 },
			{ 4, 0, 0, 2, 4 },
			{ 0, 1, 7, 0, 7 },
			{ 0, 0, 8, 9, 0 }
		};
		System.out.print(" En düşük maliyetli minimum yol: " + MinimumYolunBulunması(matris));
    }
    
}
