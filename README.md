Evaluación formativa 4 - SpeedFast

👤 Autor del proyecto

Nombre completo: Elías González Ubilla

Carrera: Analista Programador

Sede: Sede Online

📘 Descripción del proyecto

Este proyecto implementa un sistema de gestión para la empresa de reparto a domicilio SpeedFast. La aplicación utiliza los pilares de la Programación Orientada a Objetos (POO) en Java para gestionar tres tipos de pedidos: Comida, Encomiendas y Compras Express, aplicando jerarquías con clases abstractas e interfaces (Despachable, Cancelable y Rastreable).

En esta etapa, se ha incorporado un modelo de concurrencia de productor-consumidor para resolver los desafíos de sincronización en el despacho. Se implementó el `enum` `EstadoPedido` para gestionar de forma segura el ciclo de vida de cada encomienda (`PENDIENTE`, `EN_REPARTO`, `ENTREGADO`). Asimismo, se creó la clase `ZonaDeCarga` como un recurso compartido protegido con métodos `synchronized`, garantizando que múltiples hilos de tipo `Repartidor` (`Runnable`) retiren y procesen los pedidos de forma dinámica y segura, evitando condiciones de carrera o entregas duplicadas mediante un pool de hilos con `ExecutorService`.

Adicionalmente, se ha implementado una GUI basada en distintas ventanas que dialogan entre sí y con el proyecto previo, permitiendo una interacción visual completa para el registro, monitoreo en tiempo real de los envíos y control de la simulación.

🧱 Estructura y Jerarquía del Proyecto

El sistema está diseñado bajo un enfoque modular para garantizar escalabilidad:

model: Define la jerarquía de clases (Pedido como abstracta, con PedidoComida, PedidoEncomienda y PedidoExpress como subclases), las interfaces, el `enum` `EstadoPedido` y la clase `Repartidor` que implementa `Runnable` para el consumo concurrente de tareas.

ui: Contiene la clase `Main` encargada de inicializar la aplicación, junto con las clases `VentanaPrincipal`, `VentanaRegistros` y `VentanaLista`, las cuales gestionan la interfaz gráfica y se comunican de forma coordinada con la lógica de negocio y los hilos de reparto.

data: Contiene las clases encargadas de la lógica de gestión, almacenamiento temporal y sincronización, incluyendo `ZonaDeCarga`, `GestorDeEnvios` y `RegistroEnvios`.

⚙️ Cómo ejecutar el proyecto

Abre el proyecto en Apache NetBeans o tu IDE de preferencia.

Navega hasta el paquete ui.

Ejecuta la clase Main.java para levantar la interfaz gráfica y coordinar las ventanas y la simulación de repartos.

🔗 Repositorio

GitHub: https://github.com/egonzalezubilla/SpeedFast.git

Fecha de entrega: 21/09/2026

© Duoc UC | Escuela de Informática y Telecomunicaciones