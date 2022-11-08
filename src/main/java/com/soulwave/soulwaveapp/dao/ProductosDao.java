package com.soulwave.soulwaveapp.dao;

import com.soulwave.soulwaveapp.models.Stock;
import com.soulwave.soulwaveapp.models.Venta;

import java.util.List;

public interface ProductosDao {

    List<Stock> getStock();
    List<Venta> getVenta(String fechainicio, String fechafin);


}
