
# TipCalculator
App calculating tip

Overview: A modern, user-friendly Android tip calculator built with Kotlin that helps users calculate tips, split bills among multiple people, and quickly select common tip percentages. The app provides real-time updates as users adjust inputs, making it fast and intuitive to use in restaurant settings.

Key Features:
Real-time tip and total calculations
Bill splitting functionality (1-10 people)
Quick tip preset buttons for common percentages
Dynamic tip quality descriptions
Clean, material design UI

Enhancements Beyond Baseline
1. Bill Splitting Feature
Added SeekBar to split bills among 1-10 people
Calculates and displays the amount per person in real-time
Per-person amount highlighted in accent color for easy visibility
Includes the second visual divider to separate a split section

Changes made:
MainActivity.kt
Added 3 new variables: seekBarSplit, tvSplitCount, tvPerPersonAmount
Added initialization for split views in onCreate()
Added SeekBar listener for split count changes
Updated calculateTip() to calculate and display the amount/person
Handles empty input by clearing the amount/person field too

activity_main.xml
Added second divider after Total Amount
Added "Split Bill" section with: Label for Split Bill; SeekBar (max 10 people); TextView showing split count
Added "Per Person" section displaying the amount per person
Per person amount uses @color/accent (green) for emphasis

strings.xml
Added label_split_bill: "Split Bill"
Added label_per_person: "Per Person"
Added split_count_format: "%d" (for formatting the count)
Added split_count_placeholder: "1" (default display)

2. Quick Tip Presets
Four preset buttons: 10%, 15%, 18%, 20%
One-tap selection for common tip percentages
Beautiful blue buttons with rounded corners and ripple effects
Automatically syncs with the tip percentage SeekBar
Saves time compared to manually adjusting the slider

Changes Made:
MainActivity.kt:
Added 4 button variables: btnTip10, btnTip15, btnTip18, btnTip20
Added click listeners for each preset button
New setTipPercent() function that updates the SeekBar

activity_main.xml:
Added a horizontal LinearLayout with 4 preset buttons
Buttons are evenly spaced using layout_weight
Each button is clickable and focusable with a ripple effect

strings.xml: Added 4 new strings: tip_preset_10, tip_preset_15, tip_preset_18, tip_preset_20
dimens.xml: Added padding_button for button padding
colors.xml: Added white color for button text; Added button_preset (blue) for button background
button_preset.xml (NEW FILE): 
Create this file in res/drawable/button_preset.xml
Provides rounded corners and ripple effect for buttons

The setup and Run Instructions:
Prerequisites:
Android Studio (Arctic Fox or later recommended)
Android SDK (API Level 24 or higher)
Kotlin plugin enabled

Installation Steps:
Create a new project repo named “TipCalculatorApp” on the github
Copy https://github.com/kson115/TipCalculator.git
Launch Android Studio
Click on "Clone Repository" and paste the copied URL into the URL box
Copy the essential files from the local project folder into the cloned folder
Android Studio automatically prompts to sync and see the TipCalculator emulators

Project Structure is organized as follows:	
app/build/outputs/apk/debug/app-debug.apk 
app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
app/src/main/java/com/example/tipcalculator/MainActivity.kt
app/src/main/res/drawable/button_preset.xml
app/src/main/res/layout/activity_main.xml
app/src/main/res/values/colors.xml
app/src/main/res/values/dimens.xml
app/src/main/res/values/strings.xml
app/src/main/res/values/themes.xml
app/src/main/AndroidManifest.xml

The APK (app-debug.apk) was tested on a fresh emulator to confirm it installs and runs correctly. Additionally, the app was verified on a fresh emulator to ensure it functions independently of cached data or prior installations.

