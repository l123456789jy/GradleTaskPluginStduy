package com.demo.buildsrc

import org.gradle.api.Plugin
import org.gradle.api.Project
import sun.security.ssl.HelloExtension

/**
 * 插件入口
 */
public class SecondPlugin implements Plugin<Project> {

  void apply(Project project) {
    def log = project.logger
    log.error "========================";
    log.error "Javassist开始修改Class!";
    log.error "========================";
    project.extensions.create('hello', MyHelloExtension)
    project.task('welcome') {
      doLast {
        MyHelloExtension ext = project.extensions.hello;
        println ext.enable ? "Hello ${ext.text}!" : 'HelloPlugin is disabled.'
      }
    }
  }

//    project.android.registerTransform(new JavassistTransform(project))
  }
