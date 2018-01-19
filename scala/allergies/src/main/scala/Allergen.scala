object Allergen {
    val Eggs         = Allergen(1)
    val Peanuts      = Allergen(2)
    val Shellfish    = Allergen(4)
    val Strawberries = Allergen(8)
    val Tomatoes     = Allergen(16)
    val Chocolate    = Allergen(32)
    val Pollen       = Allergen(64)
    val Cats         = Allergen(128)

    val all = List(Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats)
}

case class Allergen(value: Int)
