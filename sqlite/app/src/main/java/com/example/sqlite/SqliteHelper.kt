package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class SqliteHelper(context: Context) : SQLiteOpenHelper(context, db_name, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $table_name(ID INTEGER PRIMARY KEY AUTOINCREMENT, s_title TEXT, s_desc Text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $table_name")
    }

    val getData : Cursor get() {
        val db = this.writableDatabase
        var data = db.rawQuery("select * from "+ table_name, null)

        return data
    }

    fun addData(title_text: String, desc_text: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(title, title_text)
        values.put(desc, desc_text)

        db.insert(table_name, null, values)

    }

    fun deleteData(id: String) : Int {
        val db = this.writableDatabase

        val item = db.delete(table_name, "id=?", arrayOf(id))

        return item
    }




    companion object {
        val db_name = "subjects.db "
        val table_name = "subjects "
        val id = "ID"
        val title = "s_title"
        val desc = "s_desc"
    }
}