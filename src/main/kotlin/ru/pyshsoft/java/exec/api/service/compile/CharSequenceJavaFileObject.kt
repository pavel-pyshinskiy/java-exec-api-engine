package ru.pyshsoft.java.exec.api.service.compile

import java.net.URI
import javax.tools.JavaFileObject
import javax.tools.SimpleJavaFileObject

class CharSequenceJavaFileObject(className: String, private val source: CharSequence)
    : SimpleJavaFileObject(URI.create("string:///"
        + className.replace('.', '/')
        + JavaFileObject.Kind.SOURCE.extension),
        JavaFileObject.Kind.SOURCE) {

    override fun getCharContent(ignoreEncodingErrors: Boolean): CharSequence {
        return source
    }
}