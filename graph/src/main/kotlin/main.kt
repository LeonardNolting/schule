fun main() {
	println("Feld")
	Feld(5).run {
		befuellen()
		ausgeben()
	}

	println("Matrix manuell mit 2-dimensionalem Array befüllt")
	Matrix(3, 4).run {
		befuellen(
			arrayOf(
				arrayOf(1, 2, 3, 4),
				arrayOf(5, 6, 7, 8),
				arrayOf(9, 10, 11, 12)
			)
		)
		println(this)
	}

	println("Matrix manuell mit 1-dimensionalem Array befüllt")
	Matrix(3, 4).run {
		befuellen(
			arrayOf(
				1, 2, 3, 4,
				5, 6, 7, 8,
				9, 10, 11, 12
			)
		)
		println(this)
	}

	println("Matrix automatisch befüllt")
	Matrix(3, 4).run {
		befuellen()
		println(this)
	}
}