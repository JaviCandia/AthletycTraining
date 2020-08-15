package com.example.myapplication.Dataset;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class FakeDb {

    static List<ObjectArticle> articleList = new ArrayList<ObjectArticle>();

    public static List getArticles(){
        articleList.add(
                new ObjectArticle(
                        0,
                        "La cafeína y sus beneficios",
                        "Junio 2020",
                        R.drawable.articulo1,
                        "La cafeína es una de las sustancias más comúnmente usadas en el mundo del deporte, " +
                                "gracias a su efecto como estimulante mejorando el rendimiento y reduciendo la percepción" +
                                " del esfuerzo o del dolor muscular, también ayuda a mejorar la concentración y procesos cognitivos. " +
                                "La cafeína puede incrementar la secreción de adrenalina y dopamina, lo que puede beneficiar a la potencia muscular. " +
                                "De manera general, la cafeína nos ayudará a mejorar nuestro rendimiento y a tolerar un mayor volumen de trabajo (entrenar más). ")
        );

        articleList.add(
                new ObjectArticle(
                        1,
                        "Receta: Taco árabe con guacamole",
                        "Junio 2020",
                        R.drawable.articulo2,
                        "Una manera sencilla y rica y de comer tacos árabes de una manera controlada.\n" +
                                "\n" +
                                "Taco Árabe de Cerdo\n" +
                                "\n" +
                                "Ingredientes: 1 pieza ( 40 gr ) de pan arable ( Libanius ), 30 gr de Queso Mozarrella Rallado ( LALA ), 90 gr Lomo de Cerdo\n" +
                                "\n" +
                                "Guacamole\n" +
                                "\n" +
                                "Ingredientes: 100 gr de Aguacate, 20 gr de Cebolla blanca, Limón, Cilantro y Sal al gusto.\n" +
                                "\n" +
                                "Calorías del taco: 346\n" +
                                "\n" +
                                "Carbohidratos: 26 gr\n" +
                                "\n" +
                                "Proteínas: 29 gr\n" +
                                "\n" +
                                "Lípidos: 14 gr\n" +
                                "\n" +
                                "Calorías del guacamole: 174\n" +
                                "\n" +
                                "Carbohidratos: 10 gr\n" +
                                "\n" +
                                "Proteínas: 2 gr\n" +
                                "\n" +
                                "Lípidos: 14 gr\n" +
                                "\n" +
                                "Preparar el Lomo de cerdo asado con los condimentos de tu preferencia.\n" +
                                "\n" +
                                "Colocar la carne en una parte del taco, colocar el queso y calentar todo hasta derretirlo.\n" +
                                "\n" +
                                "Preparar el guacamole y acompañar con todo.")
        );

        articleList.add(
                new ObjectArticle(
                        2,
                        "Curiosidades de las grasas",
                        "Junio 2020",
                        R.drawable.articulo3,
                        "Las grasas desempeñan un papel vital en muchas funciones corporales:\n\n" +
                                "\n- Son una parte necesaria de las membranas celulares.\n" +
                                "\n- Actúan como transportadores de vitaminas solubles en grasa como las vitaminas A, D, E y K.\n" +
                                "\n- Su consumo provee ácidos grasos esenciales, además de sabor y palatabilidad a los alimentos.\n" +
                                "\n- La grasa almacenada proporciona energía constante.\n" +
                                "\n- El tejido adiposo protege los órganos de heridas al servir como un cojín de protección.\n" +
                                "\n- Las grasas proporcionan una sensación de saciedad después de comer, en parte gracias a su índice lento de digestión.\n" +
                                "\n- Su conversión en energía es más lenta que la de los carbohidratos, por lo que no puede generar tanta energía por unidad de tiempo, aunque la cantidad total de ésta almacenada en nuestro organismo es muchísimo mayor.\n" +
                                "\n- El consumo de grasa influye en la concentración de hormonas, como la testosterona. Dietas bajas en grasa se asocian con una pequeña reducción de la producción de testosterona.\n" +
                                "\n- Hay que tener cuidado con su consumo puesto que es muy fácil obtener una gran cantidad de calorías de ellas, a diferencia de los carbohidratos y proteínas.")
        );

        articleList.add(
                new ObjectArticle(
                        3,
                        "Suplementación clave. La creatina",
                        "Junio 2020",
                        R.drawable.articulo4,
                        "La creatina es de los suplementos con mayores investigaciones científicas y de la cual cada vez se descubren mayores beneficios. Este es un pequeño peptido formado por los aminoácidos l-Arginina, Metionina y Glicina.\n" +
                                "\n" +
                                "Se encarga de facilitar la resíntesis de ATP, es decir, te ayuda a aumentar tu rendimiento en el gimnasio, como sacar 1 o 2 repeticiones más o soportar mejor esos 5 kilogramos extras que acabas de añadir a tu sentadilla. " +
                                "Esto hará que con el tiempo puedas incrementar un poco más tu masa muscular o proteger tu masa muscular en momentos cuando desees bajar de peso.\n" +
                                "\n" +
                                "En siguientes artículos hablaremos más sobre los múltiples beneficios de la creatina.")
        );

        articleList.add(
                new ObjectArticle(
                        4,
                        "Receta: Tostadas de sardina con puré de papa",
                        "Junio 2020",
                        R.drawable.articulo5,
                        "Muy sencillo y práctico de hacer.\n" +
                                "\n" +
                                "Ingredientes de la Tostada de Sardina (405 calorías):\n" +
                                "\n" +
                                "160 gr de Sardina (Se usó \"Sardinas en Salsa de Tomate Calmex\"), 1 Porción (30 gr) de Galletas Saladas (Se usó \"Saladitas\"), 20 gr de Cebolla blanca, 20 gr de Jitomate, Cilantro al gusto.\n" +
                                "\n" +
                                "Ingredientes del puré de papa (222 calorías):\n" +
                                "\n" +
                                "200 gr de Papa hervida, 50 ml de Leche (Se usó \"Leche Alpura deslactosada\"), 1 cucharadita (5ml) de aceite de oliva, Cilantro al gusto.\n" +
                                "\n" +
                                "Calorías totales. 627\n" +
                                "Carbohidratos. 63 gr\n" +
                                "Proteínas: 33 gr\n" +
                                "Lípidos: 27 gr")
        );

        articleList.add(
                new ObjectArticle(
                        5,
                        "Beneficios de las proteínas",
                        "Junio 2020",
                        R.drawable.articulo6,
                        "Las proteínas son el material de construcción para los músculos, ligamentos, tendones y órganos, además forman parte de las enzimas y de las hormonas. " +
                                "Aumentar la cantidad de proteínas en nuestra alimentación, sobre todo en personas que realizan ejercicio físico, ayuda a la creación y mantenimiento " +
                                "de la masa muscular y de la fuerza, además aumenta la saciedad lo que puede ayudar a la perdida de grasa y es importante para diversos procesos metabólicos.\n" +
                                "Algunos alimentos con una buena cantidad de proteínas son: huevos, leche, diferentes cortes de carne, frijoles y queso.")
        );

        return articleList;
    }

}
