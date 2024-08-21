# CalculadorDivisas

Es una aplicación que utiliza tecnologías modernas de Android, como Jetpack Compose, la arquitectura MVVM. La aplicación permite a los usuarios obtener el cambio entre gran variedad de monedas.

## Características
1. Obtiene la lista de monedas disponibles utilizando la API exchangeratesapi.io a través de una clave API, usando retrofit.
2. Implementa almacenamiento local (Room) para almacenar las monedas y tipos de cambios obtenidos de la API para dirigir las peticiones del usuario en caso de realizar la peticiones en un periodo de tiempo menor a 10 minutos.
3. Soporte de color dinámico en temas oscuros y claros.



## Capturas

|                                                                                                                         |                                                                                                                           |
|-------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| ![run_track_home_ss](https://github.com/user-attachments/assets/9c18c400-55aa-40f1-86fa-a1bebb08f6e6) | ![runtrack_live_tracking_ss](https://github.com/user-attachments/assets/4fe6412b-4e26-4727-adc9-4d64737bd0d0)|

## Tecnologias
1.Desarrollada en Kotlin.
2.inyección de Dependencias (Hilt).
3.arquitectura MVVM, Clean Architecture.
4-room.
5-Corrutinas.
6-Livedata.
7-Flow.
8-retrofit.

