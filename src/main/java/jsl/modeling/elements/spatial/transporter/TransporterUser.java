/*
 * Copyright (c) 2018. Manuel D. Rossetti, rossetti@uark.edu
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package jsl.modeling.elements.spatial.transporter;

import jsl.modeling.ModelElement;
import jsl.modeling.queue.QObject;

public class TransporterUser extends TransporterUserAbstract {

    public TransporterUser(ModelElement parent) {
        this(parent, null);
    }

    public TransporterUser(ModelElement parent, String name) {
        super(parent, name);
    }

    @Override
    public void idleMoveComplete(Transporter transporter) {
    }

    @Override
    public void emptyMoveComplete(Transporter transporter) {
    }

    @Override
    public void transportComplete(Transporter transporter) {
    }

    @Override
    public void idleTransporterProvided(Transporter transporter, QObject request) {
    }

    @Override
    public LoadInfoIfc getLoadInfo() {
        return null;
    }
}