Screenshots: 
<img width="775" height="1438" alt="bill500Tip30Split8" src="https://github.com/user-attachments/assets/72d2682e-74a4-48b1-b008-76770bdf7097" />
<img width="770" height="1460" alt="bill300Tip20Split10" src="https://github.com/user-attachments/assets/d6516287-f1e2-4488-805d-4e772fe22be9" />
<img width="787" height="1439" alt="bill100Tip25" src="https://github.com/user-attachments/assets/ccbf1842-bb89-477b-8ebf-989658b3f2af" />
<img width="790" height="1458" alt="bill100Tip20Split10" src="https://github.com/user-attachments/assets/5dd83a9a-5146-4c50-bcea-871907ef184c" />
<img width="777" height="1469" alt="bill100Tip20Split5" src="https://github.com/user-attachments/assets/8a474df8-832b-4574-b751-3f40e3bcb6fd" />
<img width="782" height="1453" alt="bill100Tip20Split2" src="https://github.com/user-attachments/assets/5e5928b2-401d-4859-a66e-c6f3b5379400" />
<img width="766" height="1430" alt="bill100Tip20" src="https://github.com/user-attachments/assets/20ffb169-6cc1-4922-b3c1-4e6592967265" />
<img width="777" height="1437" alt="bill100Tip18Preset" src="https://github.com/user-attachments/assets/f3d3e298-a17d-4488-8a46-6b3d3c709270" />
<img width="767" height="1464" alt="bill100Tip15" src="https://github.com/user-attachments/assets/bc4806ba-a673-401a-ac95-603dba4dc788" />
<img width="778" height="1492" alt="bill100Tip10" src="https://github.com/user-attachments/assets/edf8fe21-f1d8-43f9-8ca0-99ab802716eb" />
<img width="594" height="1489" alt="bill100Tip0" src="https://github.com/user-attachments/assets/debd5714-b699-4405-9b68-4b45c1bed738" />
<img width="783" height="1489" alt="basicApp+2funcDefault" src="https://github.com/user-attachments/assets/3a592785-1b7e-4897-9f0b-241a36c563c3" />
<img width="616" height="1180" alt="basicApp" src="https://github.com/user-attachments/assets/0fc75d0d-7a37-44b0-85cb-38027cf3a274" />
<img width="2424" height="1080" alt="freshEmulatorAPK90DegreeLeft" src="https://github.com/user-attachments/assets/d313674a-fe9d-45d7-8a25-59e628773542" />
<img width="1743" height="1550" alt="reopenFreshEmulatorAPKTip25Bill300Split5" src="https://github.com/user-attachments/assets/a196170b-9369-41a6-a5cf-ce150a228543" />
<img width="1744" height="1518" alt="freshEmulatorAPKTip20Bill200Split3" src="https://github.com/user-attachments/assets/f62783eb-8100-43ce-8a8c-c42063801787" />
<img width="1728" height="1447" alt="freshEmulatorAPKTip15Bill200Split10" src="https://github.com/user-attachments/assets/61e2e088-9c3f-42b3-b211-13580d97e42d" />
<img width="1758" height="1572" alt="freshEmulatorAPKTip15Bill100Split2" src="https://github.com/user-attachments/assets/4656cd0c-f12a-417b-8148-e782f887aea0" />
<img width="656" height="1464" alt="freshEmulatorAPKTip15" src="https://github.com/user-attachments/assets/e48330b6-f03a-48d8-911b-ddf3b06a8882" />

Demo Video:
https://drive.google.com/file/d/1-JndfefES9vqWY5cTtGE5uQcIreVXIXX/view?usp=sharing
https://drive.google.com/file/d/1Ehowysx9qi9y7iVVoOlo_3zRS-ozw0o-/view?usp=sharing

Technical Specifications: 
Language: Kotlin 1.8+
Min SDK: 24 (Android 7.0 Nougat)
Target SDK: 34 (Android 14)
Architecture: Single Activity, Direct View Binding
UI: XML Layouts with Material Components
Build System: Gradle (Groovy DSL)

Dependencies:
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

Architecture and Design Notes: This app uses (1) a single Activity architecture with direct findViewById() view binding, keeping the implementation simple for a single-screen calculator. All business logic resides in MainActivity, with real-time calculations triggered by TextWatcher and SeekBarChangeListener events that immediately update the UI through the calculateTip() method, (2) a stateless approach where all state derives from UI inputs, meaning data doesn't persist across screen rotations: While a ViewModel could preserve state, the added complexity isn't justified for a simple calculator, (3) Input validation Kotlin's toDoubleOrNull() to handle invalid inputs by clearing outputs rather than showing errors, (4) UI choices to include SeekBar for tip percentage (0-30%) providing visual, touch-friendly input that prevents invalid values, complemented by four preset buttons (10%, 15%, 18%, 20%) for quick common selections. Bill splitting is capped at 10 people, covering typical use cases while keeping the interface simple. All strings, dimensions, and colors are externalized to XML resources for maintainability and future localization, and (5) only local O(1) calculations and no network or database operations. Overall, the app meets basic accessibility standards with scalable text and proper touch targets, though it lacks content descriptions for screen readers.

Reflection: Future Refactoring
My top refactoring priority would be implementing ViewModel with SavedStateHandle to preserve user input across configuration changes—currently rotating the device loses all data. Second, I'd migrate to ViewBinding for compile-time safety and cleaner code. Third, I'd extract calculation logic into a separate TipCalculator class to enable simple unit testing. Finally, I'd add accessibility improvements including contentDescription attributes for TalkBack support, making the app usable for visually impaired users. All these implementations will need a lot of work and time.

Acknowledgments: This app was created based on the video provided and communications with AI

Quick Submission Checklist
☑ App compiles and runs without crashes
☑ Baseline features match the video app
☑ Two enhancements implemented and visible in the demo
☑ Readme includes overview, features, setup, screenshots, and video link
☑ APK uploaded; repo access granted
>>>>>>> ce29e68b4ad6194bfa9c2b904683c13d8f92bc47


