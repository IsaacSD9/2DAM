import mysql.connector  
from mysql.connector import Error  
import time  

try:
    # Establecer conexión con la base de datos
    conexion = mysql.connector.connect(
        host='localhost',    
        user='usuario',      
        password='usuario',  
        database='2DAM'      
    )
    
    # Verifico si la conexión fue exitosa
    if conexion.is_connected():
        print("Conexión a la base de datos exitosa")  
        cursor = conexion.cursor() 
        
        start_time = time.time()

        query = "SELECT * FROM series_television;"
        cursor.execute(query)  # Ejecuto la consulta

        # Recupero todos los registros de la base de datos usando fetchall
        registros = cursor.fetchall()

        end_time = time.time()
        
        # Imprimo cuántos registros han sido recuperados de la base de datos
        print(f"Se recuperaron {len(registros)} registros.")
        print(f"Tiempo de lectura con mysql-connector: {end_time - start_time} segundos")
    

except Error as e:
    print(f"Error de conexión: {e}")

finally:
    if conexion.is_connected():  
        cursor.close()  
        conexion.close()  
        print("Conexión cerrada")  