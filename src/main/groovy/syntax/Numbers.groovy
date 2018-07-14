#!/usr/bin/env groovy

// NUMBERS
// Groovy supports different kinds of integrail literals and decimal literals, backed by the usual Number types of Java.

// INTEGERAL LITERALS
// The integral literal types are the same as in Java:
// 1 - byte
// 2 - char
// 3 - short
// 4 - int
// 5 - long
// 6 - java.lang.BigInteger

// primitive types
byte b = 1
char c = 2
short s = 3
int i = 4
long l = 5

// infinite precision
BigInteger bi = 6

/* OBS: If you use typing by using the def keyword, the type of the integral number will vary: it'll adapt to the capacity of
        the type that can hold that number.*/

// For positive numbers:
def a = 1
assert a instanceof Integer

// Integer.MAX_VALUE
println "Integer.MAX_VALUE = ${Integer.MAX_VALUE}"
def n = 2147483647
assert n instanceof Integer

// Integer.MAX_VALUE + 1
println 'Long = Integer.MAX_VALUE + 1'
println "Long = ${Integer.MAX_VALUE + 1}"
println "Long.MAX_VALUE = ${Long.MAX_VALUE}"
n = 9223372036854775807
assert n instanceof Long

// Long.MAX_VALE + 1
println "BigInteger = Long.MAX_VALUE + 1"
println "BigInteger = ${Long.MAX_VALUE + 1}"
n = 9223372036854775808
assert n instanceof BigInteger

def na = -1
assert na instanceof Integer

// Integer.MIN_VALUE
def nb = -2147483648
assert nb instanceof Integer

// Integer.MIN_VALUE - 1
def nc = -2147483649
assert nc instanceof Long

// Long.MIN_VALUE
def nd = -9223372036854775808
assert nd instanceof Long

// Long.MIN_VALUE - 1
def ne = -9223372036854775809
assert ne instanceof BigInteger

// Alternative non-base 10 representations
// Numbers can also be represented in binary, octal, hexadecimal and decimal bases.

// Binary literal
// Binary numbers start with a 0b prefix:

int xInt = 0b10101111
assert xInt == 175

short xShort = 0b11001001
assert xShort == 201 as short

byte xByte = 0b11
assert xByte == 3 as byte

long xLong = 0b101101101101
assert xLong == 2925l

BigInteger xBigInteger = 0b111100100001
assert xBigInteger == 3873g

int xNegativeInt = -0b10101111
assert xNegativeInt == -175

// Octal literal
// Octal numbers are specified in the typical format of 0 followed by octal digits.

xInt = 077
assert xInt == 63

xShort = 011
assert xShort == 9 as short

xByte = 032
assert xByte == 26 as byte

xLong = 0246
assert xLong == 166l

xBigInteger = 01111
assert xBigInteger == 585g

xNegativeInt = -077
assert xNegativeInt == -63

// Hexadecimal literal
// Hexadecimal numbers are specified in the typical format of 0x followed by hex digits.

xInt = 0x77
assert xInt == 119

xShort = 0xaa
assert xShort == 170 as short

xByte = 0x3a
assert xByte == 58 as byte

xLong = 0xffff
assert xLong == 65535l

xBigInteger = 0xaaaa
assert xBigInteger == 43690g

double xDouble = new Double('0x1.0p0')
assert xDouble == 1.0d

xNegativeInt = -0x77
assert xNegativeInt == -119

// Decimal literals
// The decimal literal types are the same as in Java:

// 1. float
// 2. double
// 3.. java.lang.BigDecimal

// You can create decimal numbers of those types with the following declartions:

// primitive types
float f = 1.234
double d = 2.345

// infinite precision
BigDecimal bd = 3.456

/* Decimals can use exponents, with the e or E exponent letter, followed by an optional sign, and a integral number
 * representing the exponent:
 */

assert 1e3 == 1_000.0
assert 2E4 == 20_000.0
assert 3e+1 == 30.0
assert 4E-2 == 0.04
assert 5e-1 == 0.5

/* Conveniently for exct decimal number calculations, Groovy choses java.lang.BigDecimal as its decimal number type.
 * In addition, both float and double are supported, but require an explicit type declaration, type coercion or suffix.
 */

// OBS: Decimal numbers can't be represented using a binary, octal or hexadecimal representation.

// Underscore in literals
long creditCardNumber = 1234_5678_9012_3456L
long socialSecurityNumbers = 999_99_9999L
double monetaryAmount = 12_345_132.12
long hexBytes = 0xFF_EC_DE_5E
long hexWords = 0xFFEC_DE5E
long maxLong = 0x7fff_ffff_ffff_ffffL
long alsoMaxLong = 9_223_372_036_854_775_807L
long bytes = 0b11010010_01101001_10010100_10010010

// Number type suffixes
/* We can force a number (including binary, octals and hexadecimals) to have a specific type by giving a suffix (see table
 * below), either uppercase or lowercase.
 */

// Type              Suffix
// BigInteger        G or g
// Long              L or l
// Integer           I or i
// BigDecimal        G or g
// Double            D or d
// Float             F or f

assert 42I == new Integer('42')
assert 42i == new Integer('42') // lower i more readable
assert 123L == new Long("123") // uppercase L more readable
assert 2147483648 == new Long('2147483648') // Long type used, value too large for an Integer

assert 456G == new BigInteger('456')
assert 456g == new BigInteger('456')
assert 123.45 == new BigDecimal('123.45') // default BigDecimal type used
assert 1.200065D == new Double('1.200065')
assert 1.234F == new Float('1.234')
assert 1.23E23D == new Double('1.23E23')
assert 0b1111L.class == Long // binary
assert 0xFFi.class == Integer // hexadecimal
assert 034G.class == BigInteger // octal

