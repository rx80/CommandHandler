package everx

class Tester {
    fun setHealth(value: Int): CommandResult {
        if (value < 0 || value > 20) {
            return CommandResult(false, "Invalid health value")
        }
        return CommandResult(true)
    }

    fun healthHelp(): CommandResult {
        println("health set <int>")
        println("health get")
        return CommandResult(true)
    }

    fun getHealth(): CommandResult {
        return CommandResult(true, "Your health is: 4")
    }
}

object CHMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val t = Tester()
        val x = CommandHandler()
        x.addCommand(t::setHealth, "rpg", "health", "set", Int)
        x.addCommand(t::healthHelp, "rpg", "health", "help")
        x.addCommand(t::getHealth, "rpg", "health", "get")
        println(x.exec("rpg", "health", "help"))
        println(x.exec("rpg", "health", "set", "5"))
        println(x.exec("rpg", "health", "get"))
    }
}
