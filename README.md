# Trip Planner
* Your task is to build a simple trip planner application.
* It stores locations, which all have the following common attributes: X
and Y coordinates.
* All locations are divided into the following subcategories:
    * Landmark: This has a name. Its coordinates can only be set once.
And they have an entrance fee that can be set multiple times with a
validation for negative values
    * City: This object also has a name. Its coordinates can only be set
once. Also it needs a method that returns all the landmarks in a 50km
area.
    * UserLocation: The current location of the user. Also this object
stores the coordinates every time it is set and can return them to
show the user his/her location history.
* Furthermore every location has a method that can return the closest
city to it. Implement the above in an OOP way!
***
* Note: Your can assume that the earth is flat, i.e. there is no need to
wrap around coordinates.