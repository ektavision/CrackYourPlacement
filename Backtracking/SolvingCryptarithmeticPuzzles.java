static boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
    if (lettersToAssign.isEmpty()) 
        return puzzleSolved(puzzle);
    for (int digit = 0; digit <= 9; digit++) 
    {
        if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
            if (exhaustiveSolve(puzzle, lettersToAssign.substring(1)))
                return true;
            unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
        }
}
    return false;
}