package com.tcc.tccpinut.tccpinut.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.tcc.tccpinut.tccpinut.classes.Pinut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muffinmad on 17/09/2016.
 */
public class PinutDAO extends DBControl{

    public PinutDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void insert(Pinut pinut) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(pinut);
        db.insert("ALUNOS", null, dados);
    }

    @NonNull
    private ContentValues getContentValues(Pinut pinut) {
        ContentValues dados = new ContentValues();
        dados.put("PINID", pinut.getPinid());
        dados.put("OWNERID", pinut.getOwnerid());
        dados.put("EXPIREON", pinut.getExpireOn().getTime());
        dados.put("PRIVACY", pinut.getPrivacy());
        dados.put("CREATEDON", pinut.getCreatedOn().getTime());
        dados.put("LATITUDE", pinut.getLocation().latitude);
        dados.put("LONGITUDE", pinut.getLocation().longitude);
        dados.put("IMAGEPATH", pinut.getImagepath());
        dados.put("AUDIOPATH", pinut.getAudiopath());

        return dados;
    }

    public void deletar(Pinut pinut) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Long.toString(pinut.getPinid())};
        db.delete("PINUTS", "PINID = ?", params);

    }


    public void altera(Pinut pinut) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(pinut);
        String[] param = {Long.toString(pinut.getPinid())};
        db.update("ALUNOS", dados, "ID = ?", param);
    }

    public List<Pinut> buscaAlunos() {
        String sql = "SELECT * FROM ALUNOS";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Pinut> pinuts = new ArrayList<Pinut>();
        Pinut pinut = null;
        while (c.moveToNext()) {
            pinut = new Pinut();
            pinut.setPinid(c.getInt(c.getColumnIndex("PINID")));
            pinut.setOwnerid(c.getInt(c.getColumnIndex("OWNERID")));
            pinut.setExpireOn(c.getLong(c.getColumnIndex("EXPIREON")));
            pinut.setPrivacy(c.getInt(c.getColumnIndex("PRIVACY")));
            pinut.setCreatedOn(c.getLong(c.getColumnIndex("CREATEDON")));
            pinut.setLocation(c.getDouble(c.getColumnIndex("LATITUDE")),c.getDouble(c.getColumnIndex("LONGITUDE")));
            pinut.setImagepath(c.getString(c.getColumnIndex("IMAGEPATH")));
            pinut.setAudiopath(c.getString(c.getColumnIndex("AUDIOPATH")));

            pinuts.add(pinut);
        }

        c.close();
        return pinuts;
    }


//
//    public boolean isAluno(String telefone){
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TELEFONE FROM ALUNOS WHERE TELEFONE = ?", new String[]{telefone});
//        int res = cursor.getCount();
//        cursor.close();
//        if (res > 0)
//        {
//            return true;
//        }
//        return false;
//    }
//


}


