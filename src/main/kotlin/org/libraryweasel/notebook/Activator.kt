/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import org.apache.felix.dm.DependencyActivatorBase
import org.apache.felix.dm.DependencyManager
import org.libraryweasel.servo.LibraryWeaselComponentRegistrar
import org.osgi.framework.BundleContext

class Activator : DependencyActivatorBase() {
    override fun init(context: BundleContext, manager: DependencyManager) {
        val registrar = LibraryWeaselComponentRegistrar(manager)
        registrar.register(SectionTypeService::class.java)
        registrar.register(NotebookStaticResources::class.java)
        registrar.register(XodusNotebookManager::class.java)
    }

    override fun destroy(context: BundleContext, manager: DependencyManager) {
    }
}

const val notebookPath = "/notebook/"
