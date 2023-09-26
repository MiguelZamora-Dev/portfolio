import os

modificable = """
<footer class="pie-container">
    <div class="pie-infos">
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
    </div>
</footer>"""

modificado = """
<h1>funciono</h1>
"""

if __name__ == "__main__":
    name = input("Nombre del archivo:")
    ruta = "./concesionario/src/main/webapp/"
    if(os.path.exists(ruta + name)):
        file = open(ruta + name, "r")
        editable = file.read()
        file.close()
        if(modificable in editable):
            editable = editable.replace(modificable, modificado)
            print(editable)
            file = open(ruta + name, "w")
            file.write(editable)
            print("Archivo modificado")
        else:
            print("No se ha encontrado la cadena indicada")
    else: 
        print("El archivo indicado no existe en la ruta indicada")