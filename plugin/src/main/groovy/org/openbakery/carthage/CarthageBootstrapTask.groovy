package org.openbakery.carthage


import org.gradle.api.tasks.TaskAction
import org.gradle.internal.logging.text.StyledTextOutputFactory
import org.openbakery.output.ConsoleOutputAppender
import org.openbakery.xcode.Type


class CarthageBootstrapTask extends AbstractCarthageTaskBase {

	CarthageBootstrapTask() {
		super()
		setDescription "Check out and build the Carthage project dependencies"
		this.setOnlyIf {
			cartfileExists()
		}
	}

	boolean cartfileExists() {
		File cartfile = new File(project.projectDir, "Cartfile")
		return cartfile.exists()
	}

	@TaskAction
	void bootstrap() {
		def output = services.get(StyledTextOutputFactory).create(CarthageUpdateTask)
		run(ACTION_BOOTSTRAP, output)
	}





}