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


public class bujur extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.tab_bujur, container, false);

        final TextView panjang = root.findViewById(R.id.etPanjang);
        final TextView lebar = root.findViewById(R.id.etLebar);
        Button hasilB = root.findViewById(R.id.btBujur);
        hasilB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bujurpanjang = panjang.getText().toString();
                String bujurlebar = lebar.getText().toString();
                if (!TextUtils.isEmpty(bujurlebar) && !TextUtils.isEmpty(bujurpanjang)) {
                    int L = Integer.parseInt(bujurlebar);
                    int P = Integer.parseInt(bujurpanjang);
                    int hasil = L * P / 2;

                    Intent intent = new Intent(getActivity(), HasilActivity.class);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("nama", "Bujur Sangkar");
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Panjang dan Lebar wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

}
