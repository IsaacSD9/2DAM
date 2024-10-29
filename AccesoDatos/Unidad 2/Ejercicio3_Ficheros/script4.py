import pymysql  
import time 

try:
    # Establecer conexión con la base de datos
    conexion = pymysql.connect(
        host='localhost',    
        user='usuario',     
        password='usuario',  
        database='2DAM'     
    )
    
    # Verifico si la conexión fue exitosa
    if conexion.open:
        print("Conexión a la base de datos exitosa")  
        cursor = conexion.cursor()  
        
        # Inicio el cronómetro para medir cuánto tarda en recuperar los datos
        start_time = time.time()

        # Consulta SQL para seleccionar todos los registros de la tabla 'Comidas'
        query = "SELECT * FROM series_television;"
        cursor.execute(query)  # Ejecuto la consulta

        # Recupero todos los registros usando fetchall
        registros = cursor.fetchall()

        end_time = time.time()
        
    
        print(f"Tiempo de lectura con pymysql: {end_time - start_time} segundos")
    

except pymysql.MySQLError as e:
    print(f"Error de conexión: {e}")

finally:
    if conexion.open:  
        cursor.close()  
        conexion.close()  
        print("Conexión cerrada") 