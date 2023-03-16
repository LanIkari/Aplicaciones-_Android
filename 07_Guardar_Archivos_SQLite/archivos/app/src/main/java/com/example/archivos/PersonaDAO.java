package com.example.archivos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PersonaDAO {
        private SQLiteDatabase database;
        private SQLiteOpenHelper dbhelper;

    public PersonaDAO(MainActivity mainActivity) {
    }

    public void open() throws SQLException{
            database = dbhelper.getWritableDatabase();
        }
        public void close(){
            dbhelper.close();
        }
        public long Insertar(String nombre){
            long estado = 0;
            try {
                ContentValues valores = new ContentValues();
                valores.put("nombre", nombre);
                estado = database.insert(com.example.archivos.SQLiteOpenHelper.NOMBRETABLA,null,valores);
            }catch (Exception e)
            {
                estado = 0;
            }
            return estado;
        }
        public long EliminarRegistro(int codigo){
            long estado= 0;
            try {
                estado = database.delete(com.example.archivos.SQLiteOpenHelper.NOMBRETABLA,"codigo=?",
                new String[]{String.valueOf(codigo)});
            }catch (Exception e)
            {
                estado = 0;
            }
            return estado;
        }
        public long ModificarRegistro(String codigo, String nombre){
            long estado = 0;
            try {
                ContentValues valores = new ContentValues();
                valores.put("nombre", nombre);
                estado = database.update(com.example.archivos.SQLiteOpenHelper.NOMBRETABLA,
                        valores,"codigo= "+codigo, null );
            } catch (Exception e){
                estado = 0;
            }
            return estado;
        }
        public ArrayList<Persona> ListadoGeneral(){
        Cursor c;
        ArrayList<Persona> listado = new ArrayList<Persona>();
        c = database.rawQuery("Select * FROM persona", null);
        while (c.moveToNext()){
            Persona objpersona = new Persona();
            objpersona.setCodigo(c.getInt(0));
            objpersona.setNombre(c.getString(1));
            listado.add(objpersona);
        }
        c.close();
        return listado;
    }

}
