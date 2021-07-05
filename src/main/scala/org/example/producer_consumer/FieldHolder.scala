package org.example.producer_consumer

/** NON-VARIANT */
// + class Holder[T] (var value: T)
// + class Holder[T] (val value: T)

/** CO-VARIANT */
// - class Holder[+T] (var value: T) // because co-variant can be only for reading (var creates getter/setter)
// + class Holder[+T] (val value: T) // because co-variant can be only for reading  (val creates getter)

/** CONTRA-VARIANT */
// - class Holder[-T] (var value: T)
// - class Holder[-T] (val value: T)
class FieldHolder[T](value: T) {
}
