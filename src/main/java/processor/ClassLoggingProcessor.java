package processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ClassLoggingProcessor extends AbstractProcessor<CtClass> {

	@Override
	public void process(CtClass element) {
		final CtTypeReference<Logger> loggerRef = getFactory().Code().createCtTypeReference(Logger.class);
		final CtTypeReference<FileHandler> fileHandlerRef = getFactory().Code().createCtTypeReference(FileHandler.class);
		final CtTypeReference<IOException> exceptionRef = getFactory().Code().createCtTypeReference(IOException.class);
		final CtField<Logger> loggerField = getFactory().Core().<Logger>createField();
		final CtField<FileHandler> handlerField = getFactory().Core().<FileHandler>createField();
		final CtField<IOException> exceptionField = getFactory().Core().<IOException>createField();

		loggerField.<CtField>setType(loggerRef);
		loggerField.<CtField>addModifier(ModifierKind.STATIC);
		loggerField.<CtField>addModifier(ModifierKind.PRIVATE);
		loggerField.setSimpleName("LOGGER");

		handlerField.<CtField>setType(fileHandlerRef);
		handlerField.<CtField>addModifier(ModifierKind.PRIVATE);
		handlerField.setSimpleName("fileHandler");
		
		exceptionField.<CtField>setType(exceptionRef);
		exceptionField.<CtField>addModifier(ModifierKind.PRIVATE);
		exceptionField.setSimpleName("e"+System.currentTimeMillis());

		String expression = "Logger.getLogger(" + element.getSimpleName() + ".class.getName())";
		final CtCodeSnippetExpression loggerExpression = getFactory().Code().createCodeSnippetExpression(expression);
		loggerField.setDefaultExpression(loggerExpression);

		element.addFieldAtTop(exceptionField);
		element.addFieldAtTop(handlerField);
		element.addFieldAtTop(loggerField);

	}

}
