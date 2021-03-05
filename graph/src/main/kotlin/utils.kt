fun String.padded(breite: UInt) = padStart(breite.toInt(), ' ')
	.substring(0 until breite.toInt())