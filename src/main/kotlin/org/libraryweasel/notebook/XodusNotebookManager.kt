/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import org.libraryweasel.notebook.api.NotebookManager
import org.libraryweasel.servo.Component

@Component(NotebookManager::class)
class XodusNotebookManager: NotebookManager {
    override fun addNotebook(owner: String, title: String, content: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeNotebook(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNotebook(id: String, owner: String, title: String, content: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
