package ru.pyshsoft.java.exec.api.engine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.tools.JavaCompiler
import javax.tools.StandardJavaFileManager
import javax.tools.ToolProvider

@SpringBootApplication
class JavaExecApiEngineApplication {

	@Bean
	fun javaCompiler(): JavaCompiler = ToolProvider.getSystemJavaCompiler()

	@Bean
	fun standardJavaFileManager(): StandardJavaFileManager = javaCompiler().getStandardFileManager(null,
			null, null)

}

fun main(args: Array<String>) {
	runApplication<JavaExecApiEngineApplication>(*args)
}
