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
package com.ly.train.flower.common.sample.condition;

import org.junit.Test;
import com.ly.train.flower.common.sample.TestBase;
import com.ly.train.flower.common.sample.condition.service.ServiceA;
import com.ly.train.flower.common.sample.condition.service.ServiceB;
import com.ly.train.flower.common.sample.condition.service.ServiceC;
import com.ly.train.flower.common.sample.condition.service.ServiceD;
import com.ly.train.flower.common.sample.condition.service.ServiceE;
import com.ly.train.flower.common.sample.condition.service.ServiceF;
import com.ly.train.flower.common.sample.condition.service.ServiceG;
import com.ly.train.flower.common.service.container.FlowerFactory;
import com.ly.train.flower.common.service.container.ServiceFactory;
import com.ly.train.flower.common.service.container.ServiceFlow;

public class Sample extends TestBase{

  @Test
  public void main() throws Exception {
    buildServiceEnv(flowerFactory);
    flowerFactory.getServiceFacade().asyncCallService("sample", "c");
  }

  public void buildServiceEnv(FlowerFactory flowerFactory) {
    ServiceFactory serviceFactory = flowerFactory.getServiceFactory();
    serviceFactory.registerService("serviceA", ServiceA.class);
    serviceFactory.registerService("serviceB", ServiceB.class);
    serviceFactory.registerService("serviceC", ServiceC.class);
    serviceFactory.registerService("serviceE", ServiceE.class);
    serviceFactory.registerService("serviceD", ServiceD.class);
    serviceFactory.registerService("serviceF", ServiceF.class);
    serviceFactory.registerService("serviceG", ServiceG.class);
    serviceFactory.registerService("serviceCondition",
        "com.ly.train.flower.common.service.impl.ConditionService;serviceF,serviceG");

    ServiceFlow serviceFlow = ServiceFlow.getOrCreate("sample", serviceFactory);

    serviceFlow.buildFlow("serviceA", "serviceB");
    serviceFlow.buildFlow("serviceA", "serviceC");
    serviceFlow.buildFlow("serviceC", "serviceD");
    serviceFlow.buildFlow("serviceC", "serviceE");
    serviceFlow.buildFlow("serviceE", "serviceCondition");
    serviceFlow.buildFlow("serviceCondition", "serviceF");
    serviceFlow.buildFlow("serviceCondition", "serviceG");

  }

}
