package br.edu.iffar.aula;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;

public class ProgramaTeste {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException,
            NoSuchMethodException,
            InstantiationException, InvocationTargetException, ClassNotFoundException {
        //primeira coisa é obter o class
        Class c1 = ArCondicionado.class;
        //instanciação
        ArCondicionado ar = new ArCondicionado ("Philco");

        //pode obter através do objeto, o ar
        Class c2 = ar.getClass();
        System.out.println(c2.getName());

        System.out.println(DriverManager.class.getName());// mostra de onde vem

        //pegar atributos de arCondcionado

        Field [] atributos = c1.getFields();//precisa importar a classe Field
        for (Field field: atributos){
            System.out.println(field.getName());//imprime só o público
        }
        //para pegar todos usa-se *Declared + alguma coisa*

        atributos =c1.getDeclaredFields();
        for (Field field: atributos){
            System.out.println(field.getName());//imprime só o público
        }
        //modo tradicional
        System.out.println(ar.marca);
        //com reflexão
        //pega a referência ao campo
        try {
            Field campo = c1.getField("marca");//precisa tratar exceção
            Object marca = campo.get(ar);
            System.out.println(marca);
        } catch (NoSuchFieldException erro){
            System.out.println("Falha ao buscar o campo" + erro.getMessage());

        }

        //criar instancia de objeto a psrtir de construtor
        Constructor <ArCondicionado> construct = c1.getConstructor(String.class);
        ar  =  construct.newInstance("Samsung");
        //new Instance é equivalente a new ArCondicionado ("")
        System.out.println(ar.marca);

        //quantos construtores tem a classe String
        System.out.println(String.class.getDeclaredConstructors().length);

        Method method = c1.getMethod("ligar");
        method.invoke(ar);
        System.out.println(c1.getDeclaredMethods().length);

    }
}
