# Fix Compilation and Runtime Errors

The project currently fails to build due to a `compileSdk` version mismatch and several Kotlin compilation errors in `MainActivity.kt`.

## Proposed Changes

### Build Configuration

#### [MODIFY] [app/build.gradle.kts](file:///C:/Users/julia/AndroidStudioProjects/Unscramble1/app/build.gradle.kts)
- Update `compileSdk` from 36.1 to 37 to satisfy dependency requirements (e.g., `androidx.core:core-ktx:1.19.0`).

### UI Logic

#### [MODIFY] [MainActivity.kt](file:///C:/Users/julia/AndroidStudioProjects/Unscramble1/app/src/main/java/com/example/unscramble1/MainActivity.kt)
- Fix `Unresolved reference 'shuffled'` by converting `String` to `List<Char>` before shuffling: `words[currentWordIndex].toList().shuffled().joinToString("")`.
- Resolve type inference errors for `remember` blocks by fixing the underlying expressions.
- Optimize state management by using `mutableIntStateOf` for `currentWordIndex` and `score`.
- Add necessary imports for `mutableIntStateOf`.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:assembleDebug` to ensure the project compiles successfully.

### Manual Verification
- Deploy the app to a device or emulator and verify:
    - The scrambled word is displayed.
    - Entering the correct answer and clicking "SUBMIT" increments the score and moves to the next word.
    - The app does not crash.
