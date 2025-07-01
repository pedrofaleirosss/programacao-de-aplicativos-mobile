package appvendas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbvendas extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbvendas.db";
    private static final int DATABASE_VERSION = 1;
    private String clientes = "create table if not exists clientes " +
            " (id integer primary key autoincrement, " +
            " nome varchar(40), " +
            " cpf varchar(14), " +
            " celular varchar(14), " +
            " numero varchar(8), " +
            " complemento varchar(20), " +
            " fkend integer, " +
            " FOREIGN KEY(fkend) REFERENCES enderecos(id)); ";
    private String enderecos = "create table if not exists enderecos " +
            " (id integer primary key autoincrement, " +
            " cep varchar(9), " +
            " rua varchar(50), " +
            " bairro varchar(30), " +
            " cidade varchar(30), " +
            " uf varchar(2)); ";
    public dbvendas(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(clientes);
        db.execSQL(enderecos);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        
    }
}
