package ru.pyshsoft.java.exec.api.engine.service.compile

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception
import javax.tools.*

interface CompilationService {

    fun compile(className: String, source: String): Class<*>
}


@Component
class CompilationServiceImpl : CompilationService {

    @Autowired
    lateinit var compiler: JavaCompiler

    @Autowired
    lateinit var inMemoryFileManager: InMemoryFileManager

    override fun compile(className: String, source: String) : Class<*> {
        val files: List<CharSequenceJavaFileObject> = arrayListOf(CharSequenceJavaFileObject(className, source))
        compiler.getTask(null, inMemoryFileManager, null, null, null, files).call()
        return DynamicClassLoader(inMemoryFileManager).loadClass(className)
    }
}