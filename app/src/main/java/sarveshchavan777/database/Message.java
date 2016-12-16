package sarveshchavan777.database;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by LENOVO on 12/15/2016.
 */

public class Message {
    public static  void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
}
