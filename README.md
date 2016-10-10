A Simple Geometric Figure Type Application
==========================================

A demo application which implements a simple detector of a geometric figure type
using triangle as an example.

## Configuration
**Note** You need to add path to the directory _resources_ to JVM classpath
or specify the system property _log4j.configurationFile_ to enable the application's
specific settings for the logger _log4j 2_.

## Usage
Run the following command in console:

    java IdentifyType side1 side2 side3 [side4 ...]

## Possible extensions
    * In addition, implement Compatible interface at a geometric figure
      level.
    * Introduce ablity to specify anges to get more figure types such as
      acute/right/obtuse/equiangular triangles, etc.

## Author
[Yevgeny Go](yevgor@gmail.com)
