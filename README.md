# Getting Started with Custom Tasks

The Morpheus plugin architecture is a library which allows users to extend functionality in several categories, including new cloud providers, task types, UI views, custom reports, and more. In this guide, we will take a look at developing a custom task to send a slack message. Complete developer documentation including the full API documentation and links to Github repositories containing complete code examples are available in the Developer Portal.

Custom plugin development requires programming experience but this guide is designed to break down the required steps into a digestible process that users can quickly run with. Morpheus plugins are written in Java or Groovy, our example here will be written in Groovy. Support for additional languages is planned but not yet available at the time of this writing. If you’re not an experienced Java or Groovy developer, it may help to clone an [example code repository](https://github.com/gomorpheus/morpheus-plugin-core/tree/master/samples/morpheus-task-plugin) which we link to in our developer portal. An additional example, which this guide is based on, is [here](https://github.com/martezr/morpheus-example-task-plugin). You can read the example code and tweak it to suit your needs using the guidance in this document.

Before you begin, ensure you have the following installed in your development environment:

* Gradle 6.5 or later
* Java 8 or 11

In this example, you’ll create a custom task for sending slack messages. The example highlights using plugin settings for storing the slack credentials along with option types for task configuration.

# Developing the Plugin
To begin, create a new directory to house the project. You’ll ultimately end up with a file structure typical of Java or Groovy projects, looking something like this:

```
./
.gitignore
build.gradle
src/main/groovy/
src/main/resources/renderer/hbs/
src/test/groovy/
src/assets/images/
src/assets/javascript/
src/assets/stylesheets/
```

Configure the `.gitignore` file to ignore the `build/` directory which will appear after performing the first build. Project packages live within `src/main/groovy` and contain source files ending in .groovy. View resources are stored in the `src/main/resources` subfolder and vary depending on the view renderer of choice. Static assets, like icons or custom javascript, live within the `src/assets` folder. Consult the table below for key files, their purpose, and their locations. Example code and further discussion of relevant files is included in the following sections.


|File Name|Description|File Path|
|---------|-----------|---------|
|build.gradle|The Gradle build file|build.gradle|


# Build the JAR

With the code written, use gradle to build the JAR which we can upload to Morpheus so the report can be viewed. To do so, change directory into the location of the directory created earlier to hold your custom catalog layout code.

```
cd path/to/your/directory
```

Build your new plugin.

```
gradle shadowJar
```

Once the build process has completed, locate the JAR in the `build/libs` directory

# Upload the Custom Task Plugin to the Morpheus UI
Custom plugins are added to Morpheus through the Plugins tab in the Integrations section (Administration > Integrations > Plugins). Navigate to this section and click CHOOSE FILE. Browse for your JAR file and upload it to Morpheus. The new plugin will be added next to any other custom plugins that may have been developed for your appliance.