package io.okcollect.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ramogiochola on 6/18/16.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "io.okcollect.android.sdk.database.db";
    private static final int DATABASE_VERSION = 12;

    private static final String DATABASE_CREATE_RUNLIST =
            "create table " + io.okcollect.android.utilities.Constants.TABLE_NAME_RUNLIST + " (" +

                    io.okcollect.android.utilities.Constants.COLUMN_ID + " integer primary key autoincrement, " +
                    io.okcollect.android.utilities.Constants.COLUMN_CUSTOMERNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_AFFILIATION + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_PHONECUSTOMER + " VARCHAR, " +


                    io.okcollect.android.utilities.Constants.COLUMN_CLAIMAFLID + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_CLAIMUALID + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_UNIT + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_DIRECTION + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ROUTE + " VARCHAR, " +

                    io.okcollect.android.utilities.Constants.COLUMN_PROPERTYNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_PROPERTYNUMBER + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_FLOOR + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ISODDRESS + " INTEGER, " +
                    io.okcollect.android.utilities.Constants.COLUMN_LAT + " REAL, " +

                    io.okcollect.android.utilities.Constants.COLUMN_LNG + " REAL, " +
                    io.okcollect.android.utilities.Constants.COLUMN_BRANCH + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_IMAGEURL + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_DELIVERY_NOTES + " VARCHAR, " +

                    io.okcollect.android.utilities.Constants.COLUMN_LOCATIONNICKNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_TRADITIONALBUILDINGNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_BUSINESSNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_TRADITIONALSTREETNUMBER + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_TRADITIONALSTREETNAME + " VARCHAR, " +

                    io.okcollect.android.utilities.Constants.COLUMN_TOTHEDOOR + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_TRADITIONALBUILDINGNUMBER + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_STREETNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_STREETNUMBER + " VARCHAR, " +

                    io.okcollect.android.utilities.Constants.COLUMN_CUSTOMERUSERID + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ADDRESSTYPE + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_INTERNAL_ADDRESSTYPE + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ISNEWUSER + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ISEMPTYUAL + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ACCURACY + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_ADDRESSFREQUENCY + " INTEGER, " +
                    io.okcollect.android.utilities.Constants.COLUMN_CREATEDON + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_LASTUSED + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_LOCATIONNAME + " VARCHAR, " +
                    io.okcollect.android.utilities.Constants.COLUMN_UNIQUEID + " VARCHAR, " +
                    " UNIQUE(" + io.okcollect.android.utilities.Constants.COLUMN_CLAIMUALID + ") ON CONFLICT REPLACE);";

    private static final String DATABASE_CREATE_STUFF =
            "create table " + io.okcollect.android.utilities.Constants.TABLE_NAME_STUFF + " (" +
                    io.okcollect.android.utilities.Constants.COLUMN_ID + " integer primary key autoincrement, " +
                    io.okcollect.android.utilities.Constants.COLUMN_PROPERTY + " VARCHAR NOT NULL UNIQUE, " +
                    io.okcollect.android.utilities.Constants.COLUMN_VALUE + " VARCHAR , " +
                    " UNIQUE(" + io.okcollect.android.utilities.Constants.COLUMN_PROPERTY + ") ON CONFLICT REPLACE);";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_RUNLIST);
        database.execSQL(DATABASE_CREATE_STUFF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + io.okcollect.android.utilities.Constants.TABLE_NAME_RUNLIST);
        db.execSQL("DROP TABLE IF EXISTS " + io.okcollect.android.utilities.Constants.TABLE_NAME_STUFF);
        onCreate(db);
    }
}
