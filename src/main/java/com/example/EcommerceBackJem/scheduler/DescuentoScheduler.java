package com.example.EcommerceBackJem.scheduler;

import com.example.EcommerceBackJem.entities.Descuento;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DescuentoScheduler {
    @Autowired
    private DescuentoRepository descuentoRepository;

    @PostConstruct
    public void ejecutarAlIniciar() {
        desactivarDescuentosVencidos();
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "AGT")
    public void desactivarDescuentosVencidos() {
        LocalDateTime fecha = LocalDateTime.now();
        List<Descuento> descuentosVencidos = descuentoRepository.findByFechaLimiteBeforeAndActivoTrue((fecha));

        for (Descuento descuento : descuentosVencidos) {
            descuento.setActivo(false);
        }

        descuentoRepository.saveAll(descuentosVencidos);
    }
}
