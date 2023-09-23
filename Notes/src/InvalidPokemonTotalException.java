public class InvalidPokemonTotalException extends Exception {
                // We can replace Exception by "RuntimeException" if we don't want to be so strict
                // with error handling. We still need to handle possible exception, however with "RuntimeException"
                // the compiler will not have a problem with not including the "try" and "catch" blocks and hence
                // further error handling is purely optional (but recommended)

    // Unchecked Exceptions = Exceptions that are being handled during runtime
    // Checked Exception = Exceptions that are being handled in the compiler (before we run the program)
}
