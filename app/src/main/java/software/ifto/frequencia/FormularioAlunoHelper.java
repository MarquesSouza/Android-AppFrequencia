package software.ifto.frequencia;

import android.content.Intent;
import android.widget.EditText;

/**
 * Created by Marques de Souza on 28/11/2016.
 */
import java.util.Date;

import software.ifto.frequencia.model.Aluno;
import software.ifto.frequencia.model.Turma;

public class FormularioAlunoHelper {
    private EditText campoNome;
    private EditText campoMatricula;
    private Date campoDataCriacao;
    private Date campoDatoAlteracao;

    private Aluno aluno;
    public FormularioAlunoHelper(FormularioAlunoActivity activity)
    {
        campoNome = (EditText) activity.findViewById(R.id.nome);
        campoMatricula= (EditText) activity.findViewById(R.id.matricula);
        campoDataCriacao = new Date();
        campoDatoAlteracao= new Date();

        aluno=new Aluno();


    }
    public Aluno pegaAluno(){
        aluno.setNome(campoNome.getText().toString());
        aluno.setMatricula(campoMatricula.getText().toString());
        aluno.setDataCriacao(campoDataCriacao);
        aluno.setDataAlteracao(campoDatoAlteracao);
        return aluno;
    }
    public void preencheFormulario(Aluno aluno){
        campoNome.setText(aluno.getNome());
        campoMatricula.setText(aluno.getMatricula());
        this.aluno=aluno;
    }

}
