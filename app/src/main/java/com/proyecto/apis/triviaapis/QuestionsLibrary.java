package com.proyecto.apis.triviaapis;

/**
 * Created by carlo on 11/04/2018.
 */

public class QuestionsLibrary {
    private String mQuestions [] = {
            "Cuál de las siguientes es una cantidad escalar?",
            "De las siguientes cantidades físicas, cual considera que es un vector",
            "A las cantidades medibles que tienen magnitud, dirección y sentido se les llama?",
            "Al sumar dos vectores cualesquiera tenemos que:",
            "En cuál de las siguientes magnitudes se hace referencia a una magnitud escalar?",
            "Si la pendiente (slope),  en un punto de la gráfica de la velocidad en función de tiempo de un cuerpo vale cero, esto significa que el cuerpo: ",
            "Al analizar un gráfico de velocidad en función del tiempo de un cuerpo se observa que aunque permanece negativa la velocidad, su magnitud va disminuyendo, luego la aceleración que actúa sobre el cuerpo es :",
            "Cuando una piedra es lanzada horizontalmente desde la azotea de un edificio, el tiempo que tarda en llegar al piso, despreciando el efecto del aire depende de:",
            "Un cañón que forma un ángulo con respecto al eje horizontal dispara un proyectil, señala lo correcto: ",
            "En el lanzamiento de proyectiles, el ángulo optimo para logra el alcance máximo es:",
            "Un par de aviones vuelan horizontalmente con la misma velocidad, pero a diferentes alturas, si al mismo tiempo sueltan un paquete, la distancia horizontal recorrida por ese paquete es: \n",
            "Para un objeto que es arrojado horizontalmente desde cierta altura, el tiempo que permanece en el aire depende de:",
            "Dos objetos son arrojados con la misma velocidad horizontal desde alturas diferentes en un edificio, la distancia horizontal recorrida por los objetos es:",
            "Un cuerpo de masa ( m) adquiere una aceleración (a) cuando se le aplique una fuerza (F). Si la fuerza aumenta tres veces y la masa disminuye 4 veces, con respecto a la aceleración podemos afirmar que:",
            "Una fuerza comunica a una masa una aceleración determinada. ¿ qué fuerza comunicará a la misma masa una aceleración doble?",
            "Un cuerpo puede estar en equilibrio cuando está en movimiento: ",
            "Un trabajador está empujando horizontalmente una gran caja de madera sobre una superficie horizontal con fricción, de modo que la caja se mueve a velocidad constante, ¿cómo es la fuerza que ejerce el trabajador comparada con la fuerza de fricción que se opone al movimiento?",
            "La dirección de la fuerza normal que actúa sobre un objeto cuando está apoyado sobre una superficie es:",
            "De acuerdo a la 2ª. ley de Newton qué pasa con el valor de la aceleración que experimenta un objeto al incrementar la fuerza que se aplica sobre él:",
            "Un bloque se mueve con velocidad variable en dirección Este sobre un superficie áspera horizontal, estirado por una fuerza paralela a la superficie, entonces podemos decir que la fuerza aplicada es, comparada con la fuerza de roce:",
            "Una bicicleta choca de frente con una banqueta. La bicicleta experienta una fuerza F. Podemos afirmar que durante el choque la banqueta:",
            "Un bloque de masa “M” está resbalando por un plano inclinado sin fricción. Determine el valor de la fuerza normal ejercida por el plano sobre el bloque:",
            "La fuerza de reacción del peso de un objeto sobre la tierra es: a) Una fuerza sobre el objeto hacia arriba",
            "En una superficie con fricción, una persona aplica a un cuerpo de masa 10 kg una fuerza de 20 N de tal modo que mantiene una velocidad constante y lo mueve 1 metro, el trabajo realizado sobre el bloque por la fuerza de rozamiento es, comparado con el desarrollado por la fuerza:",
            "La fuerza “A” de 5 N y la fuerza “B” de 40 N empujan dos cuerpos en la misma dirección y recorren la misma distancia, entonces podemos afirmar que la fuerza “A” realizó un trabajo:",
            "Una persona camina horizontalmente mientras sostiene cargada una caja aplicándole una fuerza hacia arriba, que es igual al peso de la misma. Entonces el trabajo que realiza es:",
            "Se define como la rapidez con la que se realiza el trabajo:",
            "Dos máquinas, “A” y “B realizan cierto trabajo (W) a distintos tiempos. Si la máquina “A” realiza el trabajo en el doble del tiempo que la máquina “B”, ¿cómo es la potencia de “A” con respecto a la potencia de “B”?",
            "Una máquina realiza un trabajo en un determinado tiempo. Si por alguna circunstancia la máquina logra realizar el trabajo al triple de su valor inicial, ¿cómo varió la potencia?",
            "Para un cuerpo que se mueve sobre una superficie en que existe roce, ¿qué característica tiene el trabajo realizado por la fuerza de fricción?",
            "Un motor realiza un trabajo W en un tiempo t desarrollando una potencia P, y otro motor realiza el mismo trabajo en el doble del tiempo, ¿cuántas veces mayor o menor es la potencia que desarrolla el segundo motor?",
            "Se realiza trabajo sobre un objeto:",
            "Una pelota se encuentra a cierta altura y es dejada caer. ¿Cómo es la Energía total en la parte más alta con respecto a un instante antes de chocar contra el suelo?",
            "Cómo es el comportamiento con respecto a las Energías de una pelota de béisbol si es lanzada verticalmente hacia arriba hasta que llega al punto más alto? ",
            "En qué punto es mayor la Energía Cinética de una esfera que es dejada caer desde un edificio de 10 metros?",
            "De acuerdo al principio de conservación de la energía, ¿cómo varían la energía potencial y la cinética cuando un objeto va cayendo?",
            "En el punto más alto, ¿cómo es la energía potencial (U) y la cinética (K)? ",
            "Una piedra es lanzada verticalmente hacia arriba, cuál de las siguientes oraciones es la correcta?"



    };

