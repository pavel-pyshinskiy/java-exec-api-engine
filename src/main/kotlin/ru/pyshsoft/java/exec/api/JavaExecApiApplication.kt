package ru.pyshsoft.java.exec.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaExecApiApplication

fun main(args: Array<String>) {
	runApplication<JavaExecApiApplication>(*args)
}
