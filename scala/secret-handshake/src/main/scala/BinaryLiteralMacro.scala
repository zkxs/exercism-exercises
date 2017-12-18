import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

object BinaryLiteralMacro {
    def b(binary: String): Int = macro bImpl

    def bImpl(c: Context)(binary: c.Expr[String]): c.Expr[Int] = {
        import c.universe._
        
        val Literal(Constant(binaryString: String)) = binary.tree
        val n = Integer.parseInt(binaryString, 2)
        c.Expr[Int](Literal(Constant(n)))
    }
}