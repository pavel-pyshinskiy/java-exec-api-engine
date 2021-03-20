package ru.pyshsoft.java.exec.api.engine.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.pyshsoft.java.exec.api.engine.service.compile.CompilationService

@SpringBootTest
class CompilationServiceTest {

    @Autowired
    lateinit var compilationService: CompilationService

    @Test
    fun test() {
        val sourceCode = """
            package ru.pyshinskiy;
            
            public class Main {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                }
            } """
        compilationService.compile("ru.pyshinskiy.Main", sourceCode)
    }

}