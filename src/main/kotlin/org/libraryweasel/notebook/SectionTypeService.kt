/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import org.libraryweasel.notebook.api.SectionType
import org.libraryweasel.servo.Callback
import org.libraryweasel.servo.Component
import org.libraryweasel.web.api.WebRoute

@Callback(SectionType::class)
@Component(WebRoute::class)
class SectionTypeService: WebRoute {
    override val httpMethod: HttpMethod = HttpMethod.GET
    override val rootPath: String = "${notebookPath}sectiontypes/"

    override fun initRoute(route: Route) {
        TODO("not implemented")
    }

    private val sections = mutableListOf<SectionType>()

    fun addSectionSupport(sectionType: SectionType) {
        sections.add(sectionType)
    }

    fun removeSectionSupport(sectionType: SectionType) {
        sections.remove(sectionType)
    }
}
