
import java.util.ArrayList
import kotlin.math.ceil
import kotlin.math.floor


open class BinaryTree<D : Data>(
	data: List<D>
) {
	constructor(root: D): this(listOf(root))
	constructor(vararg data: D): this(data.toList())
	init {
		@Suppress("LeakingThis")
		for (singleData in data) this += singleData
	}

	var root: Node<D>? = null
		private set

	/**
	 * Inserts a new node at the correct position
	 * @throws IllegalArgumentException if [node] is equal to an already existing element
	 */
	operator fun plusAssign(node: Node<D>) {
		root = root.refreshAndInsert(node)
	}

	operator fun plusAssign(data: D) {
		this += Node(data)
	}

	fun find(key: String) = root?.find(key)

	fun order(notation: Notation) = with(notation) {
		root.order()
	}

	fun toString(notation: Notation) = order(notation).joinToString(
		prefix = "[",
		postfix = "\n]",
		limit = 5
	) { data -> "\n\t$data" }
	override fun toString() = toString(Notation.IN)

	/**
	 * Prints a tree diagram.
	 * Source: https://stackoverflow.com/a/29704252/11485145
	 */
	fun print() {
		val lines = mutableListOf<List<String?>>()
		var level = mutableListOf<Node<D>?>()
		var next = mutableListOf<Node<D>?>()
		var nn = 1
		var widest = 0

		level.add(root)

		while (nn != 0) {
			val line: MutableList<String?> = ArrayList()
			nn = 0
			for (n in level) {
				if (n == null) {
					line.add(null)
					next.add(null)
					next.add(null)
				} else {
					val aa: String = n.data.key.cutOverflow(12)
					line.add(aa)
					if (aa.length > widest) widest = aa.length
					next.add(n.left)
					next.add(n.right)
					if (n.left != null) nn++
					if (n.right != null) nn++
				}
			}
			if (widest % 2 == 1) widest++
			lines.add(line)
			val tmp: MutableList<Node<D>?> = level
			level = next
			next = tmp
			next.clear()
		}
		var perPiece = lines[lines.size - 1].size * (widest + 4)
		for (i in lines.indices) {
			val line = lines[i]
			val hpw = floor((perPiece / 2f).toDouble()).toInt() - 1
			if (i > 0) {
				for (j in line.indices) {

					// split node
					var c = ' '
					if (j % 2 == 1) {
						if (line[j - 1] != null) {
							c = if (line[j] != null) '┴' else '┘'
						} else {
							if (j < line.size && line[j] != null) c = '└'
						}
					}
					print(c)

					// lines and spaces
					if (line[j] == null) {
						for (k in 0 until perPiece - 1) {
							print(" ")
						}
					} else {
						for (k in 0 until hpw) {
							print(if (j % 2 == 0) " " else "─")
						}
						print(if (j % 2 == 0) "┌" else "┐")
						for (k in 0 until hpw) {
							print(if (j % 2 == 0) "─" else " ")
						}
					}
				}
				println()
			}

			// print line of numbers
			for (j in line.indices) {
				var f = line[j]
				if (f == null) f = ""
				val gap1 = ceil((perPiece / 2f - f.length / 2f).toDouble()).toInt()
				val gap2 = floor((perPiece / 2f - f.length / 2f).toDouble()).toInt()

				// a number
				for (k in 0 until gap1) {
					print(" ")
				}
				print(f)
				for (k in 0 until gap2) {
					print(" ")
				}
			}
			println()
			perPiece /= 2
		}
	}
}