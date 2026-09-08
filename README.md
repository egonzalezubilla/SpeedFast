Evaluación Formativa 3 - SpeedFast



👤 Autor del proyecto



Nombre completo: Elías González Ubilla



Carrera: Analista Programador



Sede: Sede Online



📘 Descripción del proyecto



Este proyecto implementa un sistema de gestión para la empresa de reparto a domicilio SpeedFast. La aplicación utiliza los pilares de la Programación Orientada a Objetos (POO) en Java para gestionar tres tipos de pedidos: Comida, Encomiendas y Compras Express, aplicando jerarquías con clases abstractas e interfaces (Despachable, Cancelable y Rastreable).



En esta etapa, se ha incorporado programación concurrente y multihilo. Se implementó la interfaz `Runnable` en la clase `Repartidor` para gestionar entregas simultáneas mediante hilos independientes. Asimismo, se utilizó `ExecutorService` con un pool de hilos para coordinar la ejecución paralela de múltiples repartidores que procesan sus listas de pedidos de forma asíncrona, simulando pausas aleatorias con `Thread.sleep()` y un manejo adecuado de excepciones de interrupción.



🧱 Estructura y Jerarquía del Proyecto



El sistema está diseñado bajo un enfoque modular para garantizar escalabilidad:



model: Define la jerarquía de clases (Pedido como abstracta, con PedidoComida, PedidoEncomienda y PedidoExpress como subclases), las interfaces y la clase Repartidor que implementa Runnable para la ejecución concurrente.



ui: Contiene la clase Main encargada de coordinar el pool de hilos con ExecutorService y gestionar las tareas asíncronas de los repartidores.



data: Contiene las clases encargadas de la lógica de gestión y almacenamiento temporal, incluyendo GestorDeEnvios y RegistroEnvios.



⚙️ Cómo ejecutar el proyecto



Abre el proyecto en Apache NetBeans o tu IDE de preferencia.



Navega hasta el paquete ui.



Ejecuta la clase Main.java para visualizar la simulación de entregas en paralelo por consola.



🔗 Repositorio



GitHub: https://github.com/egonzalezubilla/SpeedFast.git



Fecha de entrega: 07/09/2026



© Duoc UC | Escuela de Informática y Telecomunicaciones

