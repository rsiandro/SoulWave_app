package com.soulwave.soulwaveapp.dao;
import com.soulwave.soulwaveapp.models.Stock;
import com.soulwave.soulwaveapp.models.Venta;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductosDaoImp implements ProductosDao {

    @PersistenceContext
    EntityManager entityManagerStock;
    @Transactional
    public List<Stock> getStock() {

        String query = "FROM Stock WHERE en_stock = 1";

        return entityManagerStock.createQuery(query).getResultList();

    }
    @PersistenceContext
    EntityManager entityManagerVenta;
    @Transactional
    public List<Venta> getVenta(String fechainicio, String fechafin) {

        String query1 = "FROM Venta WHERE (fechayhora between '";
        String query2 = "' AND '";
        String query3 = "')";

        String query = query1+fechainicio+" 00:00"+query2+fechafin+" 23:59"+query3; // Variable string para la query

        return entityManagerVenta.createQuery(query).getResultList();

    }
}
