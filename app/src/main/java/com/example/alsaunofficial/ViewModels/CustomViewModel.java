package com.example.alsaunofficial.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.alsaunofficial.API.AlsaHandler;
import com.example.alsaunofficial.API.AlsaService;

public abstract class CustomViewModel extends ViewModel {

    protected AlsaService alsaService;
    protected MutableLiveData<Boolean> isLoading;
    protected MutableLiveData<String> respuesta;
    protected final static String INVALID_RESPONSE = "Respuesta inválida.";
    protected final static String ERROR_RED = "Error de red.";

    public LiveData<Boolean> isLoading() {
        if (isLoading == null) {
            isLoading = new MutableLiveData<>(false);
        }
        return isLoading;
    }

    public LiveData<String> getRespuesta() {
        if (respuesta == null) {
            respuesta = new MutableLiveData<String>();
        }
        return respuesta;
    }

    protected void lazyLoad(boolean cargando) {
        if (isLoading == null) {
            isLoading = new MutableLiveData<>(cargando);
        } else {
            isLoading.setValue(cargando);
        }

        if (respuesta == null) {
            respuesta = new MutableLiveData<String>();
        }

        if (alsaService == null) {
            alsaService = AlsaHandler.getRetrofitInstance().create(AlsaService.class);
        }
    }

    protected void lazyLoad() {
        lazyLoad(true);
    }
}
