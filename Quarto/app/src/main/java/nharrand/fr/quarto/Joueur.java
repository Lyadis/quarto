package nharrand.fr.quarto;

import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nharrand on 28/03/17.
 */

public class Joueur {
    boolean estNoir;
    Piece main[];

    public Joueur(boolean estNoir) {
        this.estNoir = estNoir;
        main = new Piece[8];

        main[0] = new Piece(estNoir, true, true, true);
        main[1] = new Piece(estNoir, true, true, false);
        main[2] = new Piece(estNoir, true, false, true);
        main[3] = new Piece(estNoir, true, false, false);

        main[4] = new Piece(estNoir, false, true, true);
        main[5] = new Piece(estNoir, false, true, false);
        main[6] = new Piece(estNoir, false, false, true);
        main[7] = new Piece(estNoir, false, false, false);
    }

    public Piece getPiece(int x) {
        return (x < 8) ? main[x] : null;
    }

    public void play(int i) {
        main[i] = null;
    }

    public void drawMain(ImageButton mainButton[], boolean clickable) {
        for(int i = 0; i < 8; i++) {
            if(main[i] != null) {
                mainButton[i].setImageResource(main[i].getImage());
                mainButton[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
                mainButton[i].setClickable(clickable);
            } else {
                mainButton[i].setImageResource(Plateau.empty);

                mainButton[i].setClickable(false);
            }
        }
    }
}
