package sans.co.zw.sansexposure.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Steve on 02/04/2015.
 */
public class UserPreferences {
    private static final String USER_PREFS = "SANS_PREFS";
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;

    private String databaseCreated = "database_created_pref";
    private String emailAddress = "email_address_pref";
    private String password = "password_pref";
    private Context ctx;

    public UserPreferences(Context ctx) {
        this.ctx = ctx;
        this.appSharedPrefs = ctx.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public Boolean getDatabaseCreated() {
        return appSharedPrefs.getBoolean(databaseCreated,false);
    }

    public void setDatabaseCreated(Boolean databaseCreated) {
        prefsEditor.putBoolean(this.databaseCreated,databaseCreated).commit();
    }

    public String getEmailAddress() {
        return appSharedPrefs.getString(emailAddress,"empty");
    }

    public void setEmailAddress(String emailAddress) {
        prefsEditor.putString(this.emailAddress,emailAddress).commit();
    }

    public String getPassword() {
        return appSharedPrefs.getString(password,"empty");
    }

    public void setPassword(String password) {
        prefsEditor.putString(this.password,password).commit();
    }
}
