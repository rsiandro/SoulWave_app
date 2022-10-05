package com.soulwave.soulwaveapp.controllers;

import com.soulwave.soulwaveapp.dao.CajaDao;
import com.soulwave.soulwaveapp.models.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CajaController {

    @Autowired
    private CajaDao movimientos;

    @RequestMapping(value = "api/movimientos", method = RequestMethod.GET)
    public List<Movimiento> getMovimientos(@RequestParam("fechainiciomov") String fechainicio,
                                           @RequestParam("fechafinmov") String fechafin) {

        return movimientos.getMovimientos(fechainicio, fechafin);
    }

    @Autowired
    private CajaDao balance;

    @RequestMapping(value = "api/balance", method = RequestMethod.GET)
    public List<Movimiento> getMovimientosBal(@RequestParam("fechainiciobal") String fechainiciobal,
                                              @RequestParam("fechafinbal") String fechafinbal,
                                              @RequestParam("inEfectivo") boolean inEfectivo,
                                              @RequestParam("inTarjeta") boolean inTarjeta,
                                              @RequestParam("inTransferencia") boolean inTransferencia,
                                              @RequestParam("inMercadoPago") boolean inMercadoPago,
                                              @RequestParam("egEfectivo") boolean egEfectivo,
                                              @RequestParam("egCheques") boolean egCheques,
                                              @RequestParam("egTransferencia") boolean egTransferencia,
                                              @RequestParam("egIVA") boolean egIVA,
                                              @RequestParam("egDepositos") boolean egDepositos) {


        return balance.getMovimientosBal(fechainiciobal, fechafinbal, inEfectivo, inTarjeta, inTransferencia, inMercadoPago, egEfectivo, egCheques, egTransferencia, egIVA, egDepositos);
    }


}
