package org.example;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        SpoonAPI spoon = new Launcher();
        spoon.addProcessor(new AuthorDocProcessor());
        spoon.addProcessor(new CatchProcessor());
        //spoon.addProcessor(new MethodDocProcessor());
        spoon.addInputResource("src/test/java/Test.java");
        spoon.setSourceOutputDirectory("src/test/java");

        CtModel model = spoon.buildModel();
        spoon.process();
        spoon.prettyprint();

    }
}