package com.example.workdayapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workdayapp.networking.response.SearchResponse
import com.example.workdayapp.networking.retrofit.NasaApiService
import com.example.workdayapp.networking.retrofit.NasaRetrofit
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private val api = NasaRetrofit.getRetrofitInstance().create(NasaApiService::class.java)

    private val _images = MutableLiveData<List<NasaImageInfo>>()
    val images: LiveData<List<NasaImageInfo>> = _images

    private val _filteredImages = MutableLiveData<List<NasaImageInfo>>()
    val filteredImages: LiveData<List<NasaImageInfo>> = _filteredImages

    fun fetchData() {
        viewModelScope.launch {
            // fetch data from network
            api.searchImages("mars").enqueue(object : Callback<SearchResponse> {
                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    if (response.isSuccessful) {
                        val data: SearchResponse? = response.body()
                        // Do something with the data
                        val imageInfoList: List<NasaImageInfo> = data?.collection?.items?.map {
                            NasaImageInfo(
                                imageUrl = it.links?.firstOrNull()?.href,
                                title = it.data?.firstOrNull()?.title
                            )
                        } ?: emptyList()
                        _images.postValue(imageInfoList)
                    } else {
                        // Handle error
                    }
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }

    fun filterList(query: String?) {
        if (query != null) {

            val filteredData = _images.value?.filter {
                it.title?.toLowerCase()?.contains(query.toLowerCase()) == true
            } ?: emptyList()

            if (filteredData.isEmpty()) {

            } else {
                _filteredImages.postValue(filteredData)
            }

        }
    }

}

