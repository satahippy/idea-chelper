package net.egork.chelper.codegeneration;

import com.intellij.openapi.project.Project;
import net.egork.chelper.task.Task;
import net.egork.chelper.task.TestType;
import net.egork.chelper.util.Utilities;

import java.util.Arrays;
import java.util.HashSet;

public class ResultGenerator {

	public static String createSource(final Task task, final Project project) {
		Task resultTask = task.setTestType(TestType.SINGLE);
		SolutionGenerator generator = new SolutionGenerator(new HashSet<String>(Arrays.asList(Utilities.getData(project).excludedPackages)),
			SolutionGenerator.createMainClassTemplate(resultTask, project), true,
			MainFileTemplate.getMethod(project, resultTask.taskClass, "solve", "void", "int", resultTask.inputClass, resultTask.outputClass)
		);
		return generator.createInlinedSource();
	}

}
