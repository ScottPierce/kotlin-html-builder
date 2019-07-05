// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.section(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style)
    SelectContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun HtmlWriter.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style, attrs)
    SelectContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun HtmlWriter.section(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style, attrs)
    SelectContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun BodyContext.section(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style)
    SelectContext(writer).apply(func)
    writer.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun BodyContext.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    SelectContext(writer).apply(func)
    writer.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun BodyContext.section(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: SelectContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    SelectContext(writer).apply(func)
    writer.writeNormalElementEnd("section")
}
