/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import org.libraryweasel.notebook.api.SectionType
import org.libraryweasel.servo.Callback
import org.libraryweasel.servo.Component
import org.libraryweasel.web.api.WebRoute

@Callback(SectionType::class)
@Component(WebRoute::class)
class SectionTypeService: WebRoute {
    private val sections = mutableListOf<SectionType>()
    override val httpMethod: HttpMethod = HttpMethod.GET
    override val rootPath: String = "${notebookPath}sectiontypes/"

    override fun initRoute(route: Route) {
        route.handler { routingContext ->
            val result = JsonObject()
            val sectionTypes = JsonArray()
            sections.forEach { section ->
                val currentSection = JsonObject()

                currentSection.addProperty("typeName", section.typeName)
                currentSection.addProperty("displayName", section.displayName)
                currentSection.addProperty("description", section.description)
                currentSection.addProperty("elementName", section.elementName)
                currentSection.addProperty("path", section.path)

                sectionTypes.add(currentSection)
            }

            result.add("sectionTypes", sectionTypes)

            routingContext.response().putHeader("content-type", "application/json")
                    .end(result.toString())
        }
    }


    fun addSectionType(sectionType: SectionType) {
        sections.add(sectionType)
    }

    fun removeSectionType(sectionType: SectionType) {
        sections.remove(sectionType)
    }
}
