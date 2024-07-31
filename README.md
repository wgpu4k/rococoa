# rococoa
Fork of rococoa to update it and publish it on central
Check the original work here : https://github.com/iterate-ch/rococoa

Only rococoa-core has been forked, please create a PR or an issue if you need the other project.

## Add it to your java project like this :

- On Gradle
```Kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ygdrasil:rococoa:0.0.1")
}
```

- On Maven
```XML
<!-- https://mvnrepository.com/artifact/org.rococoa/rococoa-core -->
<dependency>
    <groupId>io.ygdrasil</groupId>
    <artifactId>rococoa</artifactId>
    <version>0.0.1</version>
</dependency>

```
