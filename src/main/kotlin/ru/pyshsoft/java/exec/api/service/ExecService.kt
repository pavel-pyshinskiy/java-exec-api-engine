package ru.pyshsoft.java.exec.api.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

interface ExecService {

    fun exec(source: String): String
}

@Component
class ExecServiceIml() : ExecService {

    @Autowired
    lateinit var compilationService: CompilationService

    @Autowired
    lateinit var instantiationService: InstantiationService

    override fun exec(source: String): String {

        return ""
    }

}