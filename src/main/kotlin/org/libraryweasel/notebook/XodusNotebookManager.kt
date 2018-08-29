/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import org.libraryweasel.notebook.api.Notebook
import org.libraryweasel.notebook.api.NotebookManager
import org.libraryweasel.servo.Component
import org.libraryweasel.servo.Service
import org.libraryweasel.xodus.api.EntityStoreInstanceManager

@Component(NotebookManager::class)
class XodusNotebookManager: NotebookManager {
    @Service @Volatile
    lateinit var entityStore: EntityStoreInstanceManager
    private val entityType = "lw.notebook"

    override fun addNotebook(owner: String, title: String, content: String) {
        entityStore.instance.computeInTransaction {
            val entity = it.newEntity(entityType)
            entity.setProperty("owner", owner)
            entity.setProperty("title", title)
            entity.setProperty("content", content)
            true
        }
    }

    override fun removeNotebook(id: Long) {
        entityStore.instance.computeInTransaction {
            val result = it.findIds(entityType, id, id)
            if (!result.isEmpty) {
                result.first!!.delete()
            }
            true
        }
    }

    override fun updateNotebook(id: Long, owner: String, title: String, content: String) {
        entityStore.instance.computeInTransaction {
            val result = it.findIds(entityType, id, id)
            if (!result.isEmpty) {
                val entity = result.first!!
                entity.setProperty("owner", owner)
                entity.setProperty("title", title)
                entity.setProperty("content", content)
            }
            true
        }
    }

    override fun userNotebooks(owner: String): List<Notebook> {
        return entityStore.instance.computeInTransaction {
            val result = it.find(entityType, "owner", owner)
            result.map { entity ->
                val owner = entity.getProperty("owner") as String
                val title = entity.getProperty("title") as String
                val content = entity.getProperty("content") as String
                Notebook(entity.id.localId, owner, title, content)
            }
        }
    }
}
