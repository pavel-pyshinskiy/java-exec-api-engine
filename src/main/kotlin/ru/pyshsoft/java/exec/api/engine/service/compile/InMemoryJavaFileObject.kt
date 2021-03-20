package ru.pyshsoft.java.exec.api.engine.service.compile

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.net.URI
import javax.tools.JavaFileObject
import javax.tools.SimpleJavaFileObject

class InMemoryJavaFileObject(name: String,
                             kind: JavaFileObject.Kind,
                             private val os: ByteArrayOutputStream = ByteArrayOutputStream())
    : SimpleJavaFileObject(
        URI.create("string:///" + name.replace('.', '/') + kind.extension), kind) {

    fun getBytes() : ByteArray {
        return os.toByteArray()
    }

    override fun openOutputStream(): OutputStream {
        return os
    }
}