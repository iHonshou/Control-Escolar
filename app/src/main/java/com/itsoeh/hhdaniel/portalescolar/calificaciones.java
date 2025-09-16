package com.itsoeh.hhdaniel.portalescolar;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calificaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calificaciones extends Fragment {

    private Spinner spnAsig, spnDocente, spnAlumno;

    private EditText txtNota;

    private Button btnHora;

    private FloatingActionButton fbtGuardar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calificaciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calificaciones.
     */
    // TODO: Rename and change types and number of parameters
    public static calificaciones newInstance(String param1, String param2) {
        calificaciones fragment = new calificaciones();
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
        return inflater.inflate(R.layout.fragment_calificaciones, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        linkComponents(view);
        setListeners(view);

    }

    private void linkComponents(View view) {

        spnAlumno = view.findViewById(R.id.form_spnalumno);
        spnDocente = view.findViewById(R.id.form_spndoce);
        spnAsig = view.findViewById(R.id.form_spnasig);
        txtNota = view.findViewById(R.id.form_txtcal);
        btnHora = view.findViewById(R.id.form_btnhora);
        fbtGuardar = view.findViewById(R.id.form1_fbtguardar);

    }

    private void setListeners(View view) {

        fbtGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicHora(view);
            }
        });

    }

    private void guardar() {
        String alumno = spnAlumno.getSelectedItem().toString();
        String docente = spnDocente.getSelectedItem().toString();
        String asignatura = spnAsig.getSelectedItem().toString();
        String nota = txtNota.getText().toString();
        String hora = btnHora.getText().toString();

        String datos =
                "*DATOS ASIGNATURA*\n" +
                        "Alumno: " + alumno + "\n" +
                        "Docente: " + docente + "\n" +
                        "Asignatura: " + asignatura + "\n" +
                        "Calificación: " + nota + "\n" +
                        "Hora de calificado: " + hora + "\n" +
                        "****************";

        CuadroDialogo dialogo = new CuadroDialogo(this.getContext());
        dialogo.setInfo(datos);
        limpiarCampos();

    }

    private void limpiarCampos(){
        spnAlumno.setSelection(0);
        spnDocente.setSelection(0);
        spnAsig.setSelection(0);
        txtNota.setText("");
    }

    private void clicHora(View view){

        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this.getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                btnHora.setText(hora + ":" + minuto);
            }
        }, hora, minuto, true);

        timePickerDialog.show();

        }

    }