/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook.api

data class Notebook(val id: Long, val owner: String, val title: String, val content: String)

interface NotebookManager {
    fun addNotebook(owner: String, title: String, content: String)
    fun removeNotebook(id: Long)
    fun updateNotebook(id: Long, owner: String, title: String, content: String)
    fun userNotebooks(owner: String): List<Notebook>
}
