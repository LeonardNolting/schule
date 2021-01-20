interface Data : Comparable<Data> {
	val key: String

	override fun compareTo(other: Data) = key.compareTo(other.key)
}