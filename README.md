# POOModeloTextual
Integrantes:

Jostin Xavier Vasquez Calderón 

David Alejandro Ruiz Sanchez 

Gyna Mayerly Yupanqui Romero 

Jessica Catalina Rivas Jimenez  


Sistema de Gestión de una Flota de Vehículos para una Empresa de Reparto

Una empresa de reparto necesita gestionar su flota de vehículos (motos, camionetas y camiones). Cada vehículo tiene características únicas (capacidad de carga, consumo de combustible, mantenimiento) y debe registrar viajes, calcular costos operativos y gestionar el estado técnico.

Requisitos Funcionales:

Crear una aplicación que permita:

Registrar motos, camionetas y camiones con: 
Placa única, Capacidad de carga (kg), Consumo de combustible (litros/km), Fecha de último mantenimiento.
Registrar información específica para: 
Motos: Cilindrada (cc), Camionetas: Tracción 4x4 (sí/no), Camiones: Número de ejes.
Asociar viajes a vehículos con: 
distancia recorrida (km), fecha del viaje.
Calcular el costo operativo automáticamente de un viaje a través de la siguiente fórmula:

Costo = distancia * consumo * precio_combustible + costo_mantenimiento. 
Variables: 

Precio del combustible (valor global estático).
Costo de mantenimiento base (según tipo de vehículo).
Actualizar fecha de último mantenimiento de cada vehículo.
Alertar si un vehículo supera los 6 meses sin mantenimiento.
Mostrar todos los vehículos registrados con su estado actual.
Evitar valores negativos en distancias o precios.
Validar formatos de fecha (YYYY-MM-DD).
