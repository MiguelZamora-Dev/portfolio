import os

html1 = """
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles.css">
    <script src="./scripts.js"></script>
    <title>""" 
html2 = """</title>
</head>
<body>
"""

fin_html = """
</body>
</html>
"""

navbar = """
<nav class="navbar-container">
    <div class="nav-logo-block">
        <img src="./resources/img/mercedes-benz-1.svg" alt="Concesionario-logo" class="nav-logo">
    </div>
    <div class="nav-nombre-block">
        <span class="nav-nombre"></span>
    </div>
    <div class="menu">
        <a href="#" class="menu-link">Ver stock</a>
        <a href="#" class="menu-link">Sobre nosotros</a>
        <a href="#" class="menu-link">Cuenta</a>
    </div>
</nav>
"""

footer = """
<footer class="pie-container">
    <div class="pie-infos">
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
        <span class="texto-legal">Textos legales</span>
    </div>
</footer>
"""

if __name__ == "__main__":
    name = input("Nombre del documento: ")
    document = html1 + name.capitalize() + html2 + navbar + footer + fin_html

    ruta = "./concesionario/src/main/webapp/"
    print("La ruta por defecto es: " + ruta)
    respuesta = input("Deseas cambiarla? Indica Y/y")
    if (respuesta in ["Y", "y"]):
        ruta = input("En que carpeta debo guardarlo: ")
    if (os.path.exists(ruta + name + ".html")):
        print("Ya existe un documento con ese nombre en esa carpeta")
    else: 
        with open(ruta + name + ".html", "w") as new_file:
            new_file.write(document)
            print("Se ha creado el archivo en la ruta especificada")
