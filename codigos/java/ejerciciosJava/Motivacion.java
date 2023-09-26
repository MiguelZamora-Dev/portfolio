/*
 * Este programa mide la motivación de un alumno por estudiar la asignatura 
 * programación en base a 8 preguntas
 * 
 * Autor: Miguel Zamora Castellanos 
 * Fecha: 18/10/2022
 */

import java.util.Scanner;

class Motivacion {

    public static void main(String[] args) {

        // Variables a utilizar durante la ejecución del programa
        int[] respuestas = new int[8];
        Scanner scanner = new Scanner(System.in);
        int respuesta;
        float total = 0;
        int intentos = 0;
        float[] mediaIntentosContainer = new float[3];
        float mediaIntentos = 0;

        System.out.println("Este programa mide la motivación del alumno");
        
        while(intentos < 3) {
        total = 0;
        intentos += 1;

        System.out.println("Por favor, responda a las siguientes cuestiones usando\n\n 1 - Si\n 0 - No: \n");
        
        // Se lee un dato y se añade al array. 
        // Al final del programa se muestran los resultados por pregunta y en total
        respuestas[0] = addResponse("Te gustan las computadoras.", scanner);

        respuestas[1] = addResponse("Disfrutas con la resolución de problemas.", scanner);

        respuestas[2] = addResponse("Quieres trabajar en equipo.", scanner);

        respuestas[3] = addResponse("Te agrada aprender por descubrimiento o prefieres que te indiquen las cosas paso a paso.", scanner);

        respuestas[4] = addResponse("Eres creativo.", scanner);

        respuestas[5] = addResponse("Eres resolutivo.",scanner);

        // Dada la frase establecida se modifica el resultado leído, pues lo positivo
        // sería que no se rindiese en el primer intento
        respuesta = addResponse("Te rindes al primer intento.", scanner);
        if (respuesta == 1) respuestas[6] = 0;
        if (respuesta == 0) respuestas[6] = 1;

        respuestas[7] = addResponse("Estas dispuesto a tener que actualizar tu conocimiento a lo largo de tu vida.", scanner);

        // Se calcula la cantidad total de "Sí" en el array
        for (int i = 0; i < respuestas.length; i++) {
            total += respuestas[i];
        }

        // Se calcula el porcentaje de "Sí" obtenido en el total de las preguntas
        total = total / respuestas.length * 100;

        System.out.println("\nSus respuestas han sido: ");
        for (int i = 0; i < respuestas.length; i++) {
            System.out.print(respuestas[i]);
        }
        System.out.println("\n\nSu nivel de motivacion es del " + total + "%");

        // Guardar los resultados de los intentos
        mediaIntentosContainer[intentos - 1] = total;

        if (total > 80 && intentos < 2){
            System.out.println("Enhorabuena!");
            return;
        }else{
            if (intentos == 1) {
                System.out.println("Es inferior al minimo establecido\nDebe realizar la prueba dos veces mas");
            }
            if (intentos == 2) {
                System.out.println("Debe realizar la prueba de nuevo");
            }
        }
        } // fin de bucle while

        // Con esta sección se cierra el programa. 
        // Se calcula la media de los resultados y se muestra por pantalla
        // lo que debe hacer el alumno en función de su media en las tres pruebas

        for (int i = 0; i < mediaIntentosContainer.length; i++) {
            mediaIntentos += mediaIntentosContainer[i];
        }
        mediaIntentos = mediaIntentos / mediaIntentosContainer.length;

        System.out.println("\nLa media de sus intentos es: " + mediaIntentos + "%");
        if (mediaIntentos < 50) {
            System.out.println("\nHemos detectado una falta de interes en la asignatura. Debe comunicarse cuanto antes con su docente para encontrar una solucion.\n");
            return;
        }
        System.out.println("Enhorabuena!");
    }   

    // Funcion para añadir una respuesta al array.
    // Muestra el mensaje, se comprueba que la entrada es un 1 o un 0
    // y devuelve el valor leído
    public static int addResponse(String msg, Scanner scanner) {
        int value;
        System.out.println(msg);
        value = scanner.nextInt();
        if ( value != 1 && value != 0) {
            System.out.println("Por favor, introduce una respuesta valida\n 1 - Si\n 0 - No");
            return addResponse(msg, scanner);
        }
        return value;
    } 

}
