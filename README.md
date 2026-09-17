# Compile Lambda-Box to Java in Arend

Compiling λ-box terms to Java implemented in [Arend](https://github.com/JetBrains/Arend) by JetBrains.
Part of my internship project at JetBrains.

## Layout

The translation and the formalization are kept apart, because they are different
kinds of thing: one is code that runs on every compile, the other is a
specification and proofs about it that nothing imports.

    lambox-to-java/src/            the translation
      LambdaBox.ard                  λ□ syntax (MetaRocq's EAst)
      JavaAst.ard                    the Java fragment we commit to generating
      JavaPrint.ard                  that fragment as text -- TRUSTED, outside any proof
      ToJava.ard                     the generator: λ□ -> JavaAst
      JavaAxioms.ard                 what λ□ needs from the hand-written runtime
      NodePath.ard                   structural node paths, and the names derived from them
      StringUtil.ard, Serialize.ard  helpers; λ□ back out as an s-expression

    lambox-to-java/src/Formal/     the formalization (imported by nothing)
      JavaValue.ard                  values, outcomes, and the runtime interface RtSpec
      JavaEval.ard                   the fragment's semantics: a big-step evaluator
      RtLong.ard                     one RtSpec instance: the Long runtime
      NodePathUnique.ard             renderName is injective, so generated names are unique

    lambox-to-java/runtime/        Rt.java, hand-written, assumed rather than modelled
    lambox-to-java-examples/src/   λ□ programs, and the printers the harness drives
      Formal/JavaEvalRuns.ard        those programs run through the semantics
    test/                          the harness; see test/README.md

Nothing under `Formal/` is imported by the translation, so a normal compile never
typechecks it; name a module to check it (`arend arend.yaml Formal.JavaEval`).
