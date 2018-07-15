#!/usr/bin/env groovy

// Operadores aritméticos

// Operador        Propósito          Obsevações
// +               adição
// -               subtração
// *               multiplicação
// /               divisão            Use intdiv() para divisão inteira.
// %               resto de divisão   
// **              radiciação

assert 1 + 2 == 3
assert 4 - 3 == 1
assert 3 * 5 == 15
assert 3 / 2 == 1.5
assert 10 % 3 == 1
assert 2 ** 3 == 8

// Operadores unários

assert +3 == 3
assert -4 == 0 - 4
assert -(-1) == 1

def a = 2
def b = a++ * 3

assert a == 3 && b == 6

def c = 3
def d = c-- * 2

assert c == 2 && d == 6

def e = 1
def f = ++e + 3

assert e == 2 && f == 5

def g = 4
def h = --g + 1

assert g == 3 && h == 4

// Operadores aritméticos e de atribuição

// +=
// -=
// *=
// /=
// %=
// **=

a = 4
a += 3

assert a == 7

b = 5
b -= 3

assert b == 2

c = 5
c *= 3

assert c == 15

d = 10
d /= 2

assert d == 5

e = 10
e %= 3

assert e == 1

f = 3
f **= 2

assert f == 9

// Operadores relacionais

/* Operadores relacionais são aqueles que permitem que objetos sejam comparadores entre si de forma que se possa
 * verificar se são o mesmo ou não, se um é maior que, menor que ou igual ao outro.
 */

//=======================================
// Operador       Propósito
//=======================================
// ==             igual a
// !=             diferente de
// <              menor que
// <=             menor que ou igual a
// >              maior que
// >=             maior que ou igual a
//=======================================

assert 1 + 2 == 3
assert 3 != 4

assert -2 < 3
assert 2 <= 2
assert 3 <= 4

assert 5 > 1
assert 5 >= -2

// Operadores lógicos

// && e
// || ou
// !  not

assert !false
assert true && true
assert true || false

// Precedência de operadores

/* 
 * Curso Circuito
 * O operador lógico || suporta curto circuito: se o operador da esquerda é true, ele sabe que o resultado será true de qualquer maneira,
 * assim ele não avalia o operador da direita. O operador da direita só será avaliado se o operador da esquerda for false.
 *
 * Da mesma forma o operador lógico &&: se o operando da esquerda é false, ele sabe que o resutlado será false em qualquer caso, assim ele 
 * não irá avaliar o operador da direita. O operador da direita será avaliado somente se o operador da esquerda for true.
 */

// Operadores bit a bit

// &   and bit a bit
// |   or bit a bit
// ^   xor (or exclusivo)
// ~   negação bit a bit

// Operadoes bit a bit são aplicáveis em byte ou int e retornam um int.


a = 0b00101010
assert a == 42
b = 0b00001000
assert b == 8
assert (a & a) == a
assert (a & b) == b
assert (a | a) == a
assert (a | b) == a


int mask = 0b11111111
assert ((a ^ a) & mask) == 0b00000000
assert ((a ^ b) & mask) == 0b00100010
assert ((~a) & mask) == 0b11010101

// Operadores condicionais

assert (!true) == false
assert (!'foo') == false
assert (!'') == true

// Operador ternário

def string = 'somenthing'

if (string != null && string.length() > 0) {
    result = 'Found'
} else {
    result = 'Not found'
}

// a condição acima pode ser escrita assim:
result = (string != null && string.length() > 0) ? 'Found' : 'Not found'

// simplificando ainda mais temos:
result = string ? 'Found' : 'Not found'

// Elvis operator
// O operador Elvis é uma abreviação do operador ternário.

user = [name: '']
displayName = user.name ? user.name : 'Anonymous'
displayName = user.name ?: 'Anonymous'

// Object operators

// Safe navigation operator (operador para navegação segura) é utilizado para evitar o lançamento de NPE (NullPointerException).

// def person = Person.find { it.id == 123 }
// def name = person?.name
// assert name == null

// Direct field access operator (operador de acesso direto ao atributo)

class User {
    public final String name    
    User(String name) { this.name = name }
    String getName() { "Name: $name" }
}

def user = new User('Bob')
assert user.name == 'Name: Bob'

// user.name dispara uma chamada para o método getter de name.
// Para forçar a chamada direta ao atributo usamos user.@name.

// Method pointer operator (operador ponteiro para método)
// Usado para armazenar a referência para um método em uma variável para chamá-lo posteriormente.

def str = 'example of method reference'
def fun = str.&toUpperCase

def upper = fun()
assert upper == str.toUpperCase()

/* Existem muitas vantagens na utilização dos ponteiros para métodos. A primeira delas é que ele é uma groovy.lang.Closure,
 * então ela pode ser usada em qualquer lugar onde uma closure pode ser usada. Em particular, ele é usado para converter um
 * método existente para as necessidades do padrão de projeto Strategy.
 */
