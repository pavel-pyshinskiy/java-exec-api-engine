package ru.pyshsoft.java.exec.api.service.compile

import org.springframework.stereotype.Component
import javax.tools.*

@Component
class InMemoryFileManager(fileManager: StandardJavaFileManager)
    : ForwardingJavaFileManager<StandardJavaFileManager>(fileManager) {

    lateinit var javaFileObject: InMemoryJavaFileObject

    override fun getJavaFileForOutput(location: JavaFileManager.Location?,
                                      className: String,
                                      kind: JavaFileObject.Kind,
                                      sibling: FileObject?): JavaFileObject {
        javaFileObject = InMemoryJavaFileObject(className, kind)
        return javaFileObject
    }
}