package com.example.EcommerceBackJem.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.services.interfaces.FileUploadServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FileUploadService implements FileUploadServiceInterface {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProductoService productoService;

    @Override
    public Producto upload(Long idProducto, MultipartFile file) throws Exception {

            List<String> allowedExtensions = Arrays.asList("jpg","jpeg", "png", "webp", "avif","jpg");
            Optional<Producto> productoBd = productoService.findById(idProducto);
            Producto producto = productoBd.orElseThrow(() -> new RuntimeException("Producto no encontrado"));


            if (file.getOriginalFilename() != null){
                String[] splitName = file.getOriginalFilename().split("\\.");

                if (!allowedExtensions.contains(splitName[splitName.length - 1].toLowerCase())) throw new Exception(
                        String.format("Extencion %s not allowed", splitName[splitName.length - 1])
                );
            }


        try{
            Map<String, Object> resultUpload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "EcommerceJem"));

            String imageUrl = (String) resultUpload.get("secure_url");

            producto.setImagen(imageUrl);

            productoService.update(producto);

            return producto;
        }catch (Exception ex){
            throw new Exception(ex);
        }

    }
}
