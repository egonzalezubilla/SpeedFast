Evaluación Sumativa 2 - SpeedFast

👤 Autor del proyecto

Nombre completo: Elías González Ubilla

Carrera: Analista Programador

Sede: Sede Online

📘 Descripción del proyecto

Este proyecto implementa un sistema de gestión para la empresa de reparto a domicilio SpeedFast. La aplicación utiliza los pilares de la Programación Orientada a Objetos (POO) en Java para gestionar tres tipos de pedidos: Comida, Encomiendas y Compras Express, aplicando jerarquías con clases abstractas e interfaces (Despachable, Cancelable y Rastreable).

En esta etapa, se ha incorporado un modelo de concurrencia de productor-consumidor para resolver los desafíos de sincronización en el despacho. Se implementó el `enum` `EstadoPedido` para gestionar de forma segura el ciclo de vida de cada encomienda (`PENDIENTE`, `EN_REPARTO`, `ENTREGADO`). Asimismo, se creó la clase `ZonaDeCarga` como un recurso compartido protegido con métodos `synchronized`, garantizando que múltiples hilos de tipo `Repartidor` (`Runnable`) retiren y procesen los pedidos de forma dinámica y segura, evitando condiciones de carrera o entregas duplicadas mediante un pool de hilos con `ExecutorService`.

🧱 Estructura y Jerarquía del Proyecto

El sistema está diseñado bajo un enfoque modular para garantizar escalabilidad:

model: Define la jerarquía de clases (Pedido como abstracta, con PedidoComida, PedidoEncomienda y PedidoExpress como subclases), las interfaces, el `enum` `EstadoPedido` y la clase `Repartidor` que implementa `Runnable` para el consumo concurrente de tareas.

ui: Contiene la clase `Main` encargada de inicializar la zona de carga, poblarla con múltiples pedidos, coordinar el pool de hilos con `ExecutorService` y gestionar la ejecución asíncrona.

data: Contiene las clases encargadas de la lógica de gestión, almacenamiento temporal y sincronización, incluyendo `ZonaDeCarga`, `GestorDeEnvios` y `RegistroEnvios`.

⚙️ Cómo ejecutar el proyecto

Abre el proyecto en Apache NetBeans o tu IDE de preferencia.

Navega hasta el paquete ui.

Ejecuta la clase Main.java para visualizar la simulación de sincronización y entregas en paralelo por consola.

🔗 Repositorio

GitHub: https://github.com/egonzalezubilla/SpeedFast.git

Fecha de entrega: 14/09/2026

© Duoc UC | Escuela de Informática y Telecomunicaciones