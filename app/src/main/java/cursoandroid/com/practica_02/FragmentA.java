package cursoandroid.com.practica_02;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    private OnFragmentInteractionListener mListener;

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

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.mandarMsj(msj.getText().toString());
                msj.setText("");
            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

        void mandarMsj(String msj);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentA.OnFragmentInteractionListener) {
            mListener = (FragmentA.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void actualizarMsj(String msjTxt){

        msjR.setText(msjR.getText()+msjTxt+"\n");
    }
}
