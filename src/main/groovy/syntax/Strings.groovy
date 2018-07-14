#!/usr/bin/env groovy

// 1. Text literals are represented in the form of chain of characters called strings.
// 2. Groovy lets you instantiate java.lang.String objects, as well as GStrings (groovy.lang.GString) which are also called
//    interpolated strings in other programming languages.

// Single quoted string
// Single quoted strings are plain java.lang.String and don't support interpolation.
s1 = 'a single quoted string'

// String concatenation
assert 'ab' == 'a' + 'b'

// Triple single quoted string (are plain java.lang.String and don't support interpolation).
s2 = '''a triple single quoted string'''

def aMultilineString = '''line one
line two
line three'''

def startingAndEndingWithANewline = '''
line one
line two
line three
'''

def strippedFirstNewline = '''\
line one
line two
line three
'''

assert !strippedFirstNewline.startsWith('\n')

// Escaping special characters
s3 = 'an escaped single quote: \' needs a backslash'
s4 = 'an escaped escape character: \\ needs a double backslash'

// Escape sequence   Character
// '\t'              tabulation
// '\b'              backspace
// '\n'              newline
// '\r'              carriage return
// '\f'              form feed
// '\\'              backslash
// '\''              single quote (for single quoted and triple single quoted strings)
// '\"'              double quote (for double quoted and triple double quoted strings)

// Unicode escape sequence
// For characters that are not present on your keyboard, you can use unicode escape sequences: a backslash, followed by 'u',
// then 4 hexadecimal digits.

// For example, the Euro currency symbol can be represented with:
s5 = 'The Euro currency symbol: \u20AC'
println s5

// Double quoted string

// Double quoted strings are plain java.lang.String if there's no interpolated expression, but are
// groovy.lang.GString instances if interpolation is present.

s6 = "a double quoted string"

// String interpolation
def name = 'Guillaume'
def greeting = "Hello ${name}"

assert greeting.toString() == 'Hello Guillaume'

def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum.toString() == 'The sum of 2 and 3 equals 5'

def person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

// Special case of interpolating closure expressions

def number = 1
def eagerGString = "value == ${number}" // expression interpolation
def lazyGString = "value == ${ -> number }" // closure interpolation

assert eagerGString == "value == 1"
assert lazyGString == "value == 1"

number = 2

assert eagerGString == "value == 1"
assert lazyGString == "value == 2"

// 1 - We define a number variable containing 1 that we then interpolate within two GStrings, as an expression in
// eagerGString and as a closure in lazyGString.

// 2 - We expect the resulting string to contain the same string value of 1 for eagerGString.

// 3 - Similarly for lazyGString.

// 4 - Then we change the value of the variable to a new number.

// 5 - With a plain interpolated expression, the value was actually bound at the time of creation of the GString.

// 6 - But with a closure expression, the closure is called upon each coercion of the GString into String, resulting in an
//     updated string containing the new number value.

// => OBS: An embedded closure expression taking more than one parameter will generate an exception at runtime.
//         Only closures with zero or one parameters are allowed.


// Interoperability with Java

// When a method (whether implemented in Java or Groovy) expects a java.lang.String, but we pass a
// groovy.lang.GString instance, the toString() method of the GString is automatically and transparently called.

String takeString(String message) {
    assert message instanceof String
    return message
}

def message = "The message is ${'hello'}"
assert message instanceof GString

def result = takeString(message)
assert result instanceof String
assert result == 'The message is hello'

assert "one: ${1}".hashCode() != "one: 1".hashCode()

// GString as Map keys should be avoided because unlike String they are not immutable.
def key = "a"
def m = ["${key}": "letter ${key}"]

assert m["a"] == null

// Triple double quoted string

name = 'Groovy'
def template = """
    Dear Mr ${name},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""

assert template.toString().contains('Groovy')

// Slashy string

// Beyond the usual quoted strings, Groovy offers slashy strings, which use / as delimiters. Slashy strings are particularly
// useful for defining regular expressions and patterns, as there is no need to escape backslashes.

// Example of a slashy string:
def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

// Slashy strings are multiline:
def multilineSlashy = /one
two
three/

assert multilineSlashy.contains('\n')

// Slashy strings can also be interpolated (ie. a GString):
def color = 'blue'
def interpolatedSlashy = /a ${color} car/

assert interpolatedSlashy == 'a blue car'

// An empty slashy string cannot be represented with a double forward slash, as it's understood by the Groovy parser as a line comment.
// assert '' == //

// Dollar slashy string
name = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name,
    today we're ${date}.
    
    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $$$/ escaped opening dollar slashy
    $/$$ escaped closing dollar slashy
/$

assert [
    'Guillaume',
    'April, 1st',
    '$ dollar sign',
    '$ escaped dollar sign',
    '\\ backslash',
    '/ forward slash',
    '/ escaped forward slash',
    '$/ escaped opening dollar slashy',
    '/$ escaped closing dollar slashy',
].every { dollarSlashy.contains(it) }


//===============================================================================================
//                         STRING SUMMARY TABLE
//===============================================================================================
// STRING NAME            |  STRING SYNTAX  |  INTERPOLATED  |  MULTILINE  |  ESCAPE CHARACTER  |
//                        |                 |                |             |                    |
// Single quoted          |  '...'          |      NO        |    NO       |         \          |
//                        |                 |                |             |                    |
// Triple single quoted   |  '''...'''      |      NO        |    YES      |         \          |
//                        |                 |                |             |                    |
// Double quoted          |  "..."          |      YES       |    NO       |         \          |
//                        |                 |                |             |                    |
// Triple double quoted   |  """..."""      |      YES       |    YES      |         \          |
//                        |                 |                |             |                    |
// Slashy                 |  /.../          |      YES       |    YES      |         \          |
//                        |                 |                |             |                    |
// Dollar slashy          |  $/.../$        |      YES       |    YES      |         $          |
//                        |                 |                |             |                    |
//==============================================================================================/


