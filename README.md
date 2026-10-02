# Evaluación sumativa 3 - SpeedFast

👤 Autor del proyecto

Nombre completo: Elías González Ubilla

Carrera: Analista Programador

Sede: Sede Online

📘 Descripción del proyecto

Este proyecto implementa un sistema de gestión completo para la empresa de reparto a domicilio SpeedFast, integrando la lógica de negocio orientada a objetos con operaciones CRUD persistentes en una base de datos relacional MySQL mediante JDBC.

La aplicación utiliza los pilares de la Programación Orientada a Objetos (POO) en Java para gestionar tres tipos de pedidos: Comida, Encomiendas y Compras Express, aplicando jerarquías con clases abstractas e interfaces (`Despachable`, `Cancelable` y `Rastreable`).

En esta etapa final, se ha incorporado la persistencia completa mediante clases DAO dedicadas (`PedidoDAO`, `RepartidorDAO`, `EntregaDAO`) utilizando `PreparedStatement` y `ResultSet` para garantizar consultas seguras y eficientes, implementando las operaciones de creación, lectura, actualización y eliminación (`CRUD`). Asimismo, se integró un modelo de concurrencia de productor-consumidor (`ZonaDeCarga`, hilos `Repartidor` con `Runnable`) y una interfaz gráfica en Java Swing equipada con componentes avanzados (`JTable`, `JComboBox`), actualización dinámica de datos en tiempo real tras cada acción, validación estricta de entradas en formularios y un manejo robusto de errores mediante bloques `try-catch` con excepciones SQL y retroalimentación visual al usuario a través de `JOptionPane`.

🧱 Estructura y Jerarquía del Proyecto

El sistema está diseñado bajo un enfoque modular para garantizar escalabilidad:

- **model**: Define la jerarquía de clases (`Pedido` como abstracta, con `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` como subclases), las interfaces, el `enum` `EstadoPedido` y la clase `Repartidor` que implementa `Runnable` para el consumo concurrente de tareas.

- **ui**: Contiene la clase `Main` encargada de inicializar la aplicación, junto con las ventanas gráficas (`VentanaPrincipal`, `VentanaRegistros`, `VentanaLista`, `VentanaRepartidores`), las cuales gestionan la interfaz en Swing y se comunican de forma coordinada con los DAO y los hilos de reparto.

- **data**: Contiene las clases encargadas de la lógica de gestión, almacenamiento temporal y sincronización, incluyendo `ZonaDeCarga`, `GestorDeEnvios` y `RegistroEnvios`.

- **dao**: Contiene las clases de acceso a datos (`PedidoDAO`, `RepartidorDAO`, `EntregaDAO`) conectadas a la base de datos MySQL mediante `ConexionDB`, utilizando consultas preparadas y gestión de recursos y excepciones SQL.

- **lib**: Contiene las librerías externas del proyecto, donde se encuentra ubicado el conector JDBC de MySQL.

🗄️ Base de Datos y Script SQL

El proyecto incluye el archivo de respaldo y estructura de la base de datos (**`speedfast_db.sql`**), el cual define las tablas relacionales (`repartidor`, `pedido`, `entrega`) con sus respectivas restricciones de claves foráneas, tipos y datos iniciales de prueba.

⚙️ Cómo ejecutar el proyecto

1. Importa y ejecuta el script de base de datos **`speedfast_db.sql`** en tu gestor MySQL (como MySQL Workbench).
2. Abre el proyecto en tu entorno de desarrollo favorito (IntelliJ IDEA o Apache NetBeans).
3. Asegúrate de incluir el conector JDBC de MySQL en las librerías/dependencias del proyecto.
4. Ejecuta la clase principal (`Main.java`) para levantar la interfaz gráfica y coordinar las ventanas, operaciones CRUD y simulación de repartos.

🔗 Repositorio

GitHub: https://github.com/egonzalezubilla/SpeedFast.git

Fecha de entrega: 02/10/2026

© Duoc UC | Escuela de Informática y Telecomunicaciones