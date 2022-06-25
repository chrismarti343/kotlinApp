# Overview

Nowadays, many businesses need to improve the way they register an employee, and the way managers verify the information. The idea of this project started after seeing my manager looking for any employee information on a web page. I thought it would be more efficient if my manager could pull up his phone and manipulate employee data from his phone instead of using a computer.


In this project, I also demonstrate the use of classess, functions, and variables in Kotlin. It is also made to show how to use basic functions on a kotlin app such as; the use of buttons, navigation, use of variables, inserting data into a database, and retrieving data. 

### How to use program

#### First screen
On the first page, the user will be able to insert data into the database. There are three fields to fill out. Employee name, number of hours employe work, and salary. When the user has already filled out all the three fields, then the user will be able to click on the "Insert" button. The data will be saved into the firebase database. Finally, the field will clear to allow the user to insert new data.

#### Second screen
On this screen, the user can search for a specific employee name. When the user clicks on "Read Data" the field will clear, and the employee's information will be displayed below the input section. The input field will also be clear to allow the user to input a new employee name. 


[Software Demo Video](https://youtu.be/3nCOBFbX2KU)

# Development Environment

### Tools
* Android Studio: This is an integrated environment designed especially for Android development. It was usefuil to run my code and see how the changes would see in the actual device.
* Guthub: Is the provider of internet hosting to save my code and manipulate my code online.
* Kotlin: Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library.
* Firebase: Firebase is a platform developed by Google for creating mobile and web applications. It allows users to save any kind of data.

### Libraries
* Google-services: Th8is plugin help as to connect Kotlin project with Firebase plataform.
* kotlin-parcelize: When you annotate a class with @Parcelize, a Parcelable implementation is automatically generated.
* Data Binding: The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.



# Useful Websites

* [Data Binding](https://developer.android.com/topic/libraries/data-binding)
* [Add Firebase to your Android project](https://firebase.google.com/docs/android/setup)
* [Connect to Firebase](https://developer.android.com/studio/write/firebase)
* [Read and Write Data on Android](https://firebase.google.com/docs/database/android/read-and-write)



# Future Work

* Update function: The admin will be able to modify employee information
* Work time function: The employee will be able to check in and check out in the app
* Salary calculation: The app will calculate the hours the employee work and it will be multiply by the salary per hour to get the totall amount for the week. 
