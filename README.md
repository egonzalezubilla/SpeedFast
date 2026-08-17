Evaluación Formativa 1 - SpeedFast



👤 Autor del proyecto

Nombre completo: Elías González Ubilla



Carrera: Analista Programador



Sede: Sede Online



📘 Descripción del proyecto

Este proyecto implementa un sistema de gestión para la empresa de reparto a domicilio SpeedFast. La aplicación utiliza los pilares de la Programación Orientada a Objetos (POO) en Java para gestionar tres tipos de pedidos:



Comida: Requiere validación de mochila térmica.



Encomiendas: Requiere validación de peso y embalaje.



Compras Express: Requiere la búsqueda del repartidor más cercano con disponibilidad inmediata.



El núcleo funcional aplica polimorfismo mediante un método asignarRepartidor(), el cual presenta comportamientos diferenciados (sobreescritura) según el tipo de pedido, además de incluir sobrecarga de métodos para procesar la asignación personalizada por nombre de repartidor.



🧱 Estructura y Jerarquía del Proyecto

El sistema está diseñado bajo un enfoque modular para garantizar escalabilidad:



model: Define la jerarquía de clases (Pedido como clase base, con PedidoComida, PedidoEncomienda y PedidoExpress como subclases).



ui: Contiene la clase Main encargada de ejecutar las pruebas de polimorfismo y mostrar la salida por consola.



⚙️ Cómo ejecutar el proyecto

Abre el proyecto en Apache NetBeans o tu IDE de preferencia.



Navega hasta el paquete ui.



Ejecuta la clase Main.java para visualizar la lógica de asignación en consola.



🔗 Repositorio

GitHub: https://github.com/egonzalezubilla/SpeedFast.git



Fecha de entrega: 17/08/2026



© Duoc UC | Escuela de Informática y Telecomunicaciones

