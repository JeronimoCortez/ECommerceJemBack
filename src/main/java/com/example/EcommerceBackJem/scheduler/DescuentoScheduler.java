package com.example.EcommerceBackJem.scheduler;

import com.example.EcommerceBackJem.entities.Descuento;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class DescuentoScheduler {
    @Autowired
    private DescuentoRepository descuentoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostConstruct
    public void ejecutarAlIniciar() {
        System.out.println("Ejecutando schduler...");
        desactivarDescuentosVencidos();
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "America/Argentina/Buenos_Aires")
    public void desactivarDescuentosVencidos() {
        LocalDateTime fecha = LocalDateTime.now();
        Date fechaActual = java.sql.Timestamp.valueOf(fecha);
        List<Descuento> descuentosVencidos = descuentoRepository.findByFechaLimiteBeforeAndActivoTrue((fechaActual));
        System.out.println("Descuentos vencidos: " + descuentosVencidos);

        for (Descuento descuento : descuentosVencidos) {
            System.out.println("Porcentaje descuento" + descuento.getDescuento());
            descuento.setActivo(false);
            if (descuento.getProducto() != null) {
                Producto producto = productoRepository.findById(descuento.getProducto().getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

                double porcentaje = descuento.getDescuento() / 100.0;

                Double precioSinDescuento = producto.getPrecio() / (1 - porcentaje);
                producto.setDescuento(null);
                producto.setPrecio(precioSinDescuento);
                productoRepository.save(producto);

            }

        }

        descuentoRepository.saveAll(descuentosVencidos);
    }
}
