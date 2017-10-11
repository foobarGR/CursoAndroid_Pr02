package cursoandroid.com.practica_02;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fragment A cargado desde XML

        show_fragmentB();

    }


    private void show_fragmentB(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_b,new FragmentB())
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //ENVIAR MENSAJE B-->A
    @Override
    public void mandarMsj(String msj) {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        FragmentB fb=(FragmentB)getSupportFragmentManager().findFragmentById(R.id.content_b);
        fb.actualizarMsj(msj);


    }


    //ENVIAR MENSAJE A--> B
    @Override
    public void enviarMsj(String msj) {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        FragmentA fa=(FragmentA)getSupportFragmentManager().findFragmentById(R.id.content_a);
        fa.actualizarMsj(msj);
    }
}
