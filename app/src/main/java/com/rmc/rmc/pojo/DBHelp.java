package com.rmc.rmc.pojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class DBHelp extends OrmLiteSqliteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "ormliteandroid.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Data,Integer> simpleDao = null;

    private RuntimeExceptionDao<Data,Integer> simpleRuntimeDao = null;


    public DBHelp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(this.getClass().getName(), "onCreate");
            TableUtils.createTable(connectionSource, Data.class);

        } catch (SQLException e) {
            Log.e(this.getClass().getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(this.getClass().getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Data.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(this.getClass().getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public int addData(Data person) throws SQLException {

        int i = getDao().create(person);
        return i;
    }

    public List<Data> getAll() throws SQLException {

        return  getDao().queryForAll();

    }

    public int delete(Integer p) throws SQLException {
        return getDaoData().deleteById(p);
    }
    public int update(Data p) throws SQLException {
        return getDaoData().update(p);
    }
    public Dao getDaoData() throws SQLException {
        return  simpleDao=getDao(Data.class);
    }


    public RuntimeExceptionDao getDao(){

        return  simpleRuntimeDao= getRuntimeExceptionDao(Data.class);
    }


}