    private String mChoices [][] = {
            {"Campo eléctrico", "Aceleración", "Potencia", "Cantidad de movimiento"},
            {"Un avión que se dirige a 0o", "Un avión que viaja a 300.0 km/h", "Un automóvil que recorre una distancia de 600.0 km a una velocidad de 80.0 Km/h", "Un barco que viaja a una velocidad de 125.0 km/h hacia el sureste del puerto de Tampico"},
            {"Relativas", "Absolutas", "Escalares", "Vectoriales"},
            {"En todos los casos la resultante es dferente de cero", "Al sumarlos deben tener el mismo signo", "La resultante depende solo de la magnitud de cada vector", "La magnitud resultante puede ser mayor que cualquiera de los vectores sumados"},
            {"que vuela a 150 km/hr al este ", "un muchacho que va de su casa a la de una amiga que se encuentra a 20 km al norte ", "un auto que se mueve con una rapidez de 60 km/h", "la fuerza ejercida por la tierra sobre una masa de 50 kg  "},
            {"Está inmóvil", "Se mueve con aceleración distinta de cero y positiva", "Se mueve con velocidad constante", "Está inmóvil o bien se mueve con velocidad constante"},
            {"Positiva", "Negativa", "Cero", "Puede ser positiva o negativa"},
            {"la velocidad con la que fue arrojada", "el tamaño de la piedra", "la distancia horizontal que recorre", "la altura del edificio"},
            {"su velocidad horizontal tiene el máximo de aceleración al inicio", "su velocidad vertical es máxima en el sitio más alto", "la velocidad vertical tiene una aceleración uniforme en todo el recorrido", "el proyectil tarda más en subir que en caer"},
            {"90°", "60°", "45°", "90°"},
            {"mayor en el de menor altura", "mayor en el de mayor altura", "recorren la misma doistancia", "no se puede saber"},
            {"la velocidad horizontal con la que es arrojado", "la altura desde donde es arrojado", "la masa del objeto", "ninguna de las anteriores"},
            {"mayor en el de menor altura", "mayor en el de mayor altura", "recorren la misma distancia", "no se puede saber"},
            {"aumenta 4/3", "disminuye 3/4", "aumenta 12 veces", "disminuye 12 veces"},
            {"el doble de la fuerza", "el cuádruple de la fuerza", "la mitad de la fuerza", "la cuarta parte de la fuerza"},
            {"Por la inercia", "Por la aceleración", "Por el reposo", "Por la velocidad constante"},
            {"Mayor", "Menor", "Igual", "No existe relación alguna"},
            {"Paralela al la superficie sobre la que se encuentra apoyado el objeto", "Perpendicular a la superficie en contacto con el objeto", "Algunas veces es paralela y otras es perpendicular a la superficie", "Depende de la dirección del movimiento"},
            {"aumenta proporcionalmente a la fuerza", "disminuye proporcionalmente a la fuerza b) depende únicamente del valor de la masa", "no afecta el valor de la fuerza aplicada", "depende únicamente del valor de la masa"},
            {"igual", "mayor", "menor", "faltan datos para saberlo"},
            {"Experimenta una fuerza mayor a F", "Experimenta una fuerza menor a F", "Experimenta una fuerza igual a F", "No es posible comparar las fuerzas desconociendo la velocidad inicial de la bicicleta"},
            {"g sen ø", "Mg cos ø", "Mg sen ø", "cero porque el plano no tiene fricción"},
            {"Una fuerza sobre el objeto hacia abajo", "Una fuerza sobre el centro de la tierra hacia arriba", "Una fuerza sobre el centro de la tierra hacia abajo", "Una fuerza sobre el objeto hacia arriba"},
            {"igual pero negativo", "igual", "mayor", "no se puede comparar "},
            {"mayor que la fuerza “B”", "menor que la fuerza “B”", "igual que la fuerza “B”", "es independiente de la fuerza"},
            {"igual cero", "positivo", "negativo", "no se puede determinar"},
            {"Aceleración", "Potencia", "Energía", "Fricción"},
            {"El doble", "La mitad", "La cuarta parte", "Son iguales"},
            {"Aumenta 3 veces", "Disminuye 1/3", "Aumenta al doble", "No cambia"},
            {"No es significativo", "W = f . d . Cos(180)", "El trabajo tiene un sentido positivo", "W = f . d . Cos(0)"},
            {"1 vez mayor", "2 veces menor", "2 veces mayor", "4 veces menor"},
            {"Cuando se aplica una fuerza sobre el objeto aunque no haya desplazamiento", "Cuando la fuerza aplicada es perpendicuar al desplazamiento", "Cuando se aplica una fuerza y ocurre un desplazamiento en la dirección de la fuerza", "Cuando no se aplica ninguna fuerza sobre el objeto"},
            {"Mayor", "Menor", "Iguales", "No se puede saber"},
            {"Aumenta la Energía Cinética y disminuye la Energía Potencial", "Disminuye la Energía Cinética y aumenta la Energía Potencial", "Aumentan tanto la Energía Cinética como la Energía Potencial", "Disminuyen ambas Energías"},
            {"En la parte más alta", "En la mitad de su recorrido", "Justo antes de chocar contra el suelo", "Después de chocar contra el suelo "},
            {"la energía potencial aumenta y la energía cinética aumenta", "la energía potencial disminuye y la energía cinética disminuye", "la energía potencial disminuye y la energía cinética aumenta", "la energía potencial aumenta y la energía cinética disminuye"},
            {"U=máxima; K=0", "U=0 ; K=máxima", "U=máxima;  K=máxima", "U=0; K=0"},
            {"En el sitio más bajo la energía potencial es mayor", "Conforme va subiendo gana energía cinética y pierde energía potencial", "A la mitad del recorrido, tendrá cierto valor de energía cinética y cierto valor  de energía potencial", "En el sitio más alto la energía cinética es máxima"},
            /*
            */
            // {"", "", "", ""},
    };

