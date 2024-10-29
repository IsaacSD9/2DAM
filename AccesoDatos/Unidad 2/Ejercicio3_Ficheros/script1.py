import mysql.connector
from mysql.connector import Error
import random
import time

try:
    # Establecer conexión con la base de datos
    conexion = mysql.connector.connect(
        host='localhost',
        user='usuario',
        password='usuario',
        database='2DAM'
    )
    
    if conexion.is_connected():
        print("Conexión a la base de datos exitosa")
        cursor = conexion.cursor()

        # Datos de ejemplo
        generos = ['Drama', 'Comedia', 'Acción', 'Terror', 'Ciencia Ficción']
        cadenas = ['Clan', 'Netflix', 'Boing', 'Disney+', 'La 1']

        # Medir el tiempo de inserción masiva
        start_time = time.time()

        for i in range(30001, 40001):
            nombre_serie = f"Serie{i+1}"
            temporada = random.randint(1, 10)  # Temporadas entre 1 y 10
            genero = random.choice(generos)
            cadena_television = random.choice(cadenas)
            valoracion = round(random.uniform(1, 10), 1)  # Valoración decimal entre 1 y 10, con 1 decimales
            
            # Consulta de inserción
            query = """
            INSERT INTO series_television (nombre_serie, temporada, genero, cadena_television, valoracion) 
            VALUES (%s, %s, %s, %s, %s)
            """
            values = (nombre_serie, temporada, genero, cadena_television, valoracion)
            
            # Ejecutar la consulta
            cursor.execute(query, values)

        # Confirmar la inserción
        conexion.commit()
        
        # Calcular y mostrar el tiempo de inserción
        end_time = time.time()
        print(f"Tiempo de inserción con mysql-connector: {end_time - start_time} segundos")

except Error as e:
    print(f"Error de conexión: {e}")
finally:
    if conexion.is_connected():
        cursor.close()
        conexion.close()
        print("Conexión cerrada")
