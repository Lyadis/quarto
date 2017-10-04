package nharrand.fr.quarto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Victoire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoire);

        Intent myIntent = getIntent(); // gets the previously created intent
        String gagnant = myIntent.getStringExtra("gagnant");

        Button playButton = (Button) findViewById(R.id.button);
        playButton.setText("Victoire du joueur " + gagnant);
        if(gagnant.equals("1")) {
            playButton.setBackgroundColor(Color.parseColor("#ffffff"));
            playButton.setTextColor(Color.parseColor("#000000"));
        } else {
            playButton.setBackgroundColor(Color.parseColor("#000000"));
            playButton.setTextColor(Color.parseColor("#ffffff"));
        }
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transition = new Intent(Victoire.this, MainActivity.class);
                startActivity(transition);
            }
        });
    }
}
