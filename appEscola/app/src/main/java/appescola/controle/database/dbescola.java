package appescola.controle.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbescola extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="dbescola.db";
    private static final int DATABASE_Version=1;
    private String alunos="create table if not exists alunos (" +
            "id integer primary key autoincrement," +
            "nome varchar(100)," +
            "ra varchar(10)," +
            "email varchar(150));";
    public dbescola(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(alunos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }
}
