/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jutils.jhardware.info.bios.windows;

import com.profesorfalken.wmi4java.WMI4Java;
import com.profesorfalken.wmi4java.WMIClass;
import java.util.Map;
import org.jutils.jhardware.info.bios.AbstractBiosInfo;

/**
 * Information related to BIOS
 * 
 * @author Javier Garcia Alonso
 */
public final class WindowsBiosInfo extends AbstractBiosInfo {

    /**
     *
     * @return
     */
    @Override
    protected Map<String, String> parseInfo() {
        Map<String, String> biosDataMap = 
                WMI4Java.get().VBSEngine().getWMIObject(WMIClass.CIM_BIOSELEMENT);

        biosDataMap.put("Release Date", biosDataMap.get("InstallDate"));
        biosDataMap.put("Vendor", 
                biosDataMap.get("Manufacturer"));
        biosDataMap.put("Version", biosDataMap.get("Version"));

        return biosDataMap;
    }
}
