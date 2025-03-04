package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    Button btn1 , btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 ,restart;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int count;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            btn1 =findViewById(R.id.btn1);
            btn2 =findViewById(R.id.btn2);
            btn3 =findViewById(R.id.btn3);
            btn4 =findViewById(R.id.btn4);
            btn5 =findViewById(R.id.btn5);
            btn6 =findViewById(R.id.btn6);
            btn7 =findViewById(R.id.btn7);
            btn8 =findViewById(R.id.btn8);
            btn9 =findViewById(R.id.btn9);

           restart =  findViewById(R.id.restart);
                   restart.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           newGame();
                       }
                   });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    int flag =0;
    public void check(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setIcon(R.drawable.winner);
        alert.setCancelable(false);
        alert.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        });
        Button currentButton = (Button) v;
        count++;

        if (currentButton.getText().toString().equals("")) {

            if (flag == 0) {

                currentButton.setText("X");
                flag = 1;
            } else {
                currentButton.setText("O");
                flag = 0;
            }
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();
            if (count > 4) {
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    alert.setTitle("Winner is "+b1);
                    alert.show();

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    alert.setTitle("Winner is "+b4);
                    alert.show();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    alert.setTitle("Winner is "+b7);
                    alert.show();

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    alert.setTitle("Winner is "+b1);
                    alert.show();

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    alert.setTitle("Winner is "+b2);
                    alert.show();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    alert.setTitle("Winner is "+b3);
                    alert.show();

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    alert.setTitle("Winner is "+b1);
                    alert.show();

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    alert.setTitle("Winner is "+b3);
                    alert.show();

                }else if (count == 9){
                    alert.setIcon(R.drawable.gameover);
                    alert.setTitle("Draw");
                    alert.show();
                }


            }

        }
    }
    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;

    }

}