package cursoandroid.com.practica_02;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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
                mListener.enviarMsj(msj.getText().toString());
                msj.setText("");

            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener{

        void onFragmentInteraction(Uri uri);

        void enviarMsj(String msj);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentB.OnFragmentInteractionListener) {
            mListener = (FragmentB.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void actualizarMsj(String msjTxt){

        msjR.setText(msjR.getText()+msjTxt+"\n");
    }
}
