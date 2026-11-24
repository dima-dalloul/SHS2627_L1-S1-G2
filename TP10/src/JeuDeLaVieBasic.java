// Le jeu de la vie (Conway)
import java.awt.Color;

public class JeuDeLaVieBasic {

	final static int GSIZE = 16; // taille de la grille

	public static void initializeGrid(boolean[][] grille) {
		// initialisation de la grille
		for (int i = 0; i < GSIZE; i++) {
			for (int j = 0; j < GSIZE; j++) {
				grille[i][j] = false;
			}
		}

		// Initialisation du planeur / glider
		grille[3][1] = true;
		grille[4][2] = true;
		grille[2][3] = true;
		grille[3][3] = true;
		grille[4][3] = true;
	}

	public static void drawGrid(boolean[][] grille, PixelScreen screen) {
		// affiche la grille
		for (int i = 0; i < GSIZE; i++) {
			for (int j = 0; j < GSIZE; j++) {
				if (grille[i][j])
					screen.updatePixel(i, j, Color.BLACK);
				else
					screen.updatePixel(i, j, Color.WHITE);
			}
		}
	}

	public static boolean[][] updateGrid(boolean[][] grille) {
		// calcule l'état suivant de la grille
		boolean[][] update = new boolean[GSIZE][GSIZE];
		for(int i = 0; i < grille.length; i++){
			for(int j = 0; j < grille[i].length; j++){
				// Règle 1 : Une case morte possédant exactement trois voisines vivantes
				//parmi les 8 devient vivante (elle naît), sinon elle reste morte.
				if(grille[i][j] == false && countAliveNeighbors(grille, i, j) == 3){
					update[i][j] = true;
				}

				// Règle 2 : Une case vivante possédant deux ou trois voisines vivantes le
				//reste, sinon elle meurt
				else if(grille[i][j] == true &&
						(
								(countAliveNeighbors(grille, i, j) == 2))
						||
						((countAliveNeighbors(grille, i, j) == 3))
				)
				{
					update[i][j] = true;
				} else {
					update[i][j] = false;
				}

			}
		}
		return(update);
	}

	public static void main(String[] args) {
		boolean[][] grille = new boolean[GSIZE][GSIZE];
		initializeGrid(grille);
		PixelScreen viewer = new PixelScreen(GSIZE, GSIZE,16);
		System.out.println(countAliveNeighbors(grille,2,2));
		while(true) {
			drawGrid(grille,viewer);
			viewer.refreshAfter(64);
			grille=updateGrid(grille);
		}
	}

	public static int countAliveNeighbors(boolean[][] grille, int positionI, int positionJ){
    	int totalVoisinsVivants = 0;
		// Case (i-1, j-1)
		if(positionI > 0 && positionJ > 0 && grille[positionI-1][positionJ-1] == true)
			totalVoisinsVivants++;

		// Case (i-1, j)
		if(positionI > 0 && grille[positionI-1][positionJ] == true)
			totalVoisinsVivants++;

		// Case (i-1, j+1)
		if(positionI > 0 && positionJ < (GSIZE - 1) && grille[positionI-1][positionJ+1] == true)
			totalVoisinsVivants++;

		// Case (i, j-1)
		if(positionJ > 0 && grille[positionI][positionJ-1] == true)
			totalVoisinsVivants++;

		// Case (i, j+1)
		if(positionJ < (GSIZE - 1) && grille[positionI][positionJ+1] == true)
			totalVoisinsVivants++;

		// Case (i+1, j-1)
		if(positionI < (GSIZE - 1) && positionJ > 0 && grille[positionI+1][positionJ-1] == true)
			totalVoisinsVivants++;

		// Case (i+1, j)
		if(positionI < (GSIZE - 1) && grille[positionI+1][positionJ] == true)
			totalVoisinsVivants++;

		// Case (i+1, j+1)
		if(positionI < (GSIZE - 1) && positionJ < (GSIZE - 1) && grille[positionI+1][positionJ+1] == true)
			totalVoisinsVivants++;

		return totalVoisinsVivants;
	}
}