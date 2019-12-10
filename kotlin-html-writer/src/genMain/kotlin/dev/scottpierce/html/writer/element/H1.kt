// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.h1(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("h1", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("h1")
    }
}

@HtmlDsl
inline fun HtmlOutput.h1(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("h1", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("h1")
    }
}

@HtmlDsl
inline fun HtmlOutput.h1(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("h1", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("h1")
    }
}

@HtmlDsl
inline fun BodyContext.h1(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("h1", id, classes, style)
    func()
    htmlWriter.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun BodyContext.h1(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("h1", id, classes, style, attrs)
    func()
    htmlWriter.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun BodyContext.h1(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("h1", id, classes, style, attrs)
    func()
    htmlWriter.writeNormalElementEnd("h1")
}
