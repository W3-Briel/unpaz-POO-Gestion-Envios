## Sistema de Gestión de Envíos Rápidos

Una empresa de logística necesita desarrollar un sistema que gestione envíos de paquetes entre distintas ciudades. Cada envío contiene información sobre el cliente, el tipo de servicio (urgente o común), el peso del paquete y la ciudad de destino.

### Requisitos
1- **Lectura desde archivo**:
Cargar desde un archivo ```envios.txt``` la lista de envíos. Cada línea del archivo contiene:

```
nombreCliente;dniCliente;ciudadDestino;tipoServicio;peso
Juan Perez;30255874;Rosario;URGENTE;12.5
```

2- **Clase abstracta**:
  Crear una clase abstracta Envio que contenga atributos comunes y métodos como:
  ```java
  double calcularCosto()
  String resumen()
```
3- **Subclases concretas**:
  EnvioUrgente y EnvioComun que hereden de Envio, cada una con su forma de calcular el costo:
  ```
  Urgente: $200 base + $10 por kg.
  Común: $100 base + $5 por kg.
  ```
4- **Interfaces**:
  * _Facturable_ : con método
  ```java
  double getMonto()
  ```
  * _Identificable_ : con método
    ```java
    String getIdentificador() /*puede devolver el nombre del cliente o DNI*/
    ```

5- **Lógica de negocio**:
  Leer los envíos desde archivo y almacenarlos en la lista y _mostrar_ por consola un menu con las siguientes opciones.
  * Total facturado por cada tipo de envío.
  * Envío más caro y su resumen.
  * Filtrar y mostrar todos los envíos a una ciudad dada.


---

> extra:
> * Manejo de excepciones personalizadas.
> * Una clase Cliente separada con métodos para validación.
> * Uso de Map<String, List<Envio>> para agrupar envíos por ciudad.
> * Agregar nuevos envíos por consola y guardarlos en el archivo.
