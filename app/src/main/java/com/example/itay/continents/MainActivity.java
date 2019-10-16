package com.example.itay.continents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Itay Elbaz
 * @version beta
 * @since 16/10/19
 * This activity is the main activity, where you can choose a continent out of 6 options and then click next.
 * The option you chose will be printed as a toast.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    String[] str={"Africa","Europe","Asia","South America","North America"};
    int x=60;
    /**
     * lv is the java list view widget
     * The array str contains the continents' names
     * x is an index for of the chosen continent
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, str);

        lv.setAdapter(adp);
    }

    /**
     *This function starts when a continent is chosen
     * @param position-index of the place of the chosen item in the ListView.
     * @return the function prints the continent name as a toast.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ""+str[position], Toast.LENGTH_SHORT).show();
        x=position;
    }

    /**
     * This function starts when the button "next" is clicked.
     * if a continent is chosen we move to the next activity-with the continent's index in str.
     * else, we don't move to the next activity and a toast comes-"please choose a continent"
     */
    public void btn(View view) {
        if(x!=60) {
            Intent si=new Intent(this,countries.class);
            si.putExtra("position",x);
            startActivity(si);
        }
         else {
            Toast.makeText(this, "please choose a continent", Toast.LENGTH_SHORT).show();
        }
    }
}
