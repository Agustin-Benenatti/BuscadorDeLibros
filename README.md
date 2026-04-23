# 📚 Buscador de Libros - Android (MVVM)

### 📌 Descripción de la app

Aplicación móvil desarrollada en Android que permite buscar y gestionar una biblioteca virtual de libros. 
El usuario puede ingresar el título de una obra en un buscador, visualizar los resultados coincidentes en una lista dinámica y acceder a una vista detallada para consultar la ficha completa del libro, incluyendo su autor, año de publicación, descripción e imagen.

### 👥 Autor

**Benenatti Agustin**

### 🧠 Implementación de MVVM

La aplicación fue desarrollada utilizando el patrón de arquitectura **MVVM (Model - View - ViewModel)**, cumpliendo con la separación de responsabilidades necesaria para un desarrollo escalable y robusto.



#### 🔹 Model

El modelo se encarga de la estructura de los datos y la lógica de negocio.
* **Clase Libro:** Define los atributos del objeto (Título, Autor, Año, Descripción, Foto) e implementa `Serializable` para el pasaje de datos entre pantallas.
* **Repositorio de Datos:** Administra la colección de libros disponibles de forma interna.
* **Lógica de Datos:** Provee la información necesaria al ViewModel para su filtrado y procesamiento.

#### 🔹 ViewModel

El ViewModel actúa como intermediario entre la vista y el modelo, manejando el estado de la UI de forma reactiva.
* **LiveData:** Contiene datos observables como la lista filtrada de libros y mensajes de error, permitiendo que la interfaz reaccione a los cambios automáticamente.
* **Lógica de Búsqueda:** Procesa el filtro de la lista comparando las entradas del usuario con los títulos almacenados, utilizando búsquedas insensibles a mayúsculas.
* **Validación:** Comprueba que el campo de búsqueda no esté vacío antes de ejecutar la operación, asegurando la integridad del flujo.
* **Notificación:** Avisa automáticamente a la vista cuando se encuentran resultados o cuando ocurre un error de validación.

#### 🔹 View (Activity & Adapter)

La vista corresponde a la interfaz gráfica y la interacción directa con el usuario.
* **MainActivity:** Contiene el campo de búsqueda y el `RecyclerView` para mostrar los resultados de forma eficiente.
* **DetalleActivity:** Interfaz dedicada a mostrar la información expandida del libro seleccionado mediante el uso de **View Binding**.
* **LibroAdapter:** Implementa el patrón **ViewHolder** para el reciclaje de vistas, optimizando el rendimiento y la fluidez del scroll.
* **Navegación:** Gestiona el paso de objetos entre actividades mediante `Intents`.

### ⚙️ Funcionalidades

* **Búsqueda por Título:** Filtrado dinámico de la biblioteca de libros.
* **Lista Eficiente:** Visualización mediante `RecyclerView` con soporte para múltiples elementos.
* **Navegación Detallada:** Paso de objetos completos de una pantalla a otra para consultar detalles específicos.
* **Validación de Entradas:** Control de campos vacíos con mensajes de retroalimentación (Toast/Error) al usuario.
* **Interfaz Moderna:** Diseño adaptado mediante `ConstraintLayout` y `CardView` para una mejor experiencia visual.
