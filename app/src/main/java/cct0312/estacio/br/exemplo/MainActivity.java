package cct0312.estacio.br.exemplo;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;
    EditText edtNome;
    Button btnOK;
    RadioGroup rgSexo;
    String sexo;
    CheckBox ckFutebol, ckCinema, ckCulinaria;
    Switch swAtivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (TextView) findViewById(R.id.txtNome);

        edtNome = (EditText) findViewById(R.id.edtNome);

        rgSexo = (RadioGroup) findViewById(R.id.rdSexo);
        rgSexo.check(R.id.feminino);
        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.feminino: sexo = "Feminino"; break;
                    case R.id.masculino: sexo = "Masculino"; break;
                }

            }
        });

        ckFutebol = (CheckBox) findViewById(R.id.ckFutebol);
        ckFutebol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this,
                            "Futebol foi selecionado",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
        ckCinema = (CheckBox) findViewById(R.id.ckCinema);
        ckCulinaria = (CheckBox) findViewById(R.id.ckCulinaria);
        ckCulinaria.setChecked(true);
        swAtivo = (Switch) findViewById(R.id.swAtivo);
        swAtivo.setChecked(true);


        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNome.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "O campo nome é obrigatório.", Toast.LENGTH_SHORT).show();
                    edtNome.requestFocus();
                    return;
                }
                if (rgSexo.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this,
                            "O campo sexo é obrigatório.", Toast.LENGTH_SHORT).show();
                    rgSexo.requestFocus();
                    return;
                }
                Toast.makeText(MainActivity.this,
                        String.format("O nome do aluno é %s e seu sexo é %s.",
                                edtNome.getText().toString(), sexo),
                        Toast.LENGTH_LONG
                ).show();

                if (ckFutebol.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            String.format("O aluno é %s gosta de %s.",
                                    edtNome.getText().toString(), ckFutebol.getText().toString()),
                            Toast.LENGTH_LONG
                    ).show();
                }
                if (swAtivo.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "O aluno esta ativo.",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
}
