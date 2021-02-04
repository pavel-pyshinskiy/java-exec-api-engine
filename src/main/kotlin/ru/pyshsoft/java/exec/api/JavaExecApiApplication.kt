package ru.pyshsoft.java.exec.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.pyshsoft.java.exec.api.service.compile.CompilationServiceImpl
import javax.tools.JavaCompiler
import javax.tools.StandardJavaFileManager
import javax.tools.ToolProvider

@SpringBootApplication
class JavaExecApiApplication {

	@Bean
	fun javaCompiler(): JavaCompiler = ToolProvider.getSystemJavaCompiler()

	@Bean
	fun standardJavaFileManager(): StandardJavaFileManager = javaCompiler().getStandardFileManager(null,
			null, null)

}

fun main(args: Array<String>) {
	runApplication<JavaExecApiApplication>(*args)
}