def transform(List elements, Closure action) {
    def result = []
    elements.each {
        result << action(it)
    }
    result
}

String describe(Person p) {
    "$p.name is $p.age"
}

class Person {
    String name
    Integer age
}

def action = this.&describe
def list = [
    new Person(name: 'Bob', age: 42),
    new Person(name: 'Julia', age: 35)
]

assert transform(list, action) == ['Bob is 42', 'Julia is 35']

/* 
 * OBS: Ponteiros para métodos são associados ao receptor e a um nome de método.
 *      Os argumentos são resolvidos em tempo de execução, significando que se você tem múltiplos métodos
 *      com o mesmo nome, a sintaxe não é diferente, somente a resolução do método apropriado a ser chamado
 *      será feita em tempo de execução.
 */

def doSomething(String str) { str.toUpperCase() }
def doSomething(Integer x) { 2 * x }
def reference = this.&doSomething
assert reference('foo') == 'FOO'
assert reference(123) == 246

// =============================
// REGULAR EXPRESSION OPERATORS
// =============================

// PATTERN OPERATOR
// O operador pattern (~) fornece uma maneira simples de criar uma instância de java.util.regex.Pattern:

def p = ~/foo/
assert p instanceof java.util.regex.Pattern

// Geralmente o operador patter é encontrado como uma expressão em uma slashy string, ele pode ser usado com qualquer tipo de String no Groovy:
p = ~'foo'
p = ~"foo"
p = ~$/dollar/slashy $ string/$
pattern = p
p = ~"${pattern}"

// FIND OPERATOR
// Usamos o operador find, =~ para construir um java.util.regex.Matcher que é um comparador que verifica a correspondência entre padrões textuais.

def text = "some text to match"
def m = text =~ /match/
assert m instanceof java.util.regex.Matcher

if (!m) {
    throw new RuntimeException("Oops, text not found!")
}

// MATCH OPERATOR

m = text ==~ /match/
assert m instanceof Boolean
if (m) {
    throw new RuntimeException("Should not reach that point!")
}


// SPREAD OPERATOR

/* O Spread Operator (*.) é usado para invocar uma ação em todos os itens de um objeto agregado. Ele é equivalente a chamada da
 * ação em cada item e a coletagem do resultado em uma lista.
 */

class Car {
    String make
    String model
}

def cars = [
    new Car(make: 'Peugeot', model: '508'),
    new Car(make: 'Renault', model: 'Clio')
]

def makes = cars*.make
assert makes == ['Peugeot', 'Renault']

// O spread operator é null-safe, significando que se um elemento da coleção é null ele irá retornar null ao invés de lançar um NullPointerException:
cars = [
    new Car(make: 'Peugeot', model: '508'),
    null,
    new Car(make: 'Renault', model: 'Clio')
]

assert cars*.make == ['Peugeot', null, 'Renault']
assert null*.make == null

// O spread operator pode ser usado em qualquer classe que implemente a interface Iterable:

class Component {
    Long id
    String name
}

class CompositeObject implements Iterable<Component> {
    def components = [
        new Component(id: 1, name: 'Foo'),
        new Component(id: 2, name: 'Bar')
    ]
    
    @Override
    Iterator<Component> iterator() {
        components.iterator();
    }
}

def composite = new CompositeObject()
assert composite*.id == [1, 2]
assert composite*.name == ['Foo', 'Bar']

int function(int x, int y, int z) {
    x * y + z
}

def args = [4, 5, 6]

assert function(*args) == 26

args = [4]
assert function(*args, 5, 6) == 26

// SPREAD LIST ELEMENTS
def items = [4, 5]
list = [1, 2, 3, *items, 6]
assert list == [1, 2, 3, 4, 5, 6]

// SPREAD MAP ELEMENTS
def m1 = [c: 3, d: 4]
def map = [a: 1, b: 2, *: m1]
assert map == [a: 1, b: 2, c: 3, d: 4]

// RANGE OPERATOR

def range = 0..5
assert (0..5).collect() == [0, 1, 2, 3, 4, 5] // IntRange with inclusive bounds
assert (0..<5).collect() == [0, 1, 2, 3, 4] // IntRange with exclusive upper bound
assert (0..5) instanceof List // groovy.lang.Range implements the List interface
assert (0..5).size() == 6

/* 
 * Ranges implementation is lightweight, meaning that only the lower and upper bounds are stored. You can create a range
 * from any Comparable object that has next() and previous() methods to determine the next/previous item in the range.
 */
assert ('a'..'d').collect() == ['a', 'b', 'c', 'd']


// SPACESHIP OPERATOR

// O spaceship operator delega para o método compareTo:

