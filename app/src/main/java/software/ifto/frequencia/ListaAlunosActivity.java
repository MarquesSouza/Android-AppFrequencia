package software.ifto.frequencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import software.ifto.frequencia.DAO.AlunoDao;
import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Aluno;
import software.ifto.frequencia.model.Turma;

public class ListaAlunosActivity extends AppCompatActivity {
        private Turma turma;
        private ListView listaAluno;
        private Aluno aluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        listaAluno = (ListView) findViewById(R.id.lista_alunos);
        Intent intent = getIntent();
        turma = (Turma) intent.getSerializableExtra("turma");
        listaAluno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View turma_s, int i, long l) {
                 aluno = (Aluno) listaAluno.getItemAtPosition(i);
                Intent intetGoFormularioAluno = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                intetGoFormularioAluno.putExtra("turma", turma);
                intetGoFormularioAluno.putExtra("aluno", aluno);
                startActivity(intetGoFormularioAluno);
            }
        });

        carregalista();
        Button novoAluno = (Button) findViewById(R.id.btn_add_aluno);

        novoAluno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentGoFormularioAluno = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                        intentGoFormularioAluno.putExtra("turma", turma);
                        intentGoFormularioAluno.putExtra("aluno", aluno);
                        startActivity(intentGoFormularioAluno);
                    }
                }
        );
        registerForContextMenu(listaAluno);
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregalista();
    }
    private void carregalista(){
        AlunoDao dao = new AlunoDao(this);
         List<Aluno> alunos = dao.busca(turma.getId()); dao.close();

        ArrayAdapter<Aluno> adpter =  new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1 ,alunos);
        listaAluno.setAdapter(adpter);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuContexto = menu.add("deletar");
        menuContexto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno) listaAluno.getItemAtPosition(info.position);
                AlunoDao dao = new AlunoDao(ListaAlunosActivity.this);
                dao.deleta(aluno);
                dao.close();
                carregalista();


                return false;
            }
        });


    }
    }
