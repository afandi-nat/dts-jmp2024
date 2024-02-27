package net.afandistudio.aplikasikpu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "db_kpu";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLES_STD = "kpu";
    private static final String KEY_ID = "id";
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_SEX = "sex";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_TABLE_VOTER = "CREATE TABLE "
            + TABLES_STD + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NIK + " TEXT, "
            + KEY_NAME + " TEXT, " + KEY_ADDRESS + " TEXT, "
            + KEY_SEX + " TEXT );";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_VOTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS '"+ TABLES_STD +"'");
        onCreate(db);
    }

    public void addUser(String nik, String name, String address, String sex) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIK, nik);
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_SEX, sex);

        db.insert(TABLES_STD, null, values);
    }
}
