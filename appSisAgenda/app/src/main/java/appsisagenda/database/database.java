package appsisagenda.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
        /* SQLiteOpenHelper: contém os métodos necessários para
    manuseio de banco de dados. */

    private static final String DATABASE_NAME="database.db";
    private static final int DATABASE_Version=1;
    private String contatos="create table if not exists contatos (" +
            "id integer primary key autoincrement," +
            "nome varchar(100)," +
            "email varchar(100)," +
            "celular varchar(14));";
    public database(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_Version);
    }

    @Override
    public void  onCreate(SQLiteDatabase db) {
        db.execSQL(contatos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }
}
