/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.notebook.api

interface SectionType {
    val typeName: String
    val displayName: String
    val description: String
    val elementName: String
    val path: String
}
