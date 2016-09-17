package com.tcc.tccpinut.tccpinut.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.tcc.tccpinut.tccpinut.classes.Pinut;

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

//    private int pinid;
//    private int ownerid;
//    private Date expireOn;
//    private int privacy;
//    private Date createdOn;
//    private LatLng location;
//    private String imagepath;
//    private String audiopath;


    @NonNull
    private ContentValues getContentValues(Pinut pinut) {
        ContentValues dados = new ContentValues();
        dados.put("PINID", pinut.getPinid());
        dados.put("OWNERID", pinut.getOwnerid());
        dados.put("EXPIREON", pinut.getExpireOn().getTime());
        dados.put("PRIVACY", pinut.getPrivacy());
        dados.put("CREATEDON", pinut.getCreatedOn().getTime());
        // TODO: fazer LatLgn.
        dados.put("IMAGEPATH", pinut.getImagepath());
        dados.put("AUDIOPATH", pinut.getAudiopath());

        return dados;
    }
//
//    public List<Aluno> buscaAlunos() {
//        String sql = "SELECT * FROM ALUNOS";
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor c = db.rawQuery(sql, null);
//
//        List<Aluno> alunos = new ArrayList<Aluno>();
//        Aluno aluno = null;
//        while (c.moveToNext()) {
//            aluno = new Aluno();
//            aluno.set_ID(c.getLong(c.getColumnIndex("ID")));
//            aluno.set_nome(c.getString(c.getColumnIndex("NOME")));
//            aluno.set_endereco(c.getString(c.getColumnIndex("ENDERECO")));
//            aluno.set_telefone(c.getString(c.getColumnIndex("TELEFONE")));
//            aluno.set_site(c.getString(c.getColumnIndex("SITE")));
//            aluno.set_nota(c.getFloat(c.getColumnIndex("NOTA")));
//            aluno.set_caminhoFoto(c.getString(c.getColumnIndex("CAMINHOFOTO")));
//
//            alunos.add(aluno);
//        }
//
//        c.close();
//        return alunos;
//    }
//
//    public void deletar(Aluno aluno) {
//        SQLiteDatabase db = getWritableDatabase();
//        String[] params = {Long.toString(aluno.get_ID())};
//        db.delete("Alunos", "id = ?", params);
//
//    }
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
//    public void altera(Aluno aluno) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues dados = getContentValues(aluno);
//        String[] param = {Long.toString(aluno.get_ID())};
//        db.update("ALUNOS", dados, "ID = ?", param);
//    }

}


