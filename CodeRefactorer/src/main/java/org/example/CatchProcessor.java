package org.example;

import spoon.Launcher;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtElement;
import spoon.*;

public class CatchProcessor extends AbstractProcessor<CtCatch> {

    @Override
    public void process(CtCatch catchBlock) {
        if(catchBlock.getBody().getStatements().isEmpty()) {
            CtCatchVariable<? extends Throwable> catchParameter = catchBlock.getParameter();
            String catchStatementString = "System.out.println(" + catchParameter.getSimpleName() + ")";
            CtComment comment = getFactory().createComment("Empty catch block was resolved", CtComment.CommentType.BLOCK);
            CtCodeSnippetStatement catchStatement = getFactory().Code()
                    .createCodeSnippetStatement(catchStatementString);
            catchBlock.setBody(catchStatement);
            catchBlock.addComment(comment);
        }
        /*
        for(CtElement element : catchBlock.getParent().getDirectChildren()) {
            if (element.toString().equals("finally")) {
                CtBlock block = element.
            }
        } */
    }

    public static void main(String args[]) {
        Launcher launcher = new Launcher();
        launcher.addInputResource("/Users/arunvs/IdeaProjects/LinkedList/src/Main.java");
        launcher.buildModel();
        CtElement astRoot = launcher.getModel().getRootPackage();

    }
}
