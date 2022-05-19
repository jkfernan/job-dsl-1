import javaposse.jobdsl.plugin.JenkinsDslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement
import javaposse.jobdsl.plugin.ScriptRequestGenerator
import javaposse.jobdsl.dsl.ScriptRequest
import hudson.EnvVars
import hudson.FilePath

// the folder where you can find the job dsl scripts and classes
String jobDslRoot = "/config/job-dsl"

def workspace = new File(jobDslRoot)
def jobManagement = new JenkinsJobManagement(System.out, [:], workspace)
JenkinsDslScriptLoader scriptLoader = new JenkinsDslScriptLoader(jobManagement)

ScriptRequestGenerator scriptGenerator = new ScriptRequestGenerator(new FilePath(workspace), new EnvVars())

Set<ScriptRequest> scripts = scriptGenerator.getScriptRequests(
  "*", // targets
  false, // usingScriptText
  null, // scriptText
  true, // ignoreExisting
  false, // ignoreMissingFiles
  "." // additionalClasspath
)

scriptLoader.runScripts(scripts)
