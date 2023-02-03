package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.gridlayout.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // 0: YELLOW  1:RED

    int [] arr = {2,2,2,2,2,2,2,2,2};
    int [][] tarr = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int YOR = 0;
    boolean GameActive = true;
    public void DropIn(View view) {
        TextView text1 = findViewById(R.id.textView1);
        TextView text2 = findViewById(R.id.textView2);
        ImageView counter = (ImageView) view;
        Log.i("TAG", counter.getTag().toString());
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if (arr[tappedcounter]==2 && GameActive){
            arr[tappedcounter] = YOR;
                if (YOR == 0) {
                    counter.setImageResource(R.drawable.yellow);
                    YOR = 1;
                } else {
                    counter.setImageResource(R.drawable.red);
                    YOR = 0;
                }
            counter.animate().alpha(1).rotation(360).setDuration(300);
            for (int[] i : tarr) {
                if (arr[i[0]] == arr[i[1]] && arr[i[1]] == arr[i[2]] && arr[i[0]] != 2) {
                    GameActive = false;
                    counter.animate().alpha(1).rotation(360).setDuration(300);
                    if (YOR == 0) {
                        text1.animate().alpha(1);
                        counter.animate().alpha(1).rotation(360).setDuration(300);
                    } else {
                        text2.animate().alpha(1);
                        counter.animate().alpha(1).rotation(360).setDuration(300);
                    }
                    Button ResButton = findViewById(R.id.button1);
                    ResButton.setVisibility(View.VISIBLE);
                }
                else if(arr[0] != 2 && arr[1] != 2 && arr[2] != 2 && arr[3] != 2 && arr[4] != 2 && arr[5] != 2 && arr[6] != 2 && arr[7] != 2&& arr[8] != 2){
                    counter.animate().alpha(1).rotation(360).setDuration(300);
                    Button ResButton = findViewById(R.id.button1);
                    ResButton.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void Restart(View view){
        TextView text1 = findViewById(R.id.textView1);
        TextView text2 = findViewById(R.id.textView2);
        Button ResButton = findViewById(R.id.button1);
        ResButton.setVisibility(View.INVISIBLE);
        if (YOR == 0) {
            text1.animate().alpha(0);
        } else {
            text2.animate().alpha(0);
        }
        GridLayout Grid = findViewById(R.id.Grid);
        for (int i=0;i<Grid.getChildCount();i++){
            ImageView Counter = (ImageView) Grid.getChildAt(i);
            Counter.setImageDrawable(null);
        }
        Arrays.fill(arr, 2);
        YOR = 0;
        GameActive = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}