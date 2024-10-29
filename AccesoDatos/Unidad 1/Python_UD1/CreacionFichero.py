from pathlib import Path

class FileHandler:

 def read_file(self, file_path, mode='r'):
    try:
        with open(file_path, mode) as f:
            content = f.read()
            return content
    except Exception as e:
         print(f"Error leyendo el archivo: {e}")


    
 def write_file(self, file_path, content, mode='w'):
     try:
         with open(file_path, mode) as f:
            f.write(content)
     except Exception as e:
          print(f"Error leyendo el archivo: {e}")

f = FileHandler()
f.write_file("78104579Y.txt", "09/08/2005")

print(f.read_file("78104579Y.txt"))
