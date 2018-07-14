#!/usr/bin/env groovy

/* Groovy reuses the list notation for arrays, but to make such literals arrays, you need to explicitely define the type of the 
 * array through coercion or type declaration.
 */

String[] arrStr = ['Ananas', 'Banana', 'Kiwi']

// assevera que um objeto é um array de strings.
assert arrStr instanceof String[]

// assevera que um objeto não é uma lista.
assert !(arrStr instanceof List)

// cria um array de inteiros.
def numArr = [1, 2, 3] as int[]

assert numArr instanceof int[]
assert numArr.size() == 3

// Multi-dimensional arrays:
def matrix3 = new Integer[3][3]
assert matrix3.size() == 3

Integer[][] matrix2
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]

// Accessing elements:
String[] names = ['Cédric', 'Guillaume', 'Jochen', 'Paul']
assert names[0] == 'Cédric'

names[2] = 'Blackdrag'
assert names[2] == 'Blackdrag'

/* OBS: Java's array initializer notation is not supported by Groovy, as the curly braces can be misinterpreted with
 *      the notation of Groovy closures.
 */










