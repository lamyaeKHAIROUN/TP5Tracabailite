package processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtParameter;
import spoon.support.reflect.declaration.CtConstructorImpl;

import java.util.List;

public class LoggingProcessor extends AbstractProcessor<CtExecutable> {

	@Override
	public boolean isToBeProcessed(CtExecutable candidate) {
		if (candidate.getClass().getSimpleName().equals(CtConstructorImpl.class.getSimpleName())) {
			return false;
		}
		return true;
	}

	@Override
	public void process(CtExecutable element) {
		if (isToBeProcessed(element)) {
			CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
			StringBuilder sb = new StringBuilder();
			List params = element.getParameters();
			if (isNotUserMethods(element)) {
				sb.append("Main.getUser().toString()");
				sb.append("+ \";\" +");
			}
			else {
				boolean isBeforePenultimate = true;
				for (int i = 0; i < params.size(); i++) {
					CtParameter param = (CtParameter) params.get(i);
					sb.append(param.getSimpleName() + ".toString()");
					isBeforePenultimate = i < (params.size() - 1);
					if (isBeforePenultimate) {
						sb.append("+ \";\" +");
					}
				}
			}

			final String value = String.format("LOGGER.info(%s)", sb.toString());
			snippet.setValue(value);

			if (element.getBody() != null) {
				element.getBody().insertBegin(snippet);
			}
		}
	}

	private boolean isNotUserMethods(CtExecutable element) {
		return isNotGetUserMethod(element) && isNotToStringMethod(element);
	}

	private boolean isNotToStringMethod(CtExecutable element) {
		// ne pas traiter la methode toString
		if (element.getSimpleName().equals("toString")) {
			return false;
		}
		return true;
	}

	private boolean isNotGetUserMethod(CtExecutable element) {
		// ne pas traiter la methode getUser
		if (element.getSimpleName().equals("getUser")) {
			return false;
		}
		return true;
	}

}