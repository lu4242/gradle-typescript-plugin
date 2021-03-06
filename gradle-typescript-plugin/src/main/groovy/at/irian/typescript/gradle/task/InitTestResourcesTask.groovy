package at.irian.typescript.gradle.task

import org.gradle.api.tasks.TaskAction
import at.irian.typescript.gradle.util.ResourceUtil
import at.irian.typescript.gradle.TypeScriptPluginExtension

class InitTestResourcesTask extends TypeScriptPluginTask {

    @Override
    void setupInputsAndOutputs(TypeScriptPluginExtension extension) {
        outputs.file(new File(extension.getTestResourcesDir(), "jasmine.d.ts"))
    }

    @TaskAction
    void init() {
        File jasmineDir = TypeScriptPluginExtension.getInstance(project).getTestResourcesDir()
        jasmineDir.mkdirs()
        ResourceUtil.copyResource(jasmineDir, "/test-resources/jasmine/jasmine.d.ts")

    }


}
