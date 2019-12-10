package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.BaseHtmlContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlOutput.styleSheet(styleSheetBuilder: StyleSheetBuilder) {
    pageWriterScope(this) {
        HtmlContext(this).styleSheet(styleSheetBuilder)
    }
}

@HtmlDsl
fun BaseHtmlContext.styleSheet(styleSheetBuilder: StyleSheetBuilder) {
    htmlWriter.apply {
        if (!isEmpty) newLine()

        write("<style type=\"text/css\">")
        indent()

        writeStyleSheetBuilder(styleSheetBuilder, this)

        unindent()
        newLine()
        write("</style>")
    }
}

private fun writeStyleSheetBuilder(ssb: StyleSheetBuilder, htmlWriter: HtmlWriter) {
    val styles = ssb._styles
    if (styles != null) {
        for ((selector, style) in styles) {
            htmlWriter.apply {
                newLine()

                write(selector)
                if (!options.minifyStyles) write(' ')
                write('{')
                indent()

                val context = StyleBuilderContext(htmlWriter, selector, ssb)
                context.style()

                unindent()
                newLine()
                write('}')
            }
        }
    }

    val mediaQueries = ssb._mediaQueries
    if (mediaQueries != null) {
        for ((selector, mediaSsb) in mediaQueries) {
            htmlWriter.apply {
                newLine()

                write("@media ").write(selector)
                if (!options.minifyStyles) write(' ')
                write('{')
                indent()

                writeStyleSheetBuilder(mediaSsb, htmlWriter)

                unindent()
                newLine()
                write('}')
            }
        }
    }
}
