package id.ac.polinema.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class segitiga extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.tab_segitiga, container, false);

        final TextView tinggi = root.findViewById(R.id.etTinggiS);
        final TextView alas = root.findViewById(R.id.etAlasS);
        Button hasilS = root.findViewById(R.id.btSegitiga);
        hasilS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTinggi = tinggi.getText().toString();
                String sAlas = alas.getText().toString();
                if (!TextUtils.isEmpty(sAlas) && !TextUtils.isEmpty(sTinggi)) {
                    int A = Integer.parseInt(sAlas);
                    int T = Integer.parseInt(sTinggi);
                    int hasil = A * T / 2;

                    Intent intent = new Intent(getActivity(), HasilActivity.class);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("nama", "Segitiga");
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Alas dan Tinggi wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}