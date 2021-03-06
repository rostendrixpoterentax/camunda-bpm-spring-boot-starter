/*
 * Copyright © 2015-2019 camunda services GmbH and various authors (info@camunda.com)
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
package org.camunda.bpm.spring.boot.starter.contextcache.nonpa;

import org.camunda.bpm.spring.boot.starter.contextcache.AbstractContextCacheTest;
import org.camunda.bpm.spring.boot.starter.test.nonpa.TestApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests {@link NonPaContextCacheTest1}, {@link NonPaContextCacheTest2}, {@link NonPaContextCacheTest3},
 * {@link NonPaContextCacheTest4}and {@link NonPaContextCacheTest5} are meant to be run together so that
 * ApplicationContext caching is tested.
 * See {@link NonPaContextCacheSuiteTest} for a detailed explanation.
 *
 * @author Nikola Koevski
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("contextcaching")
@SpringBootTest(
  classes = { TestApplication.class },
  properties = {
    "camunda.bpm.process-engine-name=foo",
    "spring.datasource.generate-unique-name=true",
    "test1Property=test1Value"
  },
  webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class NonPaContextCacheTest1 extends AbstractContextCacheTest {

  @Before
  public void setUp() {
    this.processEngineName = "foo";
    this.testName = "nonPaTest1";

    AbstractContextCacheTest.contextMap.put(this.testName, applicationContext.hashCode());
  }
}
