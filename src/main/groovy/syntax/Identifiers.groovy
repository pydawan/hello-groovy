#!/usr/bin/env groovy

// Identifiers

// Identifiers start with a letter, a dollar or an underscore. They cannot start with a number.

// Valid identifiers
def name
def item3
def with_underscore
def $dollarStart

// Invalid indentifiers
// def 3tier
// def a+b
// def a#b

// All keywords are also valid identifiers when following a dot:
// foo.as
// foo.assert
// foo.break
// foo.case
// foo.catch

// Quoted identifiers
// Quoted identifiers appear after the dot of a dotted expression: person."name" or person.'name'.
// This is particularly interesting when certain identifiers contain illegal characters that are forbidden
// by the Java Language Specification, but wich are allowed by Groovy when quoted.
// For example, characters like dash, a space, an exclamation mark, etc.

def map = [:]

map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/
map.$/dollar slashy string/$

// GStrings (Groovy Strings), interpolated values are inserted in the
// final string for evaluating the whole identifier.

def firstname = "Homer"
map."Simpson-${firstname}" = "Homer Simpson"

assert map.'Simpson-Homer' == "Homer Simpson"

