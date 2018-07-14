#!/usr/bin/env groovy

/*
 * Maps
 * 
 * Sometimes called dictionaries or associative arrays in other languages, Groovy features maps. Maps associate keys to
 * values, separating keys and values with colons, and each key/value pairs with commas, and the whole keys and values
 * surrounded by square brackets.
 *
 * OBS: Groovy creates maps that are actually instances of java.util.LinkedHashMap.
 */

def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

assert colors['red'] == '#FF0000'
assert colors.green == '#00FF00'

colors['pink'] = '#FF00FF'
colors.yellow = '#FFFF00'

assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'

assert colors instanceof java.util.LinkedHashMap

// If you try to access a key which is not present in the map:
assert colors.unknown == null

// You will retrive a null result.

def numbers = [1: 'one', 2: 'two']
assert numbers[1] == 'one'

def key = 'name'
def person = [key: 'Guillaume'] // 1

assert !person.containsKey('name') // 2
assert person.containsKey('key') // 3

// 1. The key associated with the 'Guillaume' name will actually be the "key" string, not the value associated with the key variable.
// 2. The map doesn't contain the 'name' key.
// 3. Instead, th emap contains a 'key' key.

/*
 * OBS: You can also pass whoted strings as well as keys: ["name": "Guillaume"]. This is mandatory if your key string
 *      isn't a valid identifier, for example if you wanted to create a string key containing a hash like in: ["street-name"]: "Main street"].
 *
 *      When you need to pass variable values as keys in your map definitions, you must surround the variable or expression with parentheses:
 */

person = [(key): 'Guillaume']

assert person.containsKey('name')
assert !person.containsKey('key')










