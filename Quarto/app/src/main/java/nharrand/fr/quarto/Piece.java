package nharrand.fr.quarto;

/**
 * Created by nharrand on 27/03/17.
 */

public class Piece {

    boolean estNoire;
    boolean estCarree;
    boolean estCerclee;
    boolean estCruciforme;
    int img;

    public boolean estNoire() {
        return estNoire;
    }

    public boolean estCarree() {
        return estCarree;
    }

    public boolean estCerclee() {
        return estCerclee;
    }

    public boolean estCruciforme() {
        return estCruciforme;
    }

    public int getImg() {
        return img;
    }



    public Piece(
            boolean estNoire,
            boolean estCarree,
            boolean estCerclee,
            boolean estCruciforme,
            int img) {

        this.estNoire = estNoire;
        this.estCarree = estCarree;
        this.estCerclee = estCerclee;
        this.estCruciforme = estCruciforme;
        this.img = img;

    }

    public static int image[][][][] = new int[2][2][2][2];

    public int getImage() {
        return image[estNoire ? 1 : 0][estCerclee ? 1 : 0][estCarree ? 1 : 0][estCruciforme ? 1 : 0];
    }
}
