from pathlib import Path  
import json  # Importa el módulo json para trabajar con datos en formato JSON.

class JSONFileHandler:  

    def read_json(self, file_path):  # Método para leer un archivo JSON.
        try:
            with open(file_path, 'r') as f:
                # Carga y devuelve el contenido del archivo JSON como un objeto Python.
                return json.load(f)  
        except Exception as e:
            print(f"Error leyendo JSON: {e}")  

    def write_file(self, file_path, content, mode='w'):  # Método para escribir un archivo JSON.
        try:
            with open(file_path, mode) as f:
                # Escribe el contenido en el archivo en formato JSON.
                json.dump(content, f)  
        except Exception as e:
            print(f"Error escribiendo el archivo: {e}")  

# Creamos el diccionario para escribir en el archivo.
d = {"DNI": "78104579Y", "Fecha Nacimiento": "09/08/2005"}  

f = JSONFileHandler()  

# Llama al método write_file para escribir el diccionario (d) en un archivo llamado "data.json".
f.write_file("data.json", d)  

# Llama al método read_json para leer el contenido del archivo "data.json" y lo imprime.
print(f.read_json("data.json"))  
