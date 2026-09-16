# Fix Compilation and Dependency Errors

The project fails to build due to missing Compose ViewModel dependencies and a `compileSdk` version mismatch. Additionally, the `GameViewModel` state is not observable by Compose.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/julia/AndroidStudioProjects/Unscramble1/gradle/libs.versions.toml)
- Add `androidx-lifecycle-viewmodel-compose` to the `[libraries]` section.

#### [MODIFY] [app/build.gradle.kts](file:///C:/Users/julia/AndroidStudioProjects/Unscramble1/app/build.gradle.kts)
- Update `compileSdk` and `targetSdk` to 37.
- Add `libs.androidx.lifecycle.viewmodel.compose` to dependencies.

### ViewModel Logic

#### [MODIFY] [GameViewModel.kt](file:///C:/Users/julia/AndroidStudioProjects/Unscramble1/app/src/main/java/com/example/unscramble1/GameViewModel.kt)
- Convert `currentWordIndex`, `score`, and `userAnswer` to use `mutableStateOf` to enable Compose recomposition.
- Add necessary imports for Compose state.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:assembleDebug` to ensure the project compiles successfully.

### Manual Verification
- Deploy the app and verify that the UI correctly reflects the state from the `GameViewModel`.
