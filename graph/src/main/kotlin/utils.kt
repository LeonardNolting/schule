fun String.mitBreite(breite: UInt) = padStart(breite.toInt(), ' ')
    .substring(0 until breite.toInt())

infix fun String.mitBreite(breite: Int) = mitBreite(breite.toUInt())