package software.ifto.frequencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
