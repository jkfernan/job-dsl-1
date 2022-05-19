package utilities

class MyUtilities {
    static void createFolder(def dsl, String projectName, String libraryBranch, String configBranch, String configDir) {
        dsl.folder(projectName) {
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
    static void createJob(def dsl, String projectName, String repoName, String branchesInclude, String branchesExclude) {
        dsl.multibranchPipelineJob("$projectName/$repoName") {
            branchSources {
                branchSource {
                    source {
                        bitbucket {
                            serverUrl("bitbucket.com")
                            credentialsId("bitbucket creds")
                            repoOwner(projectName)
                            repository(repoName)
                            traits {
                                bitbucketBranchDiscovery {
                                    strategyId(3)
                                }
                                headWildcardFilter {
                                    includes(branchesInclude)
                                    excludes(branchesExclude)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
