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
    public String upload(MultipartFile file) throws Exception {

            List<String> allowedExtensions = Arrays.asList("jpg","jpeg", "png", "webp", "avif","jpg");


            if (file.getOriginalFilename() != null){
                String[] splitName = file.getOriginalFilename().split("\\.");

                if (!allowedExtensions.contains(splitName[splitName.length - 1].toLowerCase())) throw new Exception(
                        String.format("Extension %s not allowed", splitName[splitName.length - 1])
                );
            }


        try{
            Map<String, Object> resultUpload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "EcommerceJem"));

            String imageUrl = (String) resultUpload.get("secure_url");


            return (String) resultUpload.get("secure_url");
        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    @Override
    public Producto delete(Long idProducto) throws Exception {
        Optional<Producto> productoBd = productoService.findById(idProducto);
        Producto producto = productoBd.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        String urlImagen = producto.getImagen();

        if (urlImagen != null && !urlImagen.isEmpty()) {
            String[] parts = urlImagen.split("/");
            String filenameWithExtension = parts[parts.length - 1];
            String filename = filenameWithExtension.split("\\.")[0];
            String folder = parts[parts.length - 2];

            String publicId = folder + "/" + filename;

            try{
                Map deleteResult = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            }catch (Exception ex){
                System.err.println("Error al eliminar imagen de Cloudinary: " + ex.getMessage());
            }
        }

        producto.setImagen("");
        return productoService.save(producto);
    }
}
