import io.gitlab.arturbosch.detekt.Detekt

plugins{
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    config.setFrom(rootProject.file("config/detekt.yml"))
    buildUponDefaultConfig = true
}

/* --- Task который говорит пропускать задачи если в них есть слово Test ---*/
val detekt = tasks.register("detektWithoutTests") {
    dependsOn(tasks.withType<Detekt>().matching { it.name.contains("Test").not() })
}

tasks.matching { it.name == "check" }.configureEach {
    dependsOn(detekt)
}

tasks.withType<Detekt>().configureEach {
    mustRunAfter(
        tasks.matching {
            it.name.lowercase().contains("generate")
        }
    )
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}