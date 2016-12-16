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
    EditText ed1,ed2,ed3,ed4;
    VivzHelper vivzHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vivzHelper=new VivzHelper(this);
        /* SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();*/
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
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
        String s2=vivzHelper.viewpass(s1,sqLiteDatabase);

        Message.message(this,s2);

    }
    public void getid(View view) {
        SQLiteDatabase db=vivzHelper.getWritableDatabase();
        //sarvesh 123
        String s4=ed4.getText().toString();
        String sub1= s4.substring(0,s4.indexOf(" "));
        String sub2=s4.substring(s4.indexOf(" ")+1);

         String s5=vivzHelper.viewid(sub1,sub2,db);
       Message.message(this,s5);
    }


}
