from pathlib import Path

class FileManager:
 def __init__(self, path):
     self.path = Path(path) # Como tenemos un constructor al que le pasamos como
     # parámetro de entrada el nombre del directorio, después en los otros métodos
     # no lo tenemos que poner de parámetro de entrada sino que simplemente
     # utilizamos ese atributo que ya tiene el valor asignado

 def create_directory(self):
     if not self.path.exists():
         self.path.mkdir()
         print(f'Directorio {self.path} creado.')
     else:
         print(f'El directorio {self.path} ya existe.')

 def list_files(self):
     if self.path.exists() and self.path.is_dir():
         return list(self.path.iterdir())
     return []

 def delete_directory(self):
     if self.path.exists() and self.path.is_dir():
         self.path.rmdir()
         print(f'Directorio {self.path} eliminado.')

file_manager= FileManager("directorio_prueba")
file_manager.create_directory()
file_manager.delete_directory()
