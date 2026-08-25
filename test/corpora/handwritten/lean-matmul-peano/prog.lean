import LeanToLambdaBox

inductive LList (α : Type) where
  | nil
  | cons (head : α) (tail : LList α)

def buildFrom (f : Nat → α) : Nat → Nat → LList α
  | 0, _ => .nil
  | remaining + 1, index => .cons (f index) (buildFrom f remaining (index + 1))

def build (size : Nat) (f : Nat → α) : LList α :=
  buildFrom f size 0

def nth (fallback : α) : LList α → Nat → α
  | .nil, _ => fallback
  | .cons head _, 0 => head
  | .cons _ tail, index + 1 => nth fallback tail index

def column (fallback : α) (matrix : LList (LList α)) (index : Nat) : LList α :=
  match matrix with
  | .nil => .nil
  | .cons row rows => .cons (nth fallback row index) (column fallback rows index)

def dot : LList Nat → LList Nat → Nat
  | .cons x xs, .cons y ys => x * y + dot xs ys
  | _, _ => 0

def matMul (rows columns : Nat) (left right : LList (LList Nat)) : LList (LList Nat) :=
  build rows fun row =>
    build columns fun col =>
      dot (nth .nil left row) (column 0 right col)

def sumList : LList Nat → Nat
  | .nil => 0
  | .cons head tail => head + sumList tail

def sumMatrix : LList (LList Nat) → Nat
  | .nil => 0
  | .cons row rows => sumList row + sumMatrix rows

def size : Nat := 20

def ones : LList (LList Nat) :=
  build size fun _ => build size fun _ => 1

def leanMatMulSumPeano : Bool :=
  Nat.beq (sumMatrix (matMul size size ones ones)) (size * size * size)

#erase leanMatMulSumPeano config { nat := .peano, extern := .preferLogical } to "prog.ast"