package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PatchMapping("/image")
    public ResponseEntity<?> uplodad(@RequestParam MultipartFile file) throws Exception {
        return ResponseEntity.ok(fileUploadService.upload(file));
    }

    @PatchMapping("/eliminarImagen/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable Long idProducto) throws Exception {
        return ResponseEntity.ok(fileUploadService.delete(idProducto));
    }
}
