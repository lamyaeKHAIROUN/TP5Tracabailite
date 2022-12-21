package processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtConstructor;

public class ConstructorLoggingProcessor extends AbstractProcessor<CtConstructor> {

	@Override
	public void process(CtConstructor element) {
		String statement = "try { fileHandler = new FileHandler(\"" + element.getDeclaringType().getSimpleName()
				+ ".log\",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe(\"Impossible to open FileHandler\"); }"
				+ "catch (IOException e) { LOGGER.severe(\"Impossible to open FileHandler\"); }";
		final CtCodeSnippetStatement statementInConstructor = getFactory().Code().createCodeSnippetStatement(statement);
		//Ajouter une instruction au constructeur au début
		element.getBody().addStatement(statementInConstructor);
	}
}
