plugins {
    java
    // Adjusted to a valid, stable Spring Boot 3.x version
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "SpringBootFullRefresher"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Standard web starter (includes Tomcat, Spring MVC, Validation, etc.)
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Optional: Adds H2 console auto-config enhancements & hot-swapping
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // The actual H2 Database dependency
    runtimeOnly("com.h2database:h2")

    // This single starter covers ALL your Spring/Thymeleaf/Web testing needs
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}