package com.sibythampi.Connect3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int r=0;
    int y=0;
    static int e=1;
    int []status={2,2,2,2,2,2,2,2,2};
    int [][]positions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropin(View view){
        ImageView image=(ImageView)view;
        int now=Integer.parseInt(image.getTag().toString());
        e++;
        System.out.println("E:"+e);
        if(status[now]==2) {
            status[now]=r;
            image.setTranslationY(-1000f);

            if (r == 0) {
                image.setImageResource(R.drawable.yellow);
                r = 1;
            } else {
                image.setImageResource(R.drawable.red);
                r = 0;

            }
            image.animate().translationYBy(1000f).setDuration(750);
            for(int []toli:positions){
                if(status[toli[0]]==status[toli[1]])
                {
                    if(status[toli[0]]==status[toli[2]])
                    {
                        if(status[toli[1]]!=2)
                        {
                        String winner="red";
                        y=1;e=1;
                        if(status[toli[0]]==0)
                            winner="yellow";
                        AlertDialog.Builder alert=new AlertDialog.Builder(this);
                        alert.setTitle("Game Over!Thanks for playing Sibi's game!");
                        alert.setCancelable(false);
                        alert.setMessage("Winner is "+winner);
                        alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        alert.show();


                        }
                    }

                }

            }
            if(y==0 && e==10){
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setTitle("Game Over!Thanks for playing Sibi's game!");
                alert.setCancelable(false);
                alert.setMessage("It's a tie!");
                alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.show();
                e=1;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
