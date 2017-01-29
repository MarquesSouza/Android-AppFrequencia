package software.ifto.frequencia.DAO;

/**
 * Created by Marques de Souza on 26/11/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import software.ifto.frequencia.model.Aluno;
import software.ifto.frequencia.model.Turma;

public class AlunoDao extends SQLiteOpenHelper{
    public AlunoDao(Context context){ super(context,"Frequencia- aluno",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE Alunos(id INTEGER PRIMARY KEY,idTurma INTEGER NOT NULL ,nome TEXT NOT NULL,matricula TEXT NOT NULL,data_criacao DATETIME NOT NULL,data_alteracao DATETIME NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
        }
    public void insere(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesAluno(aluno);
        db.insert("Alunos",null,dados);
    }
    @NonNull
    private ContentValues getContentValuesAluno(Aluno aluno){
        ContentValues dados= new ContentValues();
        dados.put("nome",aluno.getNome());
        dados.put("matricula",aluno.getMatricula());
        dados.put("idTurma",aluno.getIdTurma());
        dados.put("data_alteracao",aluno.getDataAlteracao().toString());
        dados.put("data_criacao",aluno.getDataCriacao().toString());
        return dados;
    }

    public List<Aluno> busca(Integer idTurma){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM Alunos where idTurma="+idTurma+";";
        Cursor c = db.rawQuery(sql, null);

        List<Aluno> alunos= new ArrayList<Aluno>();
        while (c.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setId(c.getInt(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setMatricula(c.getString(c.getColumnIndex("matricula")));
            aluno.setIdTurma(c.getInt(c.getColumnIndex("idTurma")));
            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }

    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {aluno.getId().toString()};
        db.delete("Alunos", "id = ?", params);
    }

    public void altera(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValuesAluno(aluno);
        String[] params = {aluno.getId().toString()};
        db.update("Alunos", dados, "id = ?", params);
    }

}