assert (1 <=> 1) == 0
assert (1 <=> 2) == -1
assert (2 <=> 1) == 1
assert ('a' <=> 'z') == -1


// SUBSCRIPT OPERATOR

// O subscript operator é uma notação abreviada para getAt ou putAt, dependendo se você o encontra do lado esquerdo ou direito de uma atribuição.

list = [0, 1, 2, 3, 4]
assert list[2] == 2
list[2] = 4
assert list[0..2] == [0, 1, 4]
list[0..2] = [6, 6, 6]
assert list == [6, 6, 6, 3, 4]

class Usuario {
    Long id
    String nome

    def getAt(int i) {
        switch (i) {
            case 0: return id
            case 1: return nome
        }
        throw new IllegalArgumentException("No such element $i")
    }

    void putAt(int i, def value) {
        switch (i) {
            case 0: id = value; return
            case 1: nome = value; return
        }
    }
}

def usuario = new Usuario(id: 1, nome: 'Alex')
assert usuario[0] == 1
assert usuario[1] == 'Alex'
usuario[1] = 'Bob'

// MEMBERSHIP OPERATOR

/* The membership operator (in) is equivalent to calling the isCase method. In the context of a List, it i sequivalent to
 * calling contains, like in the following example:
 */

list = ['Grace', 'Rob', 'Emmy']
assert('Emmy' in list) // equivalent to calling list.contains('Emmy') or list.isCase('Emmy')

// IDENTITY OPERATOR

/* In Groovy, using == to test equality is different from using the same operator in Java. In Groovy, it is calling equals. If you
 * want to compare reference equality, you should use is like in the following example:
 */

def list1 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
def list2 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
assert list1 == list2
assert !list1.is(list2)

// COERCION OPERATOR

/* The coercion operator (as) is a variant of casting. Coercion converts object from one type to another without them being
 * compatible for assignment. Let's take an example:
 */

Integer x = 123
String s = (String) x // Integer is not assignable to a String, so it will produce a ClassCastException at runtime.

// This can be fixed by using coercion instead:
Integer x1 = 123
String s1 = x as String // Integer is not assignable to a String, bu use of as will coerce it to a String.

/*
 * When an object is coerced into another, unless the target type is the same as the source type, coercion wil lreturn a new
 * object. The rules of coercion differ depending on the source and target types, and coercion may fail if no conversion rules
 * are found. Custom conversion rules may be implemented thanks to the asType method:
 */

/*

class Identifiable {
    String name
}

class User {
    Long id
    String name

    def asType(Class target) {
        if (target == Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}

def u = new User(name: 'Xavier')
def p = u as Identifiable
assert p instanceof Identifiable
assert !(p instanceof User)

*/

// DIAMOND OPERATOR

/* The diamond operator (<>) is a syntatic sugar only operator added to support compatibility with the operator of the
 * same name in Java 7. It is used to indicate that generic types should be inferred from the declaration:
 */

List<String> strings = new LinkedList<>()

/* In dynamic Grovy, this is totally unused. In statically type checked Groovy, it is also optional since the Groovy type checker
 * performs type inference wheter this operator is present or not.
 */

// CALL OPERATOR

/* The call operator () is used to call a method named call implicitly. For any obbject which defines a call mehtod, you can
 * omit the .call() part and use the call operator instead:
 */

class MyCallable {
    int call(int x) { // MyCallable defines a mehtod named call. Note that it doesn't nedd to implement java.util.concurrent.Callable
        2 * x
    }
}

def mc = new MyCallable()
assert mc.call(2) == 4 // we can call the method using the classic method call syntax
assert mc(2) == 4 // or we can omit .call thanks to the call operator


// OPERATOR PRECEDENCE

// OPERATOR OVERLOADING

class Bucket {
    int size

    Bucket(int size) { this.size = size }

    Bucket plus(Bucket other) {
        return new Bucket(this.size + other.size)
    }
}

def b1 = new Bucket(4)
def b2 = new Bucket(11)
assert (b1 + b2).size == 15

// =============================================
//   OPERATOR           METHOD
// =============================================
//   +              a.plus(b)
//   -              a.minus(b)
//   *              a.multiply(b)
//   /              a.div(b)
//   %              a.mod(b)
//   **             a.power(b)
//   |              a.or(b)
//   &              a.and(b)
//   ^              a.xor(b)
//   as             a.asType(b)
//   a()            a.call()
//   a[b]           a.getAt(b)
//   a[b] = c       a.putAt(b, c)
//   a in b         b.isCase(a)
//   <<             a.leftShift(b)
//   >>             a.rightShift(b)
//   >>>            a.rightShiftUnsigned(b)
//   ++             a.next()
//   --             a.previous()
//   +a             a.positive()
//   -a             a.negative()
//   ~a             a.bitwiseNegate()
// ============================================



