package com.majcher.springmvcexample.infrastructure


import com.majcher.springmvcexample.domain.BookRepository
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
class BookControllerSpecIT extends Specification {

    @Autowired
    WebApplicationContext context

    @Autowired
    com.majcher.springmvcexample.domain.Facade facade

    @SpringBean
    BookRepository bookRepository = Stub()

    MockMvc mockMvc

    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    def "return list of books when user use getBooks"() {
        given:
            bookRepository.findAll() >> List.of(com.majcher.springmvcexample.domain.Book.builder().id(1).title("title").build())
        when:
            ResultActions books = mockMvc.perform(get("/books"))
        then:
            books.andExpect(status().isOk())
                    .andExpect(content().json("""
                    [
                        { "id": 1, "title": "title" }
                    ]
                    """, true))
                    .andDo(MockMvcResultHandlers.print())
    }
}
