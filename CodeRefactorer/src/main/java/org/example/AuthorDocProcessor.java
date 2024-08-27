package org.example;

import spoon.processing.AbstractProcessor;
import spoon.refactoring.CtRenameLocalVariableRefactoring;
import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtClass;

public class AuthorDocProcessor extends AbstractProcessor<CtClass<?>> {
    @Override
    public void process(CtClass<?> ctClass) {
        if(!ctClass.getDocComment().contains("@Author")) {
            CtComment comment = getFactory().createComment("@Author <author name>", CtComment.CommentType.JAVADOC);
            ctClass.addComment(comment);
        }

        //CtRenameLocalVariableRefactoring ctd = new CtRenameLocalVariableRefactoring();
    }
}
