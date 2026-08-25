# lambox-to-java-examples

Hand-written λ□ example programs (`Example.ard`, `ExamplePeano.ard`,
`ExampleMatMul.ard`) and their printing entry points (`ExamplePrint.ard`), kept
in their own Arend project so they don't clutter `lambox-to-java`'s own
sources -- that project is the compiler; this one is sample input for it.

This project depends on `lambox-to-java` (see its `arend.yaml`). The three
`Example*.ard` programs are the source of `test`'s three handwritten corpus
programs (`example`, `peano`, `matmul`); `test/tools/regen-arend-asts.sh`
typechecks `ExamplePrint`'s definitions to (re)generate the checked-in
`test/corpora/handwritten/<name>/prog.ast` (and, for `matmul`, the `.attr`
files) from them -- see `test/README.md`.

## Running

The Arend CLI resolves the `lambox-to-java` dependency via two `-L` search
roots: the repository root (where `lambox-to-java/` lives) and the default
library root (`~/.arend/libs`, for `arend-lib`) -- `-L` replaces the default
root rather than adding to it, so both are needed. `test/lib.sh` /
`test/tools/extract-arend.sh` already do this; to run the CLI on this project
by hand:

    java -Xss1g -jar <arend-cli.jar> -L <repo-root> -L ~/.arend/libs arend.yaml ExamplePrint:peanoJava
