#!/usr/bin/env groovy

// Characters

// Unlike Java, Groovy doesn't have an explicit character literal. However, you can be explicit about making Groovy string an
// actual character, by three different means:

// by being explicit when declaring a variable holding the character by specifying the char type
char c1 = 'A'
assert c1 instanceof Character

// by using type coercion with the as operator
def c2 = 'B' as char
assert c2 instanceof Character

// by using a cast to char operation
def c3 = (char) 'C'
assert c3 instanceof Character

/* OBS: The first option (1) is interesting when the character is held in a variable, while the other two (2 and 3)
        are more interesting when a char value must be passed as argument of a method call. */

