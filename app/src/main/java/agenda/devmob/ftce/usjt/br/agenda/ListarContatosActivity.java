package agenda.devmob.ftce.usjt.br.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarContatosActivity extends Activity {
    public static final String CONTATO = "br.usjt.deswebmob.agenda";
    ArrayList<String> contatos;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contatos);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.Fila);
        ArrayList<String> contatos = buscarContatos(nomeFila);
        listView = (ListView) findViewById(R.id.Listar_contatos);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.r.layout.simple_list_item_1, contatos);
        listView.setAdapter(adapter);
        contexto = this;

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String contato = contatos.get(position);
                        Intent intent1 = new Intent(contexto, DetalheContatoActivity.class);
                        intent1.putExtra(CONTATO, contato);
                        startActivity(intent1);
                    }
                }
        );
    }

    private ArrayList<String> buscarContatos(String chave) {
        ArrayList<String> lista = geraListaContatos();
        if (chave == null || chave.length()== 0) {
            return lista;
        }
        ArrayList<String> resultado = new ArrayList<>();
        {
            for (String contato : lista) {
                if (contato.toUpperCase().contains(chave.toUpperCase())) {
                    resultado.add(contato);
                }
            }
        }
        return lista;
    }

    private ArrayList<String> geraListaContatos() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Pedro1");
        lista.add("Pedro2");
        lista.add("Pedro3");
        lista.add("Pedro4");
        lista.add("Pedro5");
        lista.add("Pedro6");
        lista.add("Pedro7");
        lista.add("Pedro8");
        lista.add("Pedro9");
        lista.add("Pedro10");
        lista.add("Pedro11");
        lista.add("Pedro12");
        lista.add("Pedro13");
        lista.add("Pedro14");
        lista.add("Pedro15");
        lista.add("Pedro16");
        lista.add("Pedro17");
        lista.add("Pedro18");
        lista.add("Pedro19");
        lista.add("Pedro20");
        lista.add("Pedro21");
        lista.add("Pedro22");
        lista.add("Pedro23");
        lista.add("Pedro24");
        return lista;
    }
}



