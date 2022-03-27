package com.example.dogbreed.viewmodel;

import com.example.dogbreed.model.DogBreed;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DogAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    public Single<List<DogBreed>> getDogs();
}
