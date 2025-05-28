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

    @PatchMapping("/producto/{idProducto}")
    public ResponseEntity<?> uplodad(@PathVariable Long idProducto, @RequestParam MultipartFile file) throws Exception {
        return ResponseEntity.ok(fileUploadService.upload(idProducto, file));
    }
}
