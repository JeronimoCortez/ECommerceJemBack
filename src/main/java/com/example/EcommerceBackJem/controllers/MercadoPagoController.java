package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Detalle;
import com.example.EcommerceBackJem.entities.OrdenCompra;
import com.example.EcommerceBackJem.services.OrdenCompraService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RestController()
@RequestMapping("/pay")
@RequiredArgsConstructor
public class MercadoPagoController {

    private final OrdenCompraService ordenCompraService;

    @Value("${mercadopago.access-token}")
    private String mpAccesToken;

    @PostMapping("/mp")
    @CrossOrigin("*")
    public ResponseEntity<String> mp(@RequestBody Map<String, List<Long>> body, @RequestParam Long idUsuario) throws Exception {
        List<Long> ids = body.get("id");
        MercadoPagoConfig.setAccessToken(mpAccesToken);
        List<PreferenceItemRequest> items = new ArrayList<>();

        OrdenCompra ordenCompra = ordenCompraService.generarOrdenCompra(ids, idUsuario);

        for (Detalle detalle : ordenCompra.getDetalles()) {
            Double precioFinal = detalle.getProducto().getPrecio();
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .id(detalle.getId().toString())
                    .title(detalle.getProducto().getNombre())
                    .description(detalle.getProducto().getDescripcion())
                    .pictureUrl(detalle.getProducto().getImagen())
                    .quantity(detalle.getCantidad().intValue())
                    .currencyId("ARS")
                    .unitPrice(BigDecimal.valueOf(precioFinal))
                    .build();
            items.add(item);
        }

        PreferenceBackUrlsRequest backUrlsRequest =
                PreferenceBackUrlsRequest.builder()
                        .success("https://localhost:5173/pagoExitoso")
                        .pending("https://localhost:5173/")
                        .failure("https://localhost:5173/pagoRechazado")
                        .build();

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("atm").id("tickets").build());

        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(12)
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrlsRequest)
                .paymentMethods(paymentMethods)
                .autoReturn("approved")
                .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);

        String preferenceID = preference.getId();

        return ResponseEntity.status(HttpStatus.OK).body("{\"preferenceId\":\""+preferenceID+"\"}");
    }

}
