/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.handler.StaticHandler
import org.libraryweasel.servo.Component
import org.libraryweasel.web.api.WebRoute

@Component(WebRoute::class)
class NotebookStaticResources: WebRoute {
    override val httpMethod: HttpMethod = HttpMethod.GET
    override val rootPath: String = "$notebookPath*"

    override fun initRoute(route: Route) {
        route.handler(StaticHandler.create("webroot", this.javaClass.classLoader))
    }
}

