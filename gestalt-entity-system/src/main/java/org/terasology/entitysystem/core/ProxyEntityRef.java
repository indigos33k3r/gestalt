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

package org.terasology.entitysystem.core;

import com.google.common.base.Preconditions;
import org.terasology.util.collection.TypeKeyedMap;

import java.util.Optional;
import java.util.Set;

/**
 *
 */
public class ProxyEntityRef implements EntityRef {

    private EntityRef ref;

    public ProxyEntityRef(EntityRef ref) {
        Preconditions.checkNotNull(ref);
        this.ref = ref;
    }

    public EntityRef getActualRef() {
        return ref;
    }

    public void setActualRef(EntityRef ref) {
        Preconditions.checkNotNull(ref);
        this.ref = ref;
    }

    @Override
    public long getId() {
        return ref.getId();
    }

    @Override
    public long getRevision() {
        return ref.getRevision();
    }

    @Override
    public boolean isPresent() {
        return ref.isPresent();
    }

    @Override
    public <T extends Component> Optional<T> getComponent(Class<T> componentType) {
        return ref.getComponent(componentType);
    }

    @Override
    public Set<Class<? extends Component>> getComponentTypes() {
        return ref.getComponentTypes();
    }

    @Override
    public TypeKeyedMap<Component> getComponents() {
        return ref.getComponents();
    }

    @Override
    public <T extends Component> T addComponent(Class<T> componentType) {
        return ref.addComponent(componentType);
    }

    @Override
    public <T extends Component> void removeComponent(Class<T> componentType) {
        ref.removeComponent(componentType);
    }

    @Override
    public void delete() {
        ref.delete();
    }
}
