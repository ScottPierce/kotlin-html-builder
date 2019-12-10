package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.defer
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.backgroundColor
import kotlin.test.BeforeTest
import kotlin.test.Test

class StyleBuilderTests {
    @BeforeTest
    fun beforeTest() {
        WriteOptions.default = WriteOptions.readable.copy(indent = "    ")
    }

    @Test
    fun empty() {
        StringHtmlOutput().apply {
            html {
                style(".test") {
                    backgroundColor(1, 1, 1)
                }
            }
        } assertEquals {
            """
            <html>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun basic() {
        StringHtmlOutput().apply {
            html {
                defer {
                    styleSheet(htmlWriter.styleSheet)
                }
                style(".test") {
                    backgroundColor(1, 1, 1)
                }
            }
        } assertEquals {
            """
            <html>
                <style type="text/css">
                    .test {
                        background-color: rgb(1,1,1);
                    }
                </style>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun basicMediaQuery() {
        StringHtmlOutput().apply {
            html {
                defer {
                    styleSheet(htmlWriter.styleSheet)
                }
                style(".test") {
                    backgroundColor(1, 1, 1)

                    media("minWidth < 100px") {
                        backgroundColor(2, 2, 2)
                    }
                    media("minWidth < 200px") {
                        backgroundColor(3, 3, 3)
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <style type="text/css">
                    .test {
                        background-color: rgb(1,1,1);
                    }
                    @media minWidth < 100px {
                        .test {
                            background-color: rgb(2,2,2);
                        }
                    }
                    @media minWidth < 200px {
                        .test {
                            background-color: rgb(3,3,3);
                        }
                    }
                </style>
            </html>
            """.trimIndent()
        }
    }
}
