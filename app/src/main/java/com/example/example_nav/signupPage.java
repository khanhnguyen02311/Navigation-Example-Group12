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
 * Use the {@link signupPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signupPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public signupPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signupPage.
     */
    // TODO: Rename and change types and number of parameters
    public static signupPage newInstance(String param1, String param2) {
        signupPage fragment = new signupPage();
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
        return inflater.inflate(R.layout.fragment_signup_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button signupBtn = (Button) view.findViewById(R.id.signupBtn);

        EditText Tusr = (EditText) view.findViewById(R.id.usernameText);
        EditText Tpsw = (EditText) view.findViewById(R.id.passwordText);
        EditText ReTpsw = (EditText) view.findViewById(R.id.rePasswordText);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String notification = "";
                String usr = "";
                String psw = "";
                String repsw = "";

                try {
                    usr = Tusr.getText().toString();
                    psw = Tpsw.getText().toString();
                    repsw = ReTpsw.getText().toString();
                }
                catch (Exception e) {
                    notification = e.toString();
                    Snackbar snackbar = Snackbar.make(view, notification, 1000);
                    snackbar.show();
                    return;
                }

                if (usr.length() < 6 || psw.length() < 6 || repsw.length() < 6) {
                    notification = "Information length must be 6 characters or above.";
                    Snackbar snackbar = Snackbar.make(view, notification, 1000);
                    snackbar.show();
                    return;
                }

                else if (!psw.equals(repsw)) {
                    notification = "Two passwords are not identical.";
                    Snackbar snackbar = Snackbar.make(view, notification, 1000);
                    snackbar.show();
                    return;
                }

//                FirebaseDatabase dtb = myDatabase.child("Account").getDatabase();
//
//                Account acc = new Account(usr, psw);
//                myDatabase.child("Account").push().setValue(acc);

                notification = "Sign up complete";
                Snackbar snackbar = Snackbar.make(view, notification, 1000);
                snackbar.show();

                Bundle bundle = new Bundle();
                bundle.putString("username", usr);

                Navigation.findNavController(view).navigate(R.id.action_signupPage_to_welcomePage2, bundle);
                return;

            }
        });
    }
}
