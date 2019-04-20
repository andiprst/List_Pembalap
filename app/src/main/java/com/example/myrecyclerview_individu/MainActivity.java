package com.example.myrecyclerview_individu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.motogp.com.au/sites/default/files/styles/driver_or_rider_profile_medium_up/public/driver-rider/image/profile/Valentino_Rossi_0.jpg");
        mNames.add("Valentino Rossi");
        mDescription.add("Rossi atau yang sering disebut The Doctor merupakan pembalap berkebangsaan Italia," +
                " yang sudah memiliki 9 gelar juara dunia dan 7 kali diantaranya merupakan pada premiere class atau kelas tertinggi MotoGP, " +
                "diumurnya yang 40 ini rossi masih kompetitif dalam persaingan melawan pembalap yang lebih muda hingga sering kali sosoknya disebut living legend.");

        mImageUrls.add("https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/03/11/2925724488.jpg");
        mNames.add("Jorge Lorenzo");
        mDescription.add("Lorenzo adalah pembalap yang baru saja pindah dari Ducati ke Honda, julukannya adalah X-Fuera yang kini sudah memiliki gelar juara 5 kali" +
                "dan 3 diantaranya di kelas premiere atau MotoGP, Lorenzo merupakan pembalap yang kompetitif dalam 3 tahun terakhir," +
                "namun performanya agak menurun saat baru pindah ke Honda.");

        mImageUrls.add("https://cdn.images.dailystar.co.uk/dynamic/213/photos/214000/620x/Marc-Marquez-716267.jpg");
        mNames.add("Marq Marquez");
        mDescription.add("The Babby Alien merupakan julukan dari pembalap yang satu ini. Bergabung di kelas MotoGP pada tahun 2013 membela team repsol honda," +
                "Marquez menjadi pembalap termuda yang mendapatkan gelar juara dunia di kelas MotoGP pada tahun pertama bergabung." +
                "Memang tidak bisa dipungkiri skill yang dimiliki Marquez memang diatas rata-rata, total sudah 5 kali juara dunia diraih oleh Marquez " +
                "di semua kelas MotoGP");

        mImageUrls.add("https://cdns.klimg.com/bola.net/library/upload/21/2018/06/stoner_ada112e.jpg");
        mNames.add("Casey Stoner");
        mDescription.add("Pembalap berkebangsaan Australia ini lahir pada 16 Oktober 1985, memulai karir MotoGp pada tahun 2006 dengan Honda dengan hasil akhir yang" +
                "kurang memuaskan, Stoner lalu pindah ke team Ducati dan mencatat hasil positif hingga mendapatkan gelar juara dunia di tahun pertamanya" +
                "bersama Ducati. Hingga pada tahun 2011 Stoner memutuskan untuk pindah ke Honda lagi dan terbukti dengan meraih juara dunia." +
                "namun pada tahun 2012 Stoner memutuskan untuk pensiun dari MotoGP, sangat disayangkan karena ia masih sangat kompetitif dan masih muda.");

        mImageUrls.add("https://s3-eu-west-1.amazonaws.com/crash.net/styles/medium_article/s3/field/image/47efb232-fdfc-40e7-9ea6-9fe61600e7e6.jpg");
        mNames.add("Nicky Hayden");
        mDescription.add("The Kentucky Kid adalah julukan dari pembalap ini, memulai karirnya pada tahun 2003 bersama Honda di kelas MotoGP" +
                ", hingga akhirnya pada tahun 2006 ia berhasil mendapatkan title juara dunia dengan team" +
                "HRC Honda. Pada tahun 2009 ia pindah ke Ducati namun performanya kalah dari pembalap lain dan mengecewakan, kontraknya bersama ducati hanya bertahan" +
                "hingga 2013, lalu  ia bergabung kembali dengan team satelit Honda. Hingga akhirnya memutuskan pensiun" +
                " pada 2015.");

        mImageUrls.add("https://cdn.newsapi.com.au/image/v1/112264617199a7f85c5f754c6130379a?width=1024");
        mNames.add("Mick Doohan");
        mDescription.add("Lahir pada 4 Juni 1965, Mick Dohhan merupakan pembalap legendaris yang memiliki title juara dunia sebanyak 5 kali berturut-turut pada GP500," +
                "dengan motor NSR500 yaitu pada tahun 1994, 1995, 1996, 1997, 1998. Kariernya terhenti akibat kecelakaan dahsyat di sirkuit Jerez, Spanyol pada tahun 1999, " +
                "setelah absen dari balapan ia tetap berkecimpung dalam dunia balap.");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDescription);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
