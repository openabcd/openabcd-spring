/*
 * Copyright 2025-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.github.openabcd.springframework.boot;


import com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static com.epages.restdocs.apispec.ResourceDocumentation.headerWithName;
import static com.epages.restdocs.apispec.ResourceDocumentation.parameterWithName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Test
    void hello() {
        given()
                .filter(
                        RestAssuredRestDocumentationWrapper.document("{method-name}",
                                "THE API description",
                                requestParameters(
                                        headerWithName("Cloud-Header-1").description("A custom header"),
                                        parameterWithName("name").description("The name of the person to greet")
                                ),
                                headerWithName("Cloud-Header-1").description("A custom header"),
                                parameterWithName("name").description("The name of the person to greet")
                )
                .header("Cloud-Header-1", "header-value").queryParam("name", "jaime")
                .body("{\"message\":\"hi restdocs\"}")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(containsString("Hello, jaime!"));
    }
}
