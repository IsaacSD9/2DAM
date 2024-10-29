import mysql.connector  # Importo la librería mysql.connector para la conexión a la base de datos
from mysql.connector import Error  # Importo la clase Error para manejar excepciones
import time  # Importo la librería time para medir el tiempo de la consulta

try:
    # Establecer conexión con la base de datos
    conexion = mysql.connector.connect(
        host='localhost',    # Dirección del servidor de la base de datos (en este caso, local)
        user='usuario',      # Usuario para acceder a la base de datos
        password='usuario',  # Contraseña del usuario
        database='2DAM'      # Nombre de la base de datos a la que quiero conectarme
    )
    
    # Verifico si la conexión fue exitosa
    if conexion.is_connected():
        print("Conexión a la base de datos exitosa")  # Confirmación de conexión exitosa
        cursor = conexion.cursor()  # Creo un cursor para ejecutar consultas SQL
        
        # Inicio el cronómetro para medir cuánto tarda en recuperar los datos
        start_time = time.time()

        # Consulta SQL para seleccionar todos los registros de la tabla 'Comidas'
        query = "SELECT * FROM Comidas WHERE id BETWEEN 1 AND 10000;"
        cursor.execute(query)  # Ejecuto la consulta

        # Recupero todos los registros usando fetchall
        registros = cursor.fetchall()

        # Detengo el cronómetro y calculo el tiempo total que tomó recuperar los registros
        end_time = time.time()
        
        # Imprimo cuántos registros fueron recuperados
        print(f"Se recuperaron {len(registros)} registros.")
        print(f"Tiempo de lectura con mysql-connector: {end_time - start_time} segundos")
    

# Manejo de errores por si algo falla en la conexión o ejecución
except Error as e:
    print(f"Error de conexión: {e}")

# Finalmente, cierro la conexión y el cursor para liberar recursos
finally:
    if conexion.is_connected():  # Verifico si la conexión sigue activa
        cursor.close()  # Cierro el cursor
        conexion.close()  # Cierro la conexión con la base de datos
        print("Conexión cerrada")  # Confirmación de que se ha cerrado la conexión
