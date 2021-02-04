package ru.pyshsoft.java.exec.api.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.pyshsoft.java.exec.api.service.ExecService

@RestController
@RequestMapping("/exec")
class ExecController {

    @Autowired
    lateinit var execService: ExecService

    @PostMapping
    fun exec(@RequestBody source: String) = execService.exec(source)
}