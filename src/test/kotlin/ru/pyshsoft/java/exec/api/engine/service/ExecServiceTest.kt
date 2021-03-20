package ru.pyshsoft.java.exec.api.engine.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExecServiceTest {

    @Autowired
    lateinit var execService: ExecService

    @Test
    fun testExecution() {
        val sourceCode = """
            package ru.pyshinskiy;
            
            public class Main {
                public static void main(String[] args) {
                    System.out.println("Hello, World!");
                }
            } """
        val expectedOutput = "Hello, World!"
        val actualOutput = execService.exec(sourceCode)
        assertEquals(expectedOutput, actualOutput.trim())
    }

}