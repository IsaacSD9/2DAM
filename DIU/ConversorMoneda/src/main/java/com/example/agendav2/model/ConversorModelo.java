package com.example.agendav2.model;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.MonedaRepository;
import com.example.agendav2.Moneda;
import com.example.agendav2.util.MonedaUtil;

import java.util.ArrayList;

public class ConversorModelo {

  private MonedaRepository monedaRepository; //Esta es la dependencia de ConversorModelo con MonedaRepository
    ArrayList<MonedaVO> monedas = new ArrayList<>();

    public void setMonedaRepository(MonedaRepository monedaRepository)  throws ExcepcionMoneda{
        this.monedaRepository = monedaRepository;
    }


    public ArrayList<Moneda> setMonedas() throws ExcepcionMoneda {
        monedas= monedaRepository.ObtenerListaMonedas();
        return MonedaUtil.parse(monedas);
    }

    public float cambioMoneda(float euros, float multiplicador) {

        return euros*multiplicador;
    }
}
