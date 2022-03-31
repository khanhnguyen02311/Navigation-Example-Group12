package com.example.example_nav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link signinPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signinPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public signinPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signinPage.
     */
    // TODO: Rename and change types and number of parameters
    public static signinPage newInstance(String param1, String param2) {
        signinPage fragment = new signinPage();
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
        return inflater.inflate(R.layout.fragment_signin_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText usr = view.findViewById(R.id.usernameText);
        EditText psw = view.findViewById(R.id.passwordText);

        Button btn = (Button) view.findViewById(R.id.signupBtn);

        Bundle bundle = new Bundle();
        bundle.putString("username", "no-name");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usr.getText().toString().equals("123456") && psw.getText().toString().equals("123456")) {
                    Snackbar snackbar = Snackbar.make(view, "Sign in completed.", 1000);
                    snackbar.show();
                    Navigation.findNavController(view).navigate(R.id.action_signinPage_to_welcomePage, bundle);
                }

                else {
                    Snackbar snackbar = Snackbar.make(view, "Wrong username or account.", 1000);
                    snackbar.show();
                }
            }
        });
    }
}