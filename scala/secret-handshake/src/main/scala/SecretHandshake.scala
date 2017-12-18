object SecretHandshake {

    val stringFlags = List(
        StringFlag(b("1"), "wink"),
        StringFlag(b("10"), "double blink"),
        StringFlag(b("100"), "close your eyes"),
        StringFlag(b("1000"), "jump")
    )
    val reverse = b("10000")

    def commands(flags: Int): List[String] = {
        val list = stringFlags.filter(_.check(flags)).map(_.string)

        if ((flags & reverse) != 0) {
            list.reverse
        } else {
            list
        }
    }

    def b(binary: String): Int = Integer.parseInt(binary, 2)

    case class StringFlag(code: Int, string: String) {
        def check(flags: Int): Boolean = (flags & code) != 0
    }
}
