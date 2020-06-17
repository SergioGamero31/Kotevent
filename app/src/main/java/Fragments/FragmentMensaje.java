package Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kotevent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class FragmentMensaje extends Fragment {

    EditText memail, mmensaje, masunto;
    Button enviar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mensaje_fragment,container,false);

        memail = view.findViewById(R.id.editEmail);
        masunto = view.findViewById(R.id.editAsunto);
        mmensaje = view.findViewById(R.id.editMessage);
        enviar = view.findViewById(R.id.btnenviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String asunto = masunto.getText().toString().trim();
                String mensaje = mmensaje.getText().toString().trim();

                sendMail(email, asunto, mensaje);
            }
        });
        return view;
    }

    private void sendMail(String email, String asunto, String mensaje) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
        mEmailIntent.setData(Uri.parse("mailto:"));
        mEmailIntent.setType("text/plain");

        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);

        try{
            startActivity(Intent.createChooser(mEmailIntent, "Selecciona un cliente de Email"));

        }catch (Exception e){
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
