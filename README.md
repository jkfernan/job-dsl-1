# job-dsl

Since [Job DSL v1.60](https://github.com/jenkinsci/job-dsl-plugin/wiki/Migration#migrating-to-160), classes in the workspace are no longer available on the classpath for import into Job DSL scripts.

This restriction applies when using Job DSL natively within [JCasC](https://github.com/jenkinsci/configuration-as-code-plugin#jenkins-configuration-as-code-aka-jcasc-plugin).

To circumvent this, you can use the [Configuration as Code Plugin - Groovy Scripting Extension](https://github.com/jenkinsci/configuration-as-code-groovy-plugin) to execute a groovy script that invokes Job DSL scripts and adds the workspace to the classpath.

## How This Repo Works

The JCasC config file [`jcasc.yaml`](./resources/jcasc.yaml) invokes [`init.groovy`](./resources/init.groovy) which in turn evaluates all of the Job DSL scripts in [job-dsl](./job-dsl).