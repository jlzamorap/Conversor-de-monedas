
# Conversor de monedas

Objetivos del programa

Solicitar al usuario dos monedas (origen y destino).

Solicitar una cantidad a convertir.

Consultar las tasas de cambio en tiempo real desde una API (ExchangeRate API).

Realizar la conversión.

Mostrar el resultado.

Guardar un historial de conversiones realizadas.

### Estructura del proyecto

El programa está dividido por clases, permitiendo su escalabilidad y mantenimiento. A continuacion se muestran las clases principales:

Principal.java
Contiene el método main (punto de entrada del programa). Se encarga de:

Mostrar el menú.

Leer la opción del usuario.

Pedir las monedas y la cantidad.

Realizar la conversión y mostrar el resultado.

Guardar el historial.

Coversor.java
Clase utilitaria que solo muestra el menú con las opciones de conversión predefinidas.

CurrencyConverter.java
Contiene la lógica para:

Obtener la tasa de conversión usando una clase de servicio.

Calcular el monto convertido (multiplicación directa).

ExchangeRateService.java
Encapsula la lógica para obtener las tasas de cambio desde la API. Se comunica con ConsultaCambio.java para hacer la petición.

ConsultaCambio.java
Encargada de:

Hacer la petición HTTP a la API de ExchangeRate.

Convertir la respuesta JSON en un objeto Java (usando Gson).

Devolver un objeto TasaCambio.

TasaCambio.java
Es una clase POJO que representa el JSON recibido de la API. Contiene:

El código de la moneda base.

Un mapa con las conversiones a otras monedas (Map<String, Double>).

HistorialConversiones.java (agregada recientemente)
Guarda y muestra un historial de conversiones realizadas.

### Flujo de ejecución

El usuario ve un menú con varias opciones de conversión (USD a ARS, COP a USD, etc.).

Elige una opción (por ejemplo, 1 = USD a ARS).

Ingresa una cantidad (ej. 100).

El programa obtiene la tasa actual entre USD y ARS usando la API.

Calcula y muestra el resultado (ej. 100 USD = 86,000 ARS).

Se guarda la conversión en el historial.

El usuario puede continuar convirtiendo o salir.

