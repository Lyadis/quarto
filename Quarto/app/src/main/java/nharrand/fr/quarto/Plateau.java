package nharrand.fr.quarto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Plateau extends Activity {

    Piece p[][];
    ImageButton pieceButton[][];
    ImageButton mainButton[];

    public static int empty = R.drawable.empty;

    Joueur j[];

    int curJ;

    Piece curP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p = new Piece[4][4];
        j = new Joueur[2];
        j[0] = new Joueur(false);
        j[1] = new Joueur(true);

        setContentView(R.layout.activity_plateau);

        pieceButton = new ImageButton[4][4];
        mainButton = new ImageButton[8];

        pieceButton[0][0] = (ImageButton) findViewById(R.id.imageButton);
        pieceButton[0][1] = (ImageButton) findViewById(R.id.imageButton2);
        pieceButton[0][2] = (ImageButton) findViewById(R.id.imageButton3);
        pieceButton[0][3] = (ImageButton) findViewById(R.id.imageButton4);

        pieceButton[1][0] = (ImageButton) findViewById(R.id.imageButton5);
        pieceButton[1][1] = (ImageButton) findViewById(R.id.imageButton6);
        pieceButton[1][2] = (ImageButton) findViewById(R.id.imageButton7);
        pieceButton[1][3] = (ImageButton) findViewById(R.id.imageButton8);

        pieceButton[2][0] = (ImageButton) findViewById(R.id.imageButton9);
        pieceButton[2][1] = (ImageButton) findViewById(R.id.imageButton10);
        pieceButton[2][2] = (ImageButton) findViewById(R.id.imageButton11);
        pieceButton[2][3] = (ImageButton) findViewById(R.id.imageButton12);

        pieceButton[3][0] = (ImageButton) findViewById(R.id.imageButton13);
        pieceButton[3][1] = (ImageButton) findViewById(R.id.imageButton14);
        pieceButton[3][2] = (ImageButton) findViewById(R.id.imageButton15);
        pieceButton[3][3] = (ImageButton) findViewById(R.id.imageButton16);

        mainButton[0] = (ImageButton) findViewById(R.id.hand1);
        mainButton[1] = (ImageButton) findViewById(R.id.hand2);
        mainButton[2] = (ImageButton) findViewById(R.id.hand3);
        mainButton[3] = (ImageButton) findViewById(R.id.hand4);

        mainButton[4] = (ImageButton) findViewById(R.id.hand5);
        mainButton[5] = (ImageButton) findViewById(R.id.hand6);
        mainButton[6] = (ImageButton) findViewById(R.id.hand7);
        mainButton[7] = (ImageButton) findViewById(R.id.hand8);

        Piece.image[0][0][0][0] = R.drawable.piece_1;
        Piece.image[0][1][0][0] = R.drawable.piece_2;
        Piece.image[0][0][1][0] = R.drawable.piece_3;
        Piece.image[0][1][1][0] = R.drawable.piece_4;

        Piece.image[1][0][0][0] = R.drawable.piece_5;
        Piece.image[1][1][0][0] = R.drawable.piece_6;
        Piece.image[1][0][1][0] = R.drawable.piece_7;
        Piece.image[1][1][1][0] = R.drawable.piece_8;

        Piece.image[0][0][0][1] = R.drawable.piece_9;
        Piece.image[0][1][0][1] = R.drawable.piece_10;
        Piece.image[0][0][1][1] = R.drawable.piece_11;
        Piece.image[0][1][1][1] = R.drawable.piece_12;

        Piece.image[1][0][0][1] = R.drawable.piece_13;
        Piece.image[1][1][0][1] = R.drawable.piece_14;
        Piece.image[1][0][1][1] = R.drawable.piece_15;
        Piece.image[1][1][1][1] = R.drawable.piece_16;

        for(int i = 0; i < 8; i++) {
            mainButton[i].setOnClickListener(new PieceListener(i));
        }


        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                pieceButton[i][j].setOnClickListener(new CaseListener(i,j));
                pieceButton[i][j].setImageResource(R.drawable.empty);
                pieceButton[i][j].setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }


        j[0].drawMain(mainButton, true);
    }

    //Condition de victoire
    public boolean gagne() {
        for(int i = 0; i < 4; i++) {
            if(combinaisonGagne(p[i][0], p[i][1], p[i][2], p[i][3])) return true; //Ligne
            if(combinaisonGagne(p[0][i], p[1][i], p[2][i], p[3][i])) return true; //Colonne
        }
        if(combinaisonGagne(p[0][0], p[1][1], p[2][2], p[3][3])) return true; //Diagonale 1
        if(combinaisonGagne(p[0][3], p[1][2], p[2][1], p[3][0])) return true; //Diagonale 2
        return false;
    }

    public boolean combinaisonGagne(Piece p1, Piece p2, Piece p3, Piece p4) {
        if((p1 == null) || (p2 == null) || (p3 == null) || (p4 == null)) return false;

        if(p1.estCruciforme && p2.estCruciforme && p3.estCruciforme && p4.estCruciforme) return true;
        if(p1.estCerclee && p2.estCerclee && p3.estCerclee && p4.estCerclee) return true;
        if(p1.estCarree && p2.estCarree && p3.estCarree && p4.estCarree) return true;
        if(p1.estNoire && p2.estNoire && p3.estNoire && p4.estNoire) return true;

        if(!p1.estCruciforme && !p2.estCruciforme && !p3.estCruciforme && !p4.estCruciforme) return true;
        if(!p1.estCerclee && !p2.estCerclee && !p3.estCerclee && !p4.estCerclee) return true;
        if(!p1.estCarree && !p2.estCarree && !p3.estCarree && !p4.estCarree) return true;
        if(!p1.estNoire && !p2.estNoire && !p3.estNoire && !p4.estNoire) return true;

        return false;
    }

    enum Etat {
        P1_Pick,
        P2_Place,
        P2_Pick,
        P1_Place,
        P1_Gagne,
        P2_Gagne
    }

    Etat e = Etat.P1_Pick;

    public void transition() {
        View root = findViewById(android.R.id.content);
        switch(e) {
            case P1_Pick:
                j[0].drawMain(mainButton, false);
                curJ = 1;
                clickablePlateau(true);
                e = Etat.P2_Place;
                root.setBackgroundColor(Color.parseColor("#000000"));
                Log.i("OC_RSS","P1_Pick -> P2_Place");
                break;
            case P2_Pick:
                j[1].drawMain(mainButton, false);
                curJ = 0;
                clickablePlateau(true);
                e = Etat.P1_Place;
                root.setBackgroundColor(Color.parseColor("#ffffff"));
                Log.i("OC_RSS","P2_Pick -> P1_Place");
                break;
            case P1_Place:
                clickablePlateau(false);

                if(gagne()) {
                    e = Etat.P1_Gagne;
                    Log.i("OC_RSS","P1_Place -> P1_Gagne");
                    victoire(1);
                } else {
                    j[0].drawMain(mainButton, true);
                    e = Etat.P1_Pick;
                    Log.i("OC_RSS","P1_Place -> P1_Pick");
                }
                break;
            case P2_Place:
                clickablePlateau(false);

                if(gagne()) {
                    e = Etat.P2_Gagne;
                    Log.i("OC_RSS","P2_Place -> P2_Gagne");
                    victoire(2);
                } else {
                    j[1].drawMain(mainButton, true);
                    e = Etat.P2_Pick;
                    Log.i("OC_RSS","P2_Place -> P2_Pick");
                }
                break;
            case P1_Gagne:
                Log.i("OC_RSS","P1_Gagne -> P1_Gagne");
                break;
            case P2_Gagne:
                Log.i("OC_RSS","P2_Gagne -> P2_Gagne");
                break;
        }
    }

    public void victoire(int i) {
        Intent myIntent = new Intent(this, Victoire.class);
        myIntent.putExtra("gagnant","" + i);
        startActivity(myIntent);
    }

    public void clickablePlateau(boolean place) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(place && (pieceButton[i][j] != null))
                    pieceButton[i][j].setClickable(true);
                else
                    pieceButton[i][j].setClickable(false);
            }
        }
    }

    //Actions


    //Listeners
    class CaseListener implements View.OnClickListener {
        int x, y;

        public CaseListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View v) {
            p[x][y] = curP;
            pieceButton[x][y].setImageResource(curP.getImage());
            pieceButton[x][y].setScaleType(ImageView.ScaleType.FIT_CENTER);
            pieceButton[x][y].setClickable(false);

            //curP = null;
            transition();
        }
    }

    class PieceListener implements View.OnClickListener {
        int x;

        public PieceListener(int x) {
            this.x = x;
        }

        @Override
        public void onClick(View v) {
            curP = j[curJ].getPiece(x);
            j[curJ].play(x);
            transition();
        }
    }
}
