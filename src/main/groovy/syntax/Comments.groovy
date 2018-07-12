#!/usr/bin/env groovy

// 1. Single line comment

// a standalone single line comment
println "hello" // a comment till the end of the line

// 2. Multiline comment

/* a standalone multiline comment
   spanning two lines */
print "hello" /* a multiline comment starting
                 at the end of a statement */

println 1 /* one */ + 2 /* two */

// 3. GroovyDoc comment

/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

   /**
    * Creates a greeting method for a certain person.
    *
    * @param otherPerson the person to greet
    * @return a greeting message
    */
    String greet(String otherPerson) {
        "Hello ${otherPerson}"
    }
}

// Shebang line
// #!/usr/bin/env groovy
