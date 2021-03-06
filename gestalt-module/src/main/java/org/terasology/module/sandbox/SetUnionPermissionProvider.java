/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.module.sandbox;

import com.google.common.collect.ImmutableList;

import java.security.Permission;

/**
 * This permission provider is based on a union of PermissionSets. As long as one PermissionSet in the provider has the permission it is granted.
 *
 * @author Immortius
 */
public class SetUnionPermissionProvider implements PermissionProvider {

    private final ImmutableList<PermissionSet> permissionSets;

    public SetUnionPermissionProvider(Iterable<PermissionSet> permissionSets) {
        this.permissionSets = ImmutableList.copyOf(permissionSets);
    }

    @Override
    public boolean isPermitted(Class<?> type) {
        for (PermissionSet set : permissionSets) {
            if (set.isPermitted(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPermitted(Permission permission, Class<?> context) {
        for (PermissionSet set : permissionSets) {
            if (set.isPermitted(permission, context)) {
                return true;
            }
        }
        return false;
    }
}
