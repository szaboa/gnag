/**
 * Copyright 2016 Bryan Kelly
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.btkelly.gnag.utils.gson;

import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by bobbake4 on 4/28/16.
 */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

  private final TypeAdapter<T> adapter;

  GsonRequestBodyConverter(TypeAdapter<T> adapter) {
    this.adapter = adapter;
  }

  @Override
  public RequestBody convert(T value) throws IOException {
    String body = adapter.toJson(value);
    return RequestBody.create(MEDIA_TYPE, body);
  }
}
