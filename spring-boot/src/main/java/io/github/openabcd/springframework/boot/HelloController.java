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

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    public record RequestBodyDto(String message) {}

    @GetMapping
    public String hello(
            @RequestHeader("Cloud-Header-1") String header,
            @RequestParam("name") String name,
            @RequestBody RequestBodyDto request) {
        return """
                Hello, %s!
                Your header is %s and
                your message is: %s
                """
                .formatted(name, header, request.message());
    }
}
