package com.ades.mylistview_f55121062;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    private String[] dataName={"Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Patimura", "Soekarno"};
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero>heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ListView listView = findViewById(R.id.lv_list);
//        ArrayAdapter<String> adapter = new
//        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
//        listView.setAdapter(adapter);

        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,heroes.get(i).getName(), Toast.LENGTH_SHORT) .show();
                if (i==0){
                    //clicked Rahmad_Dg_Matutu
                    startActivity(new Intent( MainActivity.this, Ahmad_Dahlan.class ));
                }
                else if (i==1){
                    //clicked Ahmad_dahlan
                    startActivity(new Intent( MainActivity.this, Ahmad_Yani.class ));
                }
                else if (i==2){
                    //clicked Ahmad_Yani
                    startActivity(new Intent( MainActivity.this, Bung_Tomo.class ));
                }
                else if (i==3){
                    //clicked Bung_Tomo
                    startActivity(new Intent( MainActivity.this, Gatot_Subroto.class ));
                }
                else if (i==4){
                    //clicked Gatot_Subroto
                    startActivity(new Intent( MainActivity.this, Ki_Hadjar_Dewantara.class ));
                }
                else if (i==5){
                    //clicked Ki_Hajar_Dewantara
                    startActivity(new Intent( MainActivity.this, Mohammad_Hatta.class ));
                }
                else if (i==6){
                    //clicked Mohammad_Hatta
                    startActivity(new Intent( MainActivity.this, Sudirman.class ));
                }
                else if (i==7){
                    //clicked Soekarno
                    startActivity(new Intent( MainActivity.this, Soekarno.class ));
                }
                else if (i==8){
                    //clicked Sudirman
                    startActivity(new Intent( MainActivity.this, Soepomo.class ));
                }
                else if (i==9){
                    //clicked Supomo
                    startActivity(new Intent( MainActivity.this, DetailActivity_F55121062.class ));
                }
            }
        });
    }


//            @Override
//            public void onItemClick(AdapterView<?>adapterView, View view, int i, long id) {
//                if(Position==0){
//                    startActivity(new Intent(MainActivity.this, detail_F55121062.class));
//            }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        heroes = new ArrayList<>();

        for (int i=0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
}