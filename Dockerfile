FROM jenkins/jenkins:lts
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

# Install Plugins
COPY resources/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# Add JCasC
ENV CASC_JENKINS_CONFIG=/var/jenkins_home/casc_configs
COPY resources/jcasc.yaml /var/jenkins_home/casc_configs/jcasc.yaml
COPY resources/init.groovy /var/jenkins_home/casc_configs/init.groovy

ENV JOB_DSL_ROOT=/var/jenkins_home/job-dsl
RUN mkdir ${JOB_DSL_ROOT}
COPY job-dsl/ ${JOB_DSL_ROOT}

EXPOSE 8080