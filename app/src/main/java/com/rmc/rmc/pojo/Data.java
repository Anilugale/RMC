package com.rmc.rmc.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**

  Created by AnilU on 08-05-2015.
 */

@DatabaseTable(tableName = "Data")
public class Data {

    public Data() {
        this.id = 0;
        this.data="";
    }

    public Data(String data) {
        this.data = data;
    }

    @DatabaseField(generatedId = true)
    int id ;
    @DatabaseField
    String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
