# Track My Flight.

Flight tracker retrieves informartion from the AirLabs API for all the airports and allows you to book a flight at the comfort of your zone.
## Author
- [Gilbert Korir](https://github.com/gilbertKorir)

## Features
* Sign up/Login
* view airports with their detailed informations.
* Search the available airports by countries.
* save the airport.
* Book a flight.
* check the status of your flight.


## Upcoming Features
* Adding a camera utilization.
* Configuring the book flight form.

## Getting Started

* Clone the repo
* Open the terminal and navigate to appropriate folder
* type git clone followed by the link you just copied
* add appropriate dependencies
* open the file and run the MainActivity.java class
* Click on the start register button
* Log in and select the events as many as possible.

## Screenshots

<img src="https://i.postimg.cc/MTbLPbn0/Whats-App-Image-2022-06-19-at-9-24-25-PM-1.jpg" alt="Home" width="300" height="500">&nbsp;&nbsp;<img src="https://i.postimg.cc/jdj1cftN/Whats-App-Image-2022-06-19-at-9-24-23-PM.jpg" alt="Home" width="300" height="500></br>
<img src="https://i.postimg.cc/MH6FhMBC/Whats-App-Image-2022-06-19-at-9-24-25-PM.jpg" alt="Home" width="300" height="500>&nbsp;&nbsp;<img src="https://i.postimg.cc/bYgM1gcp/Whats-App-Image-2022-06-19-at-9-24-24-PM-1.jpg" alt="Home" width="300" height="500></br>
<img src="https://i.postimg.cc/5NkRRt2r/Whats-App-Image-2022-06-19-at-9-24-24-PM.jpg" alt="Home" width="300" height="500>&nbsp;&nbsp;<img src="https://i.postimg.cc/zvxc5zSV/Whats-App-Image-2022-06-19-at-9-24-23-PM-1.jpg" alt="Home" width="300" height="500>

### Prerequisites

* Android Studio
* Jdk

## Technologies Used
* Java
* The libraries below were useful in the development of the application <br />
```
dependencies {

    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.6.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'com.jakewharton:butterknife:10.2.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.0'
}
```
### Dependencies and Testing

<details>
  <summary> Check the dependencies here.</summary>

```
dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.0'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'com.jakewharton:butterknife:10.2.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.0'
//    implementation 'com.google.code.gson:gson:2.8.7'
    implementation 'com.squareup.picasso:picasso:2.8'
    //retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    //parceler
    implementation 'org.parceler:parceler-api:1.1.12'
    annotationProcessor 'org.parceler:parceler:1.1.12'
    //test0'
    implementation platform('com.google.firebase:firebase-bom:26.4.0')
    implementation 'com.google.firebase:firebase-analytics'
    implementation 'com.google.firebase:firebase-database'
    //firebase ui
    implementation 'com.google.firebase:firebase-database'
    implementation 'com.firebaseui:firebase-ui-database:7.1.1'
    //auth
    implementation 'com.google.firebase:firebase-auth'

//Robolectric dependencies
testImplementation 'org.robolectric:robolectric:4.8.1'
}
```
</details>


## Support and contact details
If you come across any problems you can reach me at gilbertkorir031@gmail.com.

## LICENSE
MIT This project is licensed under the terms of the MIT license. Copyright (c) 2022 Gilbert Korir

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.