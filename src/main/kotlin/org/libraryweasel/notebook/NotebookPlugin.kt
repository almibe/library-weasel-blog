/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook

import org.libraryweasel.notebook.api.SectionSupport
import org.libraryweasel.servo.Callback
import org.libraryweasel.servo.Component

@Component
@Callback(SectionSupport::class)
class NotebookPlugin {
    private val sections = mutableListOf<SectionSupport>()

    fun addSectionSupport(sectionSupport: SectionSupport) {
        sections.add(sectionSupport)
    }

    fun removeSectionSupport(sectionSupport: SectionSupport) {
        sections.remove(sectionSupport)
    }
}
