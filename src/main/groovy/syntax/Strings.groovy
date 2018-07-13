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


