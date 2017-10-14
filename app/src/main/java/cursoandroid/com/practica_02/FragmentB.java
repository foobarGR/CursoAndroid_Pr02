package cursoandroid.com.practica_02;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private FragmentB.OnFragmentInteractionListener mListener;


    EditText msj;
    TextView msjR;
    Button send;
    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_b, container, false);

        msjR=(TextView)view.findViewById(R.id.txt_msjInB);
        msj=(EditText)view.findViewById(R.id.txtMsjB);

        send=(Button)view.findViewById(R.id.btnEnviarB);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMsj();
            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener{

        void onFragmentInteraction(Uri uri);


    }

    private void enviarMsj() {
        EventBus.getDefault().post(new MessageEvent(msj.getText().toString(),1));
        msj.setText("");

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
        if(event.getID()!=1){
            msjR.setText(msjR.getText().toString()+event.getMessage()+"\n");
        }
    }
}
