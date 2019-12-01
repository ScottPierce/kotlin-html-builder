package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.defer
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.backgroundColor
import dev.scottpierce.html.writer.style.styleSheet
import kotlin.test.BeforeTest
import kotlin.test.Test

class StyleBuilderTests {
    @BeforeTest
    fun beforeTest() {
        WriteOptions.default = WriteOptions.readable.copy(indent = "    ")
    }

    @Test
    fun empty() {
        StringBuilderHtmlWriter().apply {
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
        StringBuilderHtmlWriter().apply {
            html {
                defer {
                    styleSheet(page.styleSheet)
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
}
