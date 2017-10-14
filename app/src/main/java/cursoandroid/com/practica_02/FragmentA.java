package cursoandroid.com.practica_02;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {


   private Button btnSend;
   private EditText msj;
   private TextView msjR;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_a, container, false);

        btnSend=(Button)view.findViewById(R.id.btnEnviar);
        msjR=(TextView) view.findViewById(R.id.txt_msjInA) ;
        msj=(EditText)view.findViewById(R.id.txtMsjA);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMsj();
                msj.setText("");
            }
        });
    }


    private void enviarMsj() {
        EventBus.getDefault().post(new MessageEvent(msj.getText().toString(),2));
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);


    }


    @Override
    public void onStart(){
        super.onStart();
        //REGISTRANDO FRAGMENTOB AL BUS (EVENTBUS)
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop(){
        super.onStop();
        //DESREGISTRANDO FRAGMENTOB DEL BUS (EVENTBUS)
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event){
        if(event.getID()!=2){
            msjR.setText(msjR.getText().toString()+event.getMessage()+"\n");
        }    }

}
