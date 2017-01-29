package software.ifto.frequencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import software.ifto.frequencia.DAO.AlunoDao;
import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Aluno;
import software.ifto.frequencia.model.Turma;

public class FormularioAlunoActivity extends AppCompatActivity {
    private FormularioAlunoHelper helper;
    private Aluno aluno;
    private Turma turma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        helper=new FormularioAlunoHelper(this);
        Intent intent=getIntent();
        aluno=(Aluno)intent.getSerializableExtra("aluno");
        turma=(Turma)intent.getSerializableExtra("turma");
        if(aluno!=null){
            helper.preencheFormulario(aluno);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_aluno, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Aluno aluno = helper.pegaAluno();
                AlunoDao dao = new AlunoDao(this);

                if(aluno.getId() != null){
                    dao.altera(aluno);
                    Toast.makeText(FormularioAlunoActivity.this, "Aluno "+aluno.getNome()+" alterado!", Toast.LENGTH_SHORT).show();
                }
                else {
                    aluno.setIdTurma(turma.getId());
                    dao.insere(aluno);
                    Toast.makeText(FormularioAlunoActivity.this, "Aluno "+aluno.getNome()+" adicionada!", Toast.LENGTH_SHORT).show();
                }
                dao.close();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
