package everx

class CommandResult(val success: Boolean, val message: String = "") {
    override fun toString(): String {
        return when (success) {
            true -> "OK: $message"
            false -> "Fail: $message"
        }
    }
}
