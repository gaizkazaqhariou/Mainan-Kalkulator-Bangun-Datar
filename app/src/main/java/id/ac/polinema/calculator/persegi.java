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

public class persegi extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.tab_persegi, container, false);

        final TextView panjang = root.findViewById(R.id.etPanjangP);
        final TextView lebar = root.findViewById(R.id.etLebarP);
        Button hasilP = root.findViewById(R.id.btPersegi);
        hasilP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pPanjang = panjang.getText().toString();
                String pLebar = lebar.getText().toString();
                if (!TextUtils.isEmpty(pLebar) && !TextUtils.isEmpty(pPanjang)) {
                    int L = Integer.parseInt(pLebar);
                    int P = Integer.parseInt(pPanjang);
                    int hasil = L * P;

                    Intent intent = new Intent(getActivity(), HasilActivity.class);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("nama", "Persegi");
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Panjang dan Lebar wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}