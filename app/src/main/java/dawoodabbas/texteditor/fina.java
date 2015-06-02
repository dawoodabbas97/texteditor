package dawoodabbas.texteditor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


public class fina extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fina);

        Bundle fin=getIntent().getExtras();
        if(fin!=null) {
            String str = fin.getString("result");
            TextView t = (TextView) findViewById(R.id.result);
            t.setText(str);
            boolean bold = fin.getBoolean("bold");
            boolean italic = fin.getBoolean("italic");
            String color=fin.getString("colour");
            int size=fin.getInt("size");
            String font=fin.getString("font");
            Typeface tf=null;
            if(font.equals("Times New Roman")) tf = Typeface.createFromAsset(getAssets(), "times.tf");
            if(font.equals("Arial")) tf = Typeface.createFromAsset(getAssets(), "arial.tf");
            t.setTypeface(tf);
            if(bold){
                t.setTypeface(null, Typeface.BOLD);
            }
            if(italic){
                t.setTypeface(null, Typeface.ITALIC);
            }
            if(bold&&italic){
                t.setTypeface(null,Typeface.BOLD_ITALIC);
            }
            if(color.equals("Blue"))t.setTextColor(Color.BLUE);
            if(color.equals("Red"))t.setTextColor(Color.RED);
            if(color.equals("Yellow"))t.setTextColor(Color.YELLOW);
            if(color.equals("Green"))t.setTextColor(Color.GREEN);
            if(color.equals("Gray"))t.setTextColor(Color.GRAY);
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);

        }
    }


    public void exit(View v)
    {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);



    }
    public  void back(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}