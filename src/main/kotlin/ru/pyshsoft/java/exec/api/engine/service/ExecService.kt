package ru.pyshsoft.java.exec.api.engine.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.pyshsoft.java.exec.api.engine.service.compile.CompilationService
import java.io.ByteArrayOutputStream
import java.io.PrintStream

interface ExecService {

    fun exec(source: String): String
}

@Component
class ExecServiceIml : ExecService {

    @Autowired
    lateinit var compilationService: CompilationService

    override fun exec(source: String): String {
        val clazz = compilationService.compile(extractClassName(source), source)
        val byteArrayOutputStream = ByteArrayOutputStream()
        val resultPrintStream = PrintStream(byteArrayOutputStream)
        val originPrintStream = System.out
        System.setOut(resultPrintStream)
        clazz.getMethod("main", Array<String>::class.java).invoke(clazz, arrayOf<String>())
        System.setOut(originPrintStream)
        return String(byteArrayOutputStream.toByteArray())
    }

    private fun extractClassName(source: String): String {
        //TODO take two regex into universal one to simplify the code
        val packageNameRegex = """package ([^;]+)""".toRegex()
        val classNameRegex = """.*class ([^{]+)""".toRegex()
        val packageMatchResult = packageNameRegex.find(source)
        val classNameMatchResult = classNameRegex.find(source)
        return packageMatchResult?.groups?.get(1)?.value.orEmpty().plus(".")
                .plus(classNameMatchResult?.groups?.get(1)?.value.orEmpty().replace("""\s""".toRegex(), ""))
    }

}