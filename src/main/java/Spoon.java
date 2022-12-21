

import processor.ClassLoggingProcessor;
import processor.ConstructorLoggingProcessor;
import processor.LoggingProcessor;
import spoon.Launcher;

import java.text.ParseException;

public class Spoon {

		static ClassLoggingProcessor classLoggingProcessor;
		static ConstructorLoggingProcessor constructorLoggingProcessor;
		static LoggingProcessor loggingProcessor;

		static String sourcePath = "Q1_CLI_ApplicationTest/src";
		static String outputPath = "spooned/src";
		static String outputBinPath = "";
		static String classpath = "";

		public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException {
			Launcher spoon = new Launcher();

			spoon.addInputResource(sourcePath);
			spoon.setSourceOutputDirectory(outputPath);
			if (!classpath.equals("")) {
				spoon.getEnvironment().setSourceClasspath(new String[] {classpath});
			} else {
				spoon.getEnvironment().setNoClasspath(true);
			}
			spoon.setBinaryOutputDirectory(outputBinPath);
			spoon.getEnvironment().setAutoImports(true);
			classLoggingProcessor = new ClassLoggingProcessor();
			constructorLoggingProcessor = new ConstructorLoggingProcessor();
			loggingProcessor = new LoggingProcessor();
			spoon.addProcessor(classLoggingProcessor);
			spoon.addProcessor(constructorLoggingProcessor);
			spoon.addProcessor(loggingProcessor);
			spoon.run();
		}

	}
