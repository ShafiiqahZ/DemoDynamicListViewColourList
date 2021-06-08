package sg.edu.rp.c346.id20037987.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etColour;
    EditText etIndexElement;
    Button addColourBtn, removeColourBtn, updateColourBtn;
    ListView lvColour;
    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        addColourBtn = findViewById(R.id.buttonAddItem);
        removeColourBtn = findViewById(R.id.buttonRemoveItem);
        updateColourBtn = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColour = new ArrayList<String>();

        alColour.add("Orange");
        alColour.add("Red");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColour);

        lvColour.setAdapter(aaColour);

        addColourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etColour.getText().toString();
                //aiColour.add(colour);
                if(etColour.getText().toString().isEmpty() == false && etIndexElement.getText().toString().isEmpty() == false) {
                    //int pos = Integer.parseInt(etColour.getText().toString());
                    //String colour = etColour.getText().toString();
                    //int pos = Integer.parseInt(etColour.getText().toString());
                    //alColour.add(pos, colour);
                    alColour.add(colour);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a colour and index to add new colour", Toast.LENGTH_LONG).show();
                }

            }
        });

        removeColourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String colour = etColour.getText().toString();
                if(etIndexElement.getText().toString().isEmpty() == false) {
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColour.remove(pos);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a index to remove", Toast.LENGTH_LONG).show();
                }

            }
        });

        updateColourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etColour.getText().toString();
                int ind = Integer.parseInt(etIndexElement.getText().toString());

                //aiColour.add(colour);
                //int pos = Integer.parseInt(etColour.getText().toString());
                if(etColour.getText().toString().isEmpty() == false && etIndexElement.getText().toString().isEmpty() == false) {
                    alColour.set(ind, colour);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a colour and index to update", Toast.LENGTH_LONG).show();
                }

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColour.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });

    }
}