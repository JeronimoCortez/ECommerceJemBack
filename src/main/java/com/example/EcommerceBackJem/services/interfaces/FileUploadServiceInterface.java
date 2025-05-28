package com.example.EcommerceBackJem.services.interfaces;

import com.example.EcommerceBackJem.entities.Producto;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadServiceInterface {

    Producto upload(Long idProducto, MultipartFile file) throws Exception;

    Producto delete(Long idProducto) throws Exception;
}
