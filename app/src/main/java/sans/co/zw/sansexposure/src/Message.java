package sans.co.zw.sansexposure.src;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Steve on 21/02/2015.
 */
public class Message {
    public static void message(Context ctx, String msg){
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }
}
