package com.soulwave.soulwaveapp.controllers;

import com.soulwave.soulwaveapp.dao.ProductosDao;
import com.soulwave.soulwaveapp.models.Stock;
import com.soulwave.soulwaveapp.models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductosController {

    @Autowired
    private ProductosDao articulos;

    @RequestMapping(value = "api/stock", method = RequestMethod.GET)
    public List<Stock> getStock(){

        return articulos.getStock();
    }

    @Autowired
    private ProductosDao ventas;

    @RequestMapping(value = "api/ventas", method = RequestMethod.GET)
    public List<Venta> getVenta(@RequestParam("fechainiciovta") String fechainicio,
                                @RequestParam("fechafinvta") String fechafin){

        return ventas.getVenta(fechainicio, fechafin);
    }
}
