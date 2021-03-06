/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.train.flower.common.sample.supervisor.service;

import com.ly.train.flower.common.sample.supervisor.model.Message2;
import com.ly.train.flower.common.service.Service;
import com.ly.train.flower.common.service.container.ServiceContext;

public class Service2 implements Service<Message2, Integer> {

  @Override
  public Integer process(Message2 message, ServiceContext context) throws Throwable {

    // File file = new File("test.file");
    // if (!file.exists()) {
    // FileUtils.write(file, "111", "UTF-8");
    // throw new Exception("Service2");
    // }
    return message.getAge() + 1;
  }

}
