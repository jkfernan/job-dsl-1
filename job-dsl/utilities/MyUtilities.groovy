package utilities

class MyUtilities {
  static void createFolder(def dsl, String folderName, String jobName, String repo, String filterInclude, String filterExclude, String libraryBranch, String configBranch, String configDir) {
      dsl.folder(folderName) {
          properties {
              templateConfigFolderProperty {
                  tier {
                      configurationProvider {
                          scmPipelineConfigurationProvider {
                              baseDir(configDir)
                              scm {
                                  gitSCM {
                                    browser {}
                                      userRemoteConfigs {
                                          userRemoteConfig {
                                              url('test.com')
                                              credentialsId('test')
                                              refspec('')
                                              name('')
                                          }
                                      }
                                      branches {
                                          branchSpec {
                                          name(configBranch)
                                          }
                                      }
                                    gitTool('')
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
      dsl.multibranchPipelineJob("$folderName/$jobName") {
          branchSources {
              branchSource {
                  source {
                      bitbucket {
                          serverUrl("bitbucket.com")
                          credentialsId("bitbucket creds")
                          repoOwner(jobName)
                          repository(repo)
                          traits {
                              bitbucketBranchDiscovery {
                                  strategyId(3)
                              }
                              headWildcardFilter {
                                  includes(filterInclude)
                                  excludes(filterExclude)
                              }
                          }
                      }
                  }
              }
          }
          properties {
              templateConfigFolderProperty {
                  tier {
                      librarySources {
                          librarySource {
                              libraryProvider {
                                  scmLibraryProvider {
                                      baseDir('libraries')
                                      scm {
                                          gitSCM {
                                            browser {}
                                              userRemoteConfigs {
                                                  userRemoteConfig {
                                                      url('test.com')
                                                      credentialsId('test')
                                                      refspec('')
                                                  name('')
                                                  }
                                              }
                                              branches {
                                                  branchSpec {
                                                      name(libraryBranch)
                                                  }
                                              }
                                            gitTool('')
                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
  }
}
