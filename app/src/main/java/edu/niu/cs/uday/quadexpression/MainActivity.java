package edu.niu.cs.uday.quadexpression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_a, et_b, et_c, et_x1, et_x2;
    Button bt,clr;

    double a,b,c,d, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_a = (EditText)findViewById(R.id.a);
        et_b = (EditText)findViewById(R.id.b);
        et_c = (EditText)findViewById(R.id.c);
        et_x1 = (EditText)findViewById(R.id.x1);
        et_x2 = (EditText)findViewById(R.id.x2);


        bt = (Button) findViewById(R.id.calculate);
        clr = (Button)findViewById(R.id.clear);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_a.setText("");
                et_b.setText("");
                et_c.setText("");
                et_x1.setText("");
                et_x2.setText("");

            }
        });

        bt.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                if(!et_a.getText().toString().equals("") && !et_b.getText().toString().equals("")&&
                        !et_c.getText().toString().equals("")){
                    a = Double.parseDouble(et_a.getText().toString());
                    b = Double.parseDouble(et_b.getText().toString());
                    c = Double.parseDouble(et_c.getText().toString());

                    d = Math.pow(b,2) - 4*a*c;


                    if(d == 0){
                        x1 = -b/(2*a);
                        et_x1.setText("X1:       "+x1);
                        et_x2.setText("X2:       "+x1);
                    }
                    if(d < 0){
                        et_x1.setText("X1: Imaginary");
                        et_x2.setText("X2: Imaginary ");
                    }

                    if(d>0){
                        x1 = (-b + Math.sqrt(d))/(2*a);
                        x2 = (-b - Math.sqrt(d))/(2*a);
                        et_x1.setText("X1:         "+x1);
                        et_x2.setText("X2:         "+x2);

                    }
                }
            }

        });




    }
}
