package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        int[] gamestate={2,2,2,2,2,2,2,2,2};
        int winingpositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        int activeplayer=0;
    public void dropin(View view) {

        ImageView counter = (ImageView) view;
        int tapped = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tapped] == 2) {
            gamestate[tapped] = activeplayer;
            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.cross);
                activeplayer = 1;
            } else if (activeplayer == 1) {
                counter.setImageResource(R.drawable.circle);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(300f).setDuration(300);

            for (int[] winingposition : winingpositions) {

                if (gamestate[winingposition[0]] == gamestate[winingposition[1]] && gamestate[winingposition[1]] == gamestate[winingposition[2]] && gamestate[winingposition[0]] != 2) {
                    String win="cross";
                    if(gamestate[winingposition[0]]==0);
                    {
                        win="circle";
                    }
                    LinearLayout layout = (LinearLayout) findViewById(R.id.yourlayout);
                    layout.setVisibility(View.VISIBLE);
                    TextView winner =(TextView)findViewById(R.id.textView);
                    winner.setText(win+"  has won !!");

                }
            }
        }
    }

    public void playit(View view)
    {
        LinearLayout layout = (LinearLayout) findViewById(R.id.yourlayout);
        layout.setVisibility(View.INVISIBLE);
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
