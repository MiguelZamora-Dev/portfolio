SOBRE EL PROGRAMA
Autor: Miguel Zamora Castellanos
Licencia: sin especificar

TÍTULO
Este es un juego de tipo RPG

EXPLICACIÓN DE LA IDEA
La idea es que sea un "mundo abierto" donde crear sociedades, ciudades, hacer amistades y tener mascotas 
aunque de momento es solo la demostración de las diferentes opciones que ofrece el juego.
Los usuarios puedan crearse su personaje y subirle de nivel a través de dos maneras: combatiendo o enviando a una mascota a una misión.
Todo gira en torno al personaje buscando un concepto similar a la identidad soberana digital. 
Todas las demás clases requieren de él y no tendrían sentido sin al menos un personaje. 
Los personajes pueden crear ciudades y unirse a ellas y abandonarlas de la misma manera que pueden hacerlo con las sociedades. 
Tanto las ciudades como las sociedades deben tener un líder que a menos que se cambie será el creador de dicha ciudad/sociedad.
Los personajes pueden tener empleos y habilidades. Cuando un personaje consigue un nuevo empleo adquiere las habilidades necesarias para desarrollar dicho puesto.
No es necesario que los personajes consigan un empleo para adquirir las habilidades: pueden conseguirlas directamente.
Los personajes tendrán la opción de tener mascotas. No ayudan en combate pero pueden ser enviados a misiones y le otorgarán experiencia al personaje del que sean 
compañeros cuando vuelvan. La cantidad de XP dependerá de la dificultad y el tiempo de misión.
Los personajes podrán entrar en combate contra la máquina y jugar con ella. 
El usuario controlará el primer miembro del equipo 1 y podrá atacar a quién quiera pero el personaje atacado por la máquina se elegirá automáticamente.
Otra opción es dejar a la máquina combatir contra la máquina. En este punto no hay IA por lo que los ataques son aleatorios y la victoria dependerá de 
las stats de los personajes de ambos equipos y cantidad de críticos que hagan.
En ambos casos la experiencia recibida dependerá de las kills de cada jugador, de su situación al acabar el combate (consciente o no) y de si su equipo ha resultado ganador.
Los combates pueden efectuarse con dos equipos de cualquier tamaño siempre que ambos equipos tengan la misma cantidad de combatientes. De establecer el tamaño se debe encargar la clase principal.
Los personajes tienen muchos atributos que representan sus stats físicas, elementales, su empleo, sus asociaciones, habilidades, mascotas, amistades y pertenencias a ciudades.

EXPLICACIÓN DE LA ESTRUCTURA DEL SOFTWARE 
Los atributos se pueden leer y escribir en su mayoría desde otras clases pero todos sus atributos son privados para favorecer el encapsulamiento.
Las clases PersonajeFuego, PersonajeAgua, etc. son subclases de Personaje por lo que heredan todos sus atributos y métodos. 
Las clases Gato, Perro, etc. son subclases de Mascotas y heredan de ella todos sus atributos y métodos.
Se ha optado por esta estrategia para poder hacer uso de las ventajas del polimorfismo y gestionar las mascotas juntas independientemente de su tipo
y los personajes con habilidades especiales dentro de los combates. 
Al heredar de una única superclase el uso de las interfaces deja de ser útil aunque se deja CommonPersonajes para dar fe de que se han estudiado
También se hace uso de la metaprogramación dentro de los empleos: para adquirir un empleo se añade el nombre del método que representa al empleo a Personaje 
y si la clase Empleo lo contiene se ejecuta dicho método.
Se ha usado un timer en la vuelta de misión de las mascotas para que este no interfiera en la ejecución del resto del programa. Es la única asincronía de este programa.



***		IMPORTANTE: La mayoría de los casos han sido ejemplificados a través de la clase principal. Solo será necesario leer los comentarios de la clase principal y el resultado en consola al ejecutar	***
					La mayoría de comentarios se concentran en las clases Main, Personaje y Combate, ya que su implementación era uno de los principales objetivos de este proyecto



Futuras mejoras a corto plazo:
	Añadir el 'final' a las clases que no deban ser superclase de ninguna otra
	Añadir un showEmpleos en la clase Empleos para saber cuáles existen utilizando la metaprogramación
	Añadir un menú desde el que hacer uso de estas funcionalidades (No se ha hecho en un principio para no duplicar trabajo al hacer la GUI que le falta)
	Sumar XP cuando se aprende una nueva habilidad

Futuras mejoras a corto-medio plazo:
(Modo offline)
1. Levelear habilidades, ciudades, sociedades y mascotas
2. Añadir equipo que pueda llevar un personaje (Armas, armadura, amuletos...)  
3. Añadir mascotas
4. Añadir una base de datos local para guardar los datos de la sesión de juego
5. Crea una GUI básica para 2D


Futuras mejoras a largo plazo:
(Modo online)
6. Implementar una arquitectura del tipo cliente-servidor para hacer efectivos los combates
7. Añadir un modo historia (on y offline)
8. Añadir bots en mundo abierto
9. Crear sociedades con bots
10. Añadir una mínima interactividad a los bots
11. Mapear un mundo entero en el que convivan usuarios con bots 
12. Crear eventos tanto para juntar usuarios como para que los usuarios puedan enviar a sus mascotas y ganen más XP