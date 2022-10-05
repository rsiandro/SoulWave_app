package com.soulwave.soulwaveapp.dao;

import com.soulwave.soulwaveapp.models.Movimiento;

import java.util.List;

public interface CajaDao {
    List<Movimiento> getMovimientos(String fechainicio, String fechafin);

    List<Movimiento> getMovimientosBal(String fechainiciobal, String fechafinbal, boolean inEfectivo, boolean inTarjeta, boolean inTransferencia, boolean inMercadoPago, boolean egEfectivo, boolean egCheques, boolean egTransferencia, boolean egIVA, boolean egDepositos);

}
