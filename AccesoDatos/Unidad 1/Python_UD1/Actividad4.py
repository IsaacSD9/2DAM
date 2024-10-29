import csv  
import json  

class FileConverter:  
    
    def json_csv(self, json_file, csv_file):  # Define un método para convertir un archivo JSON a CSV.
        try:
            with open(json_file, 'r') as f1:  # Abre el archivo JSON en modo lectura.
                d2 = json.load(f1)  # Carga el contenido JSON en la variable d2.
                claves = list(d2.keys())  # Obtiene las claves del diccionario y las almacena en la lista claves.
        except Exception as e:  
            print(f"Error leyendo JSON: {e}")  
        
        try:    
            with open(csv_file, mode='w', newline='') as f2:  # Abre el archivo CSV en modo escritura.
                writer = csv.DictWriter(f2, fieldnames=claves)  # Crea un objeto writer para escribir en CSV,
                                                             # especificando las claves que serán las columnas.
                writer.writeheader()  # Escribe la primera fila que contiene los nombres de las columnas
                                                                                            # (encabezado).
                writer.writerow(d2)  # Escribe los datos en filas en el archivo CSV.
        except Exception as e:  
            print(f"Error escribiendo en el archivo CSV: {e}")  
         
    def write_file(self, file_path, content, mode='w'): 
        try:
            with open(file_path, mode) as f:  
               
                json.dump(content, f)  
        except Exception as e:  
            print(f"Error escribiendo el archivo: {e}") 
        

d = {"DNI": "78104579Y", "Fecha Nacimiento": "09/08/2005"}
f = FileConverter()  

f.write_file("data2.json", d)  
converter = FileConverter()  
converter.json_csv('data2.json', 'data2.csv')  
