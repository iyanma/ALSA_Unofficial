package com.example.alsaunofficial.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.alsaunofficial.Models.Origin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OriginsHelper extends SQLiteOpenHelper implements Serializable {

    private static final String TAG = OriginsHelper.class.getCanonicalName();
    private final Context context;

    public static final String DATABASE_NAME = "origins.db";
    private static final String ORIGINS_TABLE = "origins";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PROVINCECOUNTRY_NAME = "provinceCountryName";
    private static final String COLUMN_NAME_AUTOCOMPLETE = "nameAutocomplete";
    private static final String COLUMN_ICON = "icon";
    private static final String COLUMN_IS_MOVELIA_STOP = "isMoveliaStop";
    private static final String COLUMN_SIMPLIFIED_NAME = "simplifiedName";
    private static final String COLUMN_PRIORITY = "priority";
    private static final String COLUMN_NOMOVELIA = "nomovelia";
    private static final String COLUMN_AIRPORT_NAME = "airportName";

    public OriginsHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
        try {
            createDatabase();
        } catch (IOException ioe) {
            Log.e(TAG,"Could not create database.", ioe);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDatabase() throws IOException {
        if (!databaseExists()) {
            // By calling this method and empty database will be created into the default system path
            // of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean databaseExists() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException {
        // Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = context.getDatabasePath(DATABASE_NAME).getPath();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // Transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    public List<Origin> getOriginsFromDatabase() {
        if (!databaseExists()) {
            Log.e(TAG, "The datasbase has not being created.");
            return null;
        }

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + ORIGINS_TABLE;

        ArrayList<Origin> alo = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                Origin origin = new Origin();
                int i = 0;
                origin.setId(String.valueOf(c.getInt(i++)));
                origin.setName(c.getString(i++));
                origin.setProvincecountryName(c.getString(i++));
                origin.setNameAutocomplete(c.getString(i++));
                origin.setIcon(c.getString(i++));
                origin.setMoveliaStop(c.getString(i++).charAt(0)=='t');
                origin.setSimplifiedName(c.getString(i++));
                origin.setPriority(c.getString(i++));
                origin.setNomovelia(c.getString(i++));
                origin.setAirportName(c.getString(i++));

                alo.add(origin);

            } while (c.moveToNext());
        }
        c.close();
        db.close();

        return alo;
    }
}
