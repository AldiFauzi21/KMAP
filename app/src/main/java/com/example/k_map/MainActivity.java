package com.example.k_map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hasil;
    Button button;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final TextView hasil = findViewById(R.id.hasil);
        final EditText input = findViewById(R.id.input);

        button.setOnClickListener(new View.OnClickListener() {

            public int konversi(int a, int b){
                if((a==1)&&(b==0)){
                    return 2;
                }
                return b;
            }
            public int[][] isi(int[] baris, int[][] kmap){

                baris[1]= konversi(baris[0], baris[1]);
                baris[3]= konversi(baris[2], baris[3]);
                kmap[(baris[0]+baris[1])][(baris[2]+baris[3])]=1;
                return kmap;
            }

            @Override
            public void onClick(View v) {
                int i, c;
                int[][] kmap = new int[4][4];
                int[] baris = new int[4];
                for (c=0; c<4;c++){
                    for (i=0; i<4; i++){
                        kmap[c][i]=0;
                    }
                }
                String persamaan = input.getText().toString();
                persamaan = persamaan+" ";
                int size = persamaan.length();
                baris[0]=0;
                baris[1]=0;
                baris[2]=0;
                baris[3]=0;
                i=-1;
                for(c=0;c<size;c++){
                    if((persamaan.charAt(c)=='A')||(persamaan.charAt(c)=='B')||(persamaan.charAt(c)=='C')||(persamaan.charAt(c)=='D')){
                        i++;
                        baris[i]=1;
                    } else if (persamaan.charAt(c)==39){
                        baris[i]=0;
                    } else if (persamaan.charAt(c)==43){
                        if((baris[0]==1)&&(baris[1]==0)){
                            baris[1] = 2;
                        }
                        if((baris[2]==1)&&(baris[3]==0)){
                            baris[3] = 2;
                        }
                        kmap[(baris[0]+baris[1])][(baris[2]+baris[3])]=1;

                        baris[0]=0;
                        baris[1]=0;
                        baris[2]=0;
                        baris[3]=0;
                        i=-1;
                    } else{
                        if((baris[0]==1)&&(baris[1]==0)){
                            baris[1] = 2;
                        }
                        if((baris[2]==1)&&(baris[3]==0)){
                            baris[3] = 2;
                        }
                        kmap[(baris[0]+baris[1])][(baris[2]+baris[3])]=1;
                        break;
                    }
                }
//                hasil.setText(""+persamaan.charAt(1));
                hasil.setText("\n\n"+kmap[0][0]+kmap[1][0]+kmap[2][0]+kmap[3][0]+"\n"+kmap[0][1]+kmap[1][1]+kmap[2][1]+kmap[3][1]+"\n"+kmap[0][2]+kmap[1][2]+kmap[2][2]+kmap[3][2]+"\n"+kmap[0][3]+kmap[1][3]+kmap[2][3]+kmap[3][3]);
            }
        });
    }
}
