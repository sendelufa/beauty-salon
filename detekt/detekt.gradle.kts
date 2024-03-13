apply {
    plugin(Plugins.Detekt.detekt_plugin)
}

detekt {
    toolVersion = Plugins.Detekt.version                    // Version of the Detekt CLI that will be used. When unspecified the latest detekt version found will be used. Override to stay on the same version.
    source = files("src/main/kotlin", "src/test/kotlin")    // The directories where detekt looks for input files. Defaults to `files("src/main/java", "src/main/kotlin")`.
    parallel = true                                         // Builds the AST in parallel. Rules are always executed in parallel. Can lead to speedups in larger projects. `false` by default.
    filters = ".*build.*,.*/resources/.*,.*/tmp/.*"         // Regular expression of paths that should be excluded separated by `;` or `,`.
    config = files("$projectDir/detekt/detekt-config.yml")  // Define the detekt configuration(s) you want to use. Defaults to the default detekt configuration.

    reports {
        html {
            required.set(true)                                    // Enable/Disable HTML report (default: true)
            outputLocation.set(file("build/reports/detekt.html")) // Path where HTML report will be stored (default: `build/reports/detekt/detekt.html`)
        }
    }

    dependencies {
        detektPlugins(Plugins.Detekt.detekt_formatting)
    }
}