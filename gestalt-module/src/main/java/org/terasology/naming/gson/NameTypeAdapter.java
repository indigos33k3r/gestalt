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

package org.terasology.naming.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.terasology.naming.Name;

import java.lang.reflect.Type;

/**
 * Gson type adapter for serializing and deserializing Names
 *
 * @author Immortius
 */
public class NameTypeAdapter implements JsonDeserializer<Name>, JsonSerializer<Name> {

    @Override
    public Name deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Name(json.getAsString());
    }

    @Override
    public JsonElement serialize(Name src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.toString());
    }
}
