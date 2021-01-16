package ru.pyshsoft.java.exec.api.service

import org.springframework.stereotype.Component

interface CompilationService {

    fun compile(source: String): Byte
}


@Component
class CompilationServiceImpl : CompilationService {
    override fun compile(source: String): Byte {
        TODO("Not yet implemented")
    }
}