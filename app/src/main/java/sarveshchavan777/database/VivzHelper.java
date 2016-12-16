package sarveshchavan777.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class VivzHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="vivzdatabase";
    /*private static final String TABLE_NAME="VIVZTABLE";*/
    private static final int DATABASE_VERSION=47;
/*    private static final String UID="_Id";
    private static final String NAME="Name";*/
  /* private static final String ADD="Addess";*/
   /*"+ADD+" VARCHAR(255)*/
    private static final String CREATE_TABLE ="CREATE TABLE "+Contract.user.TABLE_NAME+" ("+Contract.user.UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Contract.user.NAME+" VARCHAR(255), "+Contract.user.PASS+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+Contract.user.TABLE_NAME;
    private Context context;

    public VivzHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        Message.message(context, "construtor called");
     /*  hi();*/
    }

 /*   private void hi() {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(DROP_TABLE);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table viviztable

        try {
            Message.message(context, "onCreate called");
            sqLiteDatabase.execSQL(CREATE_TABLE);
           /* Message.message(context, "onCreate called")*/;
        }catch (SQLException e){
            Message.message(context,""+e);
        }


    }

    public void insertdata(String name,String pass,SQLiteDatabase db){



        ContentValues contentValues=new ContentValues();
        contentValues.put(Contract.user.NAME,name);
        contentValues.put(Contract.user.PASS,pass);
        db.insert(Contract.user.TABLE_NAME,null,contentValues);
         Toast.makeText(context,"info added",Toast.LENGTH_SHORT).show();


    }





    public String getalldata(SQLiteDatabase db){

        String coloumns[]={Contract.user.UID, Contract.user.NAME, Contract.user.PASS};
        Cursor cursor=db.query(Contract.user.TABLE_NAME,coloumns,null,null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext()){
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String password=cursor.getString(2);
            stringBuffer.append(cid+" "+name+" "+password+"\n");

        }
        return  stringBuffer.toString();

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            Message.message(context, "onUpgrade called");
           sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (SQLException e){
            Message.message(context,""+e);
        }
    }


    public String viewpass(String name1,SQLiteDatabase sqLiteDatabase) {

        String coloumns[]={Contract.user.NAME, Contract.user.PASS};
        Cursor cursor=sqLiteDatabase.query(Contract.user.TABLE_NAME, coloumns, Contract.user.NAME+" = '"+name1+"'",null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext()){

            int index1=cursor.getColumnIndex(Contract.user.NAME);
            int index2=cursor.getColumnIndex(Contract.user.PASS);

            String name=cursor.getString(index1);
            String password=cursor.getString(index2);
            stringBuffer.append(password+"\n");

        }
        return  stringBuffer.toString();

    }

    public  String  viewid(String name1, String pass1, SQLiteDatabase sqLiteDatabase) {

        //select id from viztable where name=? AND password=?
        String coloumns[]={Contract.user.UID};
        String selectionargs[]={name1,pass1};
        Cursor cursor=sqLiteDatabase.query(Contract.user.TABLE_NAME, coloumns, Contract.user.NAME + " =? AND "+ Contract.user.PASS + " =? ",selectionargs,null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext()){

            int index0=cursor.getColumnIndex(Contract.user.UID);
            int personid=cursor.getInt(index0);
            stringBuffer.append(personid+ "\n");

        }
        return  stringBuffer.toString();



    }
}
