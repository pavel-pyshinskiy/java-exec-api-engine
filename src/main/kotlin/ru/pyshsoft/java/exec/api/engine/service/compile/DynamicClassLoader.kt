package ru.pyshsoft.java.exec.api.engine.service.compile

class DynamicClassLoader(private val inMemoryFileManager: InMemoryFileManager): ClassLoader() {

    override fun loadClass(name: String?): Class<*> {
        return try {
            super.loadClass(name)
        } catch (ex: ClassNotFoundException) {
            defineClass(name, inMemoryFileManager.javaFileObject.getBytes(), 0,
                    inMemoryFileManager.javaFileObject.getBytes().size)
        }
    }
}