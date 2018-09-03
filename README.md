# Android-Proficiency-Exercise
Android Proficiency Exercise for Telstra

An android application to display facts feed of a country in listview from an api endpoint. It follows the MVVM design pattern and uses Live Data to update the ui. 

                   View -> ViewModel -> Repository -> Netwrok -> Live Data -> View
                   
This application endpoint has page title and feed details like heading, description and image url. Below are the external libraries used.

    Retrofit : To connect with the endpoint and returns the json result asynchronously.
    Picasso : To lazy load image from the given url.
    Life cycle Extensions : Has some extension method used for View model creation.
    Robolectric : Used for Unit testing.

