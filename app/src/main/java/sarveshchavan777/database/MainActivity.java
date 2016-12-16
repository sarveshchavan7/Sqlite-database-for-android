package sarveshchavan777.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends Activity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    VivzHelper vivzHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vivzHelper=new VivzHelper(this);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);
        ed6=(EditText)findViewById(R.id.editText6);
    }

    public void adduser(View view) {

            String e1 = ed1.getText().toString();
            String e2 = ed2.getText().toString();
            SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();
            vivzHelper.insertdata(e1,e2,sqLiteDatabase);
            vivzHelper.close();



    }

    public void userdetails(View view) {

        SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();
        String data=vivzHelper.getalldata(sqLiteDatabase);
        Message.message(this,data);

    }

    public void getpass(View view) {

        SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();

        String s1=ed3.getText().toString();
        if(s1.isEmpty()){
            Toast.makeText(MainActivity.this, " Please type something else empty database", Toast.LENGTH_SHORT).show();
        }
        String s2=vivzHelper.viewpass(s1,sqLiteDatabase);
        Message.message(this,s2);

    }
    public void getid(View view) {

        SQLiteDatabase db=vivzHelper.getWritableDatabase();
        //sarvesh 123
        String s4=ed4.getText().toString();
       if(s4.isEmpty()){
           Toast.makeText(MainActivity.this, "you didn't types anything or database empty", Toast.LENGTH_SHORT).show();
       }
       else {
           String sub1 = s4.substring(0, s4.indexOf(" "));
           String sub2 = s4.substring(s4.indexOf(" ") + 1);
           String s5 = vivzHelper.viewid(sub1, sub2, db);
           Message.message(this, s5);
       }
    }


    public void update(View view) {

        String ss1=ed5.getText().toString();
        SQLiteDatabase db = vivzHelper.getWritableDatabase();

        if(ss1.isEmpty()){
            Toast.makeText(MainActivity.this, " Please type something to update", Toast.LENGTH_SHORT).show();
        }
         else
        {
            String subb3 = ss1.substring(0, ss1.indexOf(" "));
            String subb4 = ss1.substring(ss1.indexOf(" ") + 1);
            vivzHelper.updaterow(db, subb3, subb4);
            Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }
        }


    public void delete(View view) {

        SQLiteDatabase db=vivzHelper.getWritableDatabase();
        String sss1=ed6.getText().toString();

        if(sss1.isEmpty()){
            Toast.makeText(MainActivity.this,"type something or Table is empty!!!",Toast.LENGTH_SHORT).show();
        }else {
            vivzHelper.deletersome(db, sss1);
            Toast.makeText(MainActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
