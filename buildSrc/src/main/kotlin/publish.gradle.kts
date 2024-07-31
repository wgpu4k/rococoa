import org.jreleaser.model.api.deploy.maven.MavenCentralMavenDeployer.Stage
import org.jreleaser.model.Active

plugins {
    `maven-publish`
    id("org.jreleaser")
}


jreleaser {
    gitRootSearch = true

    project {
        description = "Rococoa allows you to call Objective-C code through Java classes and interfaces that you define."
        copyright = "MIT"
    }

    signing {
        active = Active.ALWAYS
        armored = true
        artifacts = true
    }

    deploy {
        active = Active.ALWAYS
        maven {
            active = Active.ALWAYS
            mavenCentral {
                active = Active.ALWAYS
                create("sonatype") {
                    stage = Stage.UPLOAD
                    active = Active.ALWAYS
                    url = "https://central.sonatype.com/api/v1/publisher"
                    stagingRepository("build/staging-deploy")
                }
            }
        }
    }

    release {
        github {
            skipRelease = true
            skipTag = true
            overwrite = false
            token = "none"
        }
    }
}

publishing {
    repositories {
        maven {
            if (isSnapshot()) {
                name = "GitLab"
                url = uri("https://gitlab.com/api/v4/projects/25805863/packages/maven")
                credentials(HttpHeaderCredentials::class) {
                    name = "Authorization"
                    value = "Bearer ${System.getenv("GITLAB_TOKEN")}"
                }
                authentication {
                    create<HttpHeaderAuthentication>("header")
                }
            } else {
                url = layout.buildDirectory.dir("staging-deploy").get().asFile.toURI()
            }
        }
    }
}
