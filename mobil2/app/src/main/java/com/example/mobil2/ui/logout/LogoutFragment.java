package com.example.mobil2.ui.logout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobil2.Login;
import com.example.mobil2.R;

public class LogoutFragment extends Fragment {

    private Button logout_btn;

    public LogoutFragment() {
        // Boş yapıcı metod
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        logout_btn = view.findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Burada çıkış işlemlerini gerçekleştir
                performLogout();

                // Kullanıcıyı tekrar giriş sayfasına yönlendir
                redirectToLogin();
            }
        });

        return view;
    }

    private void performLogout() {
        // Burada gerekli çıkış işlemlerini gerçekleştir
        // Örneğin: Oturumu kapat, verileri temizle, vs.
    }

    private void redirectToLogin() {
        // Kullanıcıyı tekrar giriş sayfasına yönlendir
        Intent intent = new Intent(getActivity(), Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }
}