package com.itsoeh.hhdaniel.portalescolar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link asignaturas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class asignaturas extends Fragment {

    private EditText txtClave, txtNombre;
    private Spinner spnGrado, spnCarrera;
    private RadioButton rdbCurricular, rdbOptativa, rdbExtracurricular;
    private FloatingActionButton fbtGuardar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public asignaturas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment asignaturas.
     */
    // TODO: Rename and change types and number of parameters
    public static asignaturas newInstance(String param1, String param2) {
        asignaturas fragment = new asignaturas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asignaturas, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        linkComponents(view);
        setListeners(view);

    }

    private void linkComponents(View view) {

        txtClave = view.findViewById(R.id.form1_txtmat);
        txtNombre = view.findViewById(R.id.form1_txtnom);
        spnGrado = view.findViewById(R.id.form1_spngrado);
        spnCarrera = view.findViewById(R.id.form1_spncarrera);
        rdbCurricular = view.findViewById(R.id.form1_rdbcurr);
        rdbOptativa = view.findViewById(R.id.form1_rdbopt);
        rdbExtracurricular = view.findViewById(R.id.form1_rdbextra);
        fbtGuardar = view.findViewById(R.id.form1_fbtguardar);

    }

    private void setListeners(View view) {

        fbtGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarAsignatura(view);
            }
        });

    }

    private void guardarAsignatura(View view) {

        String clave = txtClave.getText().toString();
        String nombre = txtNombre.getText().toString();
        String grado = spnGrado.getSelectedItem().toString();
        String carrera = spnCarrera.getSelectedItem().toString();
        String tipo = "";
        if (rdbCurricular.isChecked()) {
            tipo = "Curricular";
        } else if (rdbOptativa.isChecked()) {
            tipo = "Optativa";
        } else if (rdbExtracurricular.isChecked()) {
            tipo = "Extracurricular";
        }
            String datos =
                    "*DATOS ASIGNATURA*\n" +
                            "Clave: " + clave + "\n" +
                            "Nombre: " + nombre + "\n" +
                            "Grado: " + grado + "\n" +
                            "Carrera: " + carrera + "\n" +
                            "Tipo: " + tipo + "\n" +
                            "****************";

            CuadroDialogo dialogo = new CuadroDialogo(this.getContext());
            dialogo.setInfo(datos);
            limpiarCampos();

        }

    private void limpiarCampos() {
        txtClave.setText("");
        txtNombre.setText("");
        spnGrado.setSelection(0);
        spnCarrera.setSelection(0);
        rdbCurricular.setChecked(false);
        rdbOptativa.setChecked(false);
        rdbExtracurricular.setChecked(false);
    }

}