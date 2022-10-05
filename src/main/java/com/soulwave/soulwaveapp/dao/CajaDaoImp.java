package com.soulwave.soulwaveapp.dao;

import com.soulwave.soulwaveapp.models.Movimiento;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CajaDaoImp implements CajaDao {

    @PersistenceContext
    EntityManager entityManagerMov;

    @Transactional
    public List<Movimiento> getMovimientos(String fechainicio, String fechafin) {

        String query1 = "FROM Movimiento WHERE fechayhora between '";
        String query2 = "' AND '";
        String query3 = "'";
        String query = query1+fechainicio+" 00:00"+query2+fechafin+" 23:59"+query3;

        return entityManagerMov.createQuery(query).getResultList();

    }

    @PersistenceContext
    EntityManager entityManagerBal;
    @Transactional
    public List<Movimiento> getMovimientosBal(String fechainiciobal, String fechafinbal, boolean inEfectivo,
                                              boolean inTarjeta, boolean inTransferencia, boolean inMercadoPago,
                                              boolean egEfectivo, boolean egCheques, boolean egTransferencia,
                                              boolean egIVA, boolean egDepositos) {

        String inEfectivoMedio = "";
        String inTarjetaMedio = "";
        String inTransferenciaMedio  = "";
        String inMPMedio = "";
        String egEfectivoMedio = "";
        String egChequesMedio = "";
        String egTransferenciaMedio = "";
        String egIVAMedio = "";
        String egDepositosMedio = "";

        if (inEfectivo==true){inEfectivoMedio = "id_med = '1'";}
        if (inTarjeta==true){inTarjetaMedio = "id_med = '2'";}
        if (inTransferencia==true){inTransferenciaMedio = "id_med = '4'";}
        if (inMercadoPago==true){inMPMedio = "id_med = '6'";}
        if (egEfectivo==true){egEfectivoMedio = "id_med = '1'";}
        if (egCheques==true){egChequesMedio = "id_med = '7'";}
        if (egTransferencia==true){egTransferenciaMedio = "id_med = '4'";}
        if (egIVA==true){egIVAMedio = "id_med = '8'";}
        if (egDepositos==true){egDepositosMedio = "id_med = '9'";}

        String query1 = "FROM Movimiento WHERE fechayhora between '";
        String query2 = "' AND '";
        String query3 = "'";
        String queryFecha = query1+fechainiciobal+" 00:00"+query2+fechafinbal+" 23:59"+query3;

        String queryTipo = "";

        if (inEfectivo==true || inTarjeta==true || inTransferencia==true || inMercadoPago==true){
            queryTipo = "tipo = 'ingreso'";
        } else if (egEfectivo==true || egCheques==true || egTransferencia==true || egIVA==true || egDepositos==true){
            queryTipo = "tipo = 'egreso'";
        } else {
            queryTipo = "tipo = 'ingreso' OR tipo = 'egreso'";
        }

        String queryMedio= "";

        if (inEfectivo==true){queryMedio = " AND "+ inEfectivoMedio;}
        if (inTarjeta==true){queryMedio = queryMedio + " AND " + inTarjetaMedio;}
        if (inTransferencia==true){queryMedio = queryMedio + " AND " + inTransferenciaMedio;}
        if (inMercadoPago==true){queryMedio = queryMedio + " AND " + inMPMedio;}
        if (egEfectivo==true){queryMedio = queryMedio + " AND " + egEfectivoMedio;}
        if (egCheques==true){queryMedio = queryMedio + " AND " + egChequesMedio;}
        if (egTransferencia==true){queryMedio = queryMedio + " AND " + egTransferenciaMedio;}
        if (egIVA==true){queryMedio = queryMedio + " AND " + egIVAMedio;}
        if (egDepositos==true){queryMedio = queryMedio + " AND " + egDepositosMedio;}

        String query = queryFecha + "AND" + queryTipo + queryMedio;

        return entityManagerBal.createQuery(query).getResultList();

    }
}
