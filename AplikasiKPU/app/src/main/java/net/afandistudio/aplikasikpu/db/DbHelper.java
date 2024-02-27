package net.afandistudio.aplikasikpu.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import net.afandistudio.aplikasikpu.model.Voters;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "dbkpu";
    private static final  int DATABASE_VERSION = 1;
    private static final String TABLE_STD = "kpu";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_NIK = "nik";
    private static final String KEY_PHONE = "handphone";
    private static final String KEY_SEX = "sex";

    private static final String CREATE_TABLE_VOTERS = "CREATE TABLE "
            + TABLE_STD + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT, " + KEY_NIK + " TEXT, "
            + KEY_PHONE + " TEXT, " + KEY_SEX + " TEXT );";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_VOTERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STD + "'");
        onCreate(db);
    }

    public void addUserDetail(String nik, String name, String handphone, String sex) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_NIK, nik);
        values.put(KEY_PHONE, handphone);
        values.put(KEY_SEX, sex);

        db.insert(TABLE_STD, null, values);
    }

    @SuppressLint("Range")
    public ArrayList<Voters> getAllUsers() {
        ArrayList<Voters> userModelArrayList = new ArrayList<Voters>();

        String selectQuery = "SELECT * FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Voters vote = new Voters();
                vote.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                vote.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                vote.setNik(c.getString(c.getColumnIndex(KEY_NIK)));
                vote.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
                vote.setSex(c.getString(c.getColumnIndex(KEY_SEX)));
                // adding to Students list
                userModelArrayList.add(vote);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }
}
