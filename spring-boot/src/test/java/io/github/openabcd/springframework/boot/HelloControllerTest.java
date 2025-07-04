/*
 * Copyright 2025-2025 the original author or authors.
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
 
package io.github.openabcd.springframework.boot;

import com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.RestDocumentationContextProvider;

import static io.restassured.RestAssured.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest extends ApiSpecTest{

    @LocalServerPort
    int port;

    RequestSpecification spec;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDoc) {
        var config = documentationConfiguration(restDoc)
                .operationPreprocessors()
                .withRequestDefaults(prettyPrint())
                .withResponseDefaults(prettyPrint());

        this.spec = new RequestSpecBuilder()
                .addFilter(config)
                .setBaseUri("http://localhost")
                .setPort(port)
                .build();
    }

    @Test
    void hello() {
        given(spec)
                .filter(RestAssuredRestDocumentationWrapper.document(
                        "{method-name}",
                        queryParameters(
                                parameterWithName("name").description("The name to be included in the greeting")),
                        requestFields(fieldWithPath("message").description("The message to be sent in the request")),
                        requestHeaders(headerWithName("Cloud-Header-1").description("커스텀 헤더")),
                        responseFields(fieldWithPath("message").description("응답 메시지(String)"))))
                .baseUri("http://localhost")
                .contentType(ContentType.JSON)
                .header(new Header("Cloud-Header-1", "header-value"))
                .queryParam("name", "header-value")
                .body(new HelloController.RequestBodyDto("Hello, World!"))
                .when()
                .post("/hello")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.OK.value());
    }
}
