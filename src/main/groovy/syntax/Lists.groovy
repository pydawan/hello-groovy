#!/usr/bin/env groovy

// Lists

// Interface (abstract data type): java.util.List
// Class (concrete data type): java.util.ArrayList
def numbers = [1, 2, 3]

assert numbers instanceof List
assert numbers.size() == 3

def heterogeneous = [1, "a", true]

def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList

def linkedList = [2, 3, 4] as LinkedList
assert linkedList instanceof java.util.LinkedList

LinkedList otherLinked = [3, 4, 5]
assert otherLinked instanceof java.util.LinkedList

/* 1. You can access elements of the list with the [] subscript operator with positive
 * indices or negative indices to access elements from the end of the list, as well as with ranges, and use the << leftShift
 * operator to append elements to a list:
 */

def letters = ['a', 'b', 'c', 'd']

assert letters[0] == 'a' // access the first element of the list (zero-based counting).
assert letters[1] == 'b'

assert letters[-1] == 'd' // access the last element of the list with a negative index: -1 is the first element from the end of the list.
assert letters[-2] == 'c'

letters[2] = 'C' // use an assignment to set a new value for the third element of the list.
assert letters[2] == 'C'

letters << 'e' // use the << leftShift operator to append an element at the end of the list.
assert letters[4] == 'e'
assert letters[-1] == 'e'

assert letters[1, 3] == ['b', 'd'] // access two elements at once, returning a new list containing those two elements.
assert letters[2..4] == ['C', 'd', 'e'] // use a range to access a range of values from the list, from a start to an end element position.

// Multi-dimensional lists:
def multi = [[0,1], [2,3]]
assert multi[1][0] == 2


