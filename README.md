# EcommerceBackJEM

Proyecto backend para una tienda de ecommerce desarrollado en Java con Spring Boot.

## Características

- Gestión de usuarios con roles (`ADMIN`, `USER`)
- Autenticación y autorización JWT
- CRUD de productos, categorías, talles, tipos y direcciones
- Gestión de órdenes de compra y detalles
- Sistema de descuentos con scheduler para desactivación automática
- Integración con Cloudinary para subida y eliminación de imágenes de productos
- Integración con MercadoPago para pagos
- API RESTful documentada y estructurada

## Estructura del Proyecto

- `src/main/java/com/example/EcommerceBackJem/`  
  Código fuente principal (entidades, servicios, controladores, repositorios, configuración)
- `src/main/resources/application.properties`  
  Configuración de la base de datos y servicios externos
- `build.gradle`  
  Dependencias y configuración de Gradle

## Configuración

1. **Base de datos:**  
   Configura tu base de datos MySQL en `src/main/resources/application.properties`.

2. **Cloudinary:**  
   Añade tus credenciales de Cloudinary en el mismo archivo para la gestión de imágenes.

3. **MercadoPago:**  
   Configura tu access token de MercadoPago en `application.properties`.

## Ejecución

1. Instala las dependencias:

   ```sh
   ./gradlew build
   ```

2. Ejecuta la aplicación:

   ```sh
   ./gradlew bootRun
   ```

3. El backend estará disponible en `http://localhost:8080/`

## Endpoints principales

- `/auth/login` y `/auth/register` — Autenticación y registro de usuarios
- `/producto` — Gestión de productos (crear, listar, filtrar, asignar/eliminar descuentos)
- `/categoria` — Gestión de categorías
- `/talle` — Gestión de talles
- `/tipo` — Gestión de tipos
- `/usuario` — Gestión de usuarios y direcciones
- `/orden-compra` — Gestión de órdenes de compra
- `/detalle` — Gestión de detalles de orden
- `/upload` — Subida y eliminación de imágenes de productos
- `/pay/mp` — Integración con MercadoPago

## Notas

- El proyecto utiliza JWT para la autenticación de endpoints protegidos.
- El scheduler desactiva automáticamente los descuentos vencidos y actualiza los precios de los productos afectados.
- Se recomienda usar [Postman](https://www.postman.com/) o similar para probar los endpoints.

---

Desarrollado por el equipo JEM - UTN.
