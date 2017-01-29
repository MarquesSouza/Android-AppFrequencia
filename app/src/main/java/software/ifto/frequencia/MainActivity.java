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

import software.ifto.frequencia.DAO.TurmaDao;
import software.ifto.frequencia.model.Turma;

public class MainActivity extends AppCompatActivity {

    private ListView listaTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaTurma = (ListView) findViewById(R.id.lista_turmas);
        listaTurma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View turma_s, int i, long l) {
                Turma turma = (Turma) listaTurma.getItemAtPosition(i);
                Intent intetGoListaAluno= new Intent(MainActivity.this,ListaAlunosActivity.class);
                intetGoListaAluno.putExtra("turma",turma);
                startActivity(intetGoListaAluno);
            }
        });

        carregalista();


        Button novaTurma = (Button) findViewById(R.id.btn_add_turma);

        novaTurma.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentGoFormularioTurma = new Intent(MainActivity.this, FormularioTurmaActivity.class);
                        startActivity(intentGoFormularioTurma);
                    }
                }
        );
        registerForContextMenu(listaTurma);
    }

    private void carregalista(){
        TurmaDao dao = new TurmaDao(this);
        List<Turma> turmas = dao.busca(); dao.close();

        ArrayAdapter<Turma> adpter =  new ArrayAdapter<Turma>(this,android.R.layout.simple_list_item_1 ,turmas);
        listaTurma.setAdapter(adpter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregalista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuContexto =  menu.add("deletar");
        menuContexto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Turma turma = (Turma) listaTurma.getItemAtPosition(info.position);
                TurmaDao dao = new TurmaDao(MainActivity.this);
                dao.deleta(turma);
                dao.close();
                carregalista();


                return false;
            }
        });
        menuContexto =  menu.add("Alterar");
        menuContexto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                return false;
            }
        });

            }
}
