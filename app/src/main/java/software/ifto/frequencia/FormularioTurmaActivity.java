package software.ifto.frequencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Turma;


public class FormularioTurmaActivity extends AppCompatActivity {

    private FormularioTurmaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_turma);

        helper = new FormularioTurmaHelper(this);

        Intent intente = getIntent();
        Turma turma = (Turma) intente.getSerializableExtra("turma");
        if(turma != null){
            helper.preencheFormulario(turma);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_turma, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Turma turma = helper.pegaTurma();
                TurmaDao dao = new TurmaDao(this);

                if(turma.getId() != null){
                    dao.altera(turma);
                    Toast.makeText(FormularioTurmaActivity.this, "Turma "+turma.getDescricao()+" alterada!", Toast.LENGTH_SHORT).show();
                }
                else {
                    dao.insere(turma);
                    Toast.makeText(FormularioTurmaActivity.this, "Turma "+turma.getDescricao()+" adicionada!", Toast.LENGTH_SHORT).show();
                }
                dao.close();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
