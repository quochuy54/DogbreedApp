package com.example.dogbreed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.dogbreed.databinding.ActivityMainBinding;
import com.example.dogbreed.model.DogBreed;
import com.example.dogbreed.view.DogAdapter;
import com.example.dogbreed.viewmodel.DogAPIServices;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private List<DogBreed> dogBreedList;
    private DogAdapter dogBreedArrayAdapter;
    ActivityMainBinding binding;
    DogAPIServices dogAPIServices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dogBreedList = new ArrayList<DogBreed>();
        dogBreedArrayAdapter = new DogAdapter(dogBreedList);
        binding.rvDogbreed.setAdapter(dogBreedArrayAdapter);


        dogAPIServices = new DogAPIServices();
        dogAPIServices.getDogs()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                            @Override
                            public void onSuccess(@NonNull List<DogBreed> dogBreeds) {
                                dogBreedList.addAll(dogBreeds);
                                dogBreedArrayAdapter.notifyDataSetChanged();

//                                for(DogBreed dog : dogBreeds){
//                                    Log.d("Debug1", dog.getUrl());
//                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                    Log.d("Debug1", e.getMessage());
                            }
                        });

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        binding.rvDogbreed.setLayoutManager(layoutManager);
    }
}