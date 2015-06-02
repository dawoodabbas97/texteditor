package dawoodabbas.texteditor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public String[] color={"Blue","Yellow","Green","Black"};
    public Integer[] size={10,20,30,40};
    public boolean bold,italic;
    public String[] fonts={"Times New Roman","Arial"};
    public String colour="Blue",font="Time New Roman";
    public int sizeof=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items();
    }
    public void items()
    {
        bold=false;
        italic=false;
        final EditText te = (EditText) findViewById(R.id.text);
        final  Spinner col = (Spinner) findViewById(R.id.color);
        final Spinner siz = (Spinner)findViewById(R.id.size);
        ListView fon=(ListView) findViewById(R.id.font);
        ArrayAdapter<String> co = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, color);
        co.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        col.setAdapter(co);
        ArrayAdapter<Integer> si = new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item, size);
        siz.setAdapter(si);
        ArrayAdapter<String> fo= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fonts);
        fon.setAdapter(fo);





        fon.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String tt=String.valueOf(col.getSelectedItem());
                        TextView c=(TextView)view;
                        font=c.getText().toString();

                        colour=String.valueOf(col.getSelectedItem());

                        sizeof=Integer.parseInt(String.valueOf(siz.getSelectedItem()));
                        Intent i= new Intent(MainActivity.this,fina.class);
                        i.putExtra("result",te.getText().toString());
                        i.putExtra("colour",colour);
                        i.putExtra("size",sizeof);
                        i.putExtra("bold",bold);
                        i.putExtra("italic",italic);
                        i.putExtra("font",font);
                        startActivity(i);

                    }
                }

        );

    }

    public void Bold(View v){
        boolean checked=((CheckBox) v).isChecked();
        if(checked)
            bold=true;
        else
            bold=false;
    }

    public void Italic(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        if (checked)
            italic = true;
        else
            italic = false;
    }


}
