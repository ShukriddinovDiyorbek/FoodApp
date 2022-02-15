package uz.pdp.foodapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.pdp.foodapp.model.Meal
import uz.pdp.foodapp.utils.Constant

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.TITLE} text not null, ${Constant.PRODUCT} text not null,${Constant.TARTIB} text not null);"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table  if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }
    fun addMeal(meal: Meal){
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.TITLE, meal.name)
        contentValues.put(Constant.PRODUCT, meal.product)
        contentValues.put(Constant.TARTIB, meal.tarib)
        database.insert(Constant.TABLE_NAME, null,contentValues)
        database.close()
    }
    fun getAllMeals(): ArrayList<Meal>{
        val meals = ArrayList<Meal>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val title = cursor.getString(1)
                val product = cursor.getString(2)
                val tartib = cursor.getString(3)
                meals.add(Meal(title,product,tartib))
            } while (cursor.moveToNext())
        }
        return meals
    }
}