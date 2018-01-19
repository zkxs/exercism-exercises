import Allergen._

object Allergies {
    def allergicTo(allergen: Allergen, value: Int): Boolean = (allergen.value & value) != 0
    def list(flags: Int): List[Allergen] = Allergen.all.filter(a => allergicTo(a, flags))
}
