package com.theweatherguy;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.theweatherguy.database.User;
import com.theweatherguy.database.UserDBRepository;

import java.util.List;


public class ProfileFragment extends Fragment {

    private UserDBRepository mUserDBRepository;
    private User mUser;
    private Context context = getContext();
    private TextView profileUsername;
    private TextView profileName;
    private TextView profileSurname;
    private TextView profileMail;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast toast = Toast.makeText(getActivity(), getString(R.string.under_construction), Toast.LENGTH_SHORT);
        toast.show();

        //Inicializo la DB
        mUserDBRepository = UserDBRepository.get(getContext());
        List<User> users = mUserDBRepository.getUser();


        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        ImageButton button = view.findViewById(R.id.button_change_profile_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Probando el On Click Listener", Toast.LENGTH_SHORT);

                toast.show();
            }


        });


        profileUsername = view.findViewById(R.id.profile_username);
        profileName = view.findViewById(R.id.profile_name);
        profileSurname = view.findViewById(R.id.profile_surname);
        profileMail = view.findViewById(R.id.profile_mail);

        if (users.size() > 0) {
            mUser = users.get(0);
            profileUsername.setText(mUser.getUserName());
            profileName.setText(mUser.getUserName());
            profileSurname.setText(mUser.getName());
            profileMail.setText(mUser.getMail());
        }

        Button changeUnsername = view.findViewById(R.id.profile_change_username);
        changeUnsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Cambiar nombre de usuario", Toast.LENGTH_SHORT);
                toast.show();
                changeUserName();
            }


        });

        Button changeName = view.findViewById(R.id.profile_change_name);
        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Cambiar nombre", Toast.LENGTH_SHORT);
                toast.show();
                //changeName();
            }


        });


        Button changeSurname = view.findViewById(R.id.profile_change_surname);
        changeSurname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Cambiar apellido", Toast.LENGTH_SHORT);
                toast.show();
                //changeSurname();
            }


        });

        Button changeMail = view.findViewById(R.id.profile_change_mail);
        changeMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Cambiar mail", Toast.LENGTH_SHORT);
                toast.show();
                //changeMail();
            }


        });


        return view;
    }

    private void changeUserName() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.change_profile_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = promptsView
                .findViewById(R.id.editText_profile_change);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                profileUsername.setText(userInput.getText());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