    private String mCorrectAnswers[] = {
            "Potencia",
            "Un barco que viaja a una velocidad de 125.0 km/h hacia el sureste del puerto de Tampico",
            "Vectoriales",
            "La magnitud resultante puede ser mayor que cualquiera de los vectores sumados",
            "un auto que se mueve con una rapidez de 60 km/h",
            "Se mueve con velocidad constante",
            "Positiva",
            "la altura del edificio",
            "la velocidad vertical tiene una aceleración uniforme en todo el recorrido",
            "45°",
            "mayor en el de mayor altura",
            "la altura desde donde es arrojado",
            "mayor en el de mayor altura ",
            "aumenta",
            "el doble de la fuerza",
            "Por la velocidad constante",
            "Igual",
            "Perpendicular a la superficie en contacto con el objeto",
            "aumenta proporcionalmente a la fuerza",
            "mayor",
            "Experimenta una fuerza igual a F",
            "Mg cos ø",
            "Una fuerza sobre el centro de la tierra hacia arriba",
            "igual pero negativo",
            "menor que la fuerza “B”",
            "igual cero",
            "Potencia",
            "La mitad",
            "Aumenta 3 veces",
            "W = f . d . Cos(180)",
            "2 veces menor",
            "Cuando se aplica una fuerza y ocurre un desplazamiento en la dirección de la fuerza",
            "Iguales",
            "Disminuye la Energía Cinética y aumenta la Energía Potencial",
            "Justo antes de chocar contra el suelo",
            "la energía potencial disminuye y la energía cinética aumenta",
            "U=máxima; K=0",
            "A la mitad del recorrido, tendrá cierto valor de energía cinética y cierto valor  de energía potencial"
        };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
