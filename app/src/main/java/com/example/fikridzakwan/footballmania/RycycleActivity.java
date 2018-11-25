package com.example.fikridzakwan.footballmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
RycycleActivity extends AppCompatActivity {

    // TODO 1 Megenerate butterknife untuk rcyclerview
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    String[] namaClub,detailClub;
    int[] gambarClub;
    // TODO 2 MEmbuat variable array untuk menapung data nama, detail dan gambar dari
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rycycle);
        ButterKnife.bind(this);

        // TODO 3 Mengisi variable array
        namaClub = getResources().getStringArray(R.array.club_name);
        detailClub = getResources().getStringArray(R.array.club_detail);
        gambarClub = new int[]{R.drawable.img_barca, R.drawable.img_madrid, R.drawable.img_bayern
        , R.drawable.img_city, R.drawable.img_mu, R.drawable.img_chelsea, R.drawable.img_acm,
        R.drawable.img_arsenal};

        // TODO 4 Membuat Object adaptor dan mengirim data nama,detail,dan gambar ke adapter
        Adaptor adaptor = new Adaptor(RycycleActivity.this, gambarClub, namaClub, detailClub);
        // TODO 5 Mensetting recyclerview dan mengeset recyclerview dengan adapter
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RycycleActivity.this));
        myRecyclerView.setAdapter(adaptor);
    }
}
