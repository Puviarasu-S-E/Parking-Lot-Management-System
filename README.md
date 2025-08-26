# Parking-Lot-Management-System
A Java application designed to manage parking slots efficiently. It allows attendants to allocate parking slots, record vehicle details, calculate fees, and free up slots upon exit.

Project Overview

This is a simple Java-based Parking Lot Management System.
It helps efficiently manage parking spaces by allowing attendants to assign slots, record vehicle details, calculate parking fees, and free up slots when vehicles leave.
The project is implemented in three phases:
Console Application (Phase I): Basic slot allocation, vehicle entry/exit via command line.
Database Integration (Phase II): Parking data stored in a database for persistence.
JavaFX GUI (Phase III): A visual interface to display slot availability and manage operations using forms and buttons.

Features
User/Attendant Module
Assign vehicles to available parking slots.
Record vehicle details (registration number, type).
Free up slots when vehicles leave.
View current parking lot status.

Admin Module
View all parked vehicles.
Monitor available and occupied slots.
View history of parking (with DB integration).
Apply filters (vehicle type, status).
Parking Fee Management
Calculate parking fees based on vehicle type and duration.
Different fee rates for Car, Bike, and Truck.

Storage

Phase I: Data stored in memory during execution.

Phase II: Data persisted in a database (MySQL/PostgreSQL).

Phase III: GUI connected to the database.

How It Works
Run ParkingApp.java (for Phase I).
Choose operations:
Add slots (addslot)
Park vehicle (park)
Leave slot (leave)
Check status (status)

Parking fee calculated automatically based on vehicle type and hours parked.
In later phases, data is saved in the database and managed through a GUI.

Running the Project
Using Command Line

Compile the program:

javac ParkingApp.java


Run the program:
java ParkingApp
Using an IDE (IntelliJ / Eclipse / NetBeans)
Import the project folder.
Run ParkingApp.java (Phase I) or Main.java (for later phases).

Sample Commands (Phase I)
addslot 1 CAR
addslot 2 BIKE
park TN07AB1234 CAR
park TN22XY9876 BIKE
leave 1 3
status
exit

Sample Output
> addslot 1 CAR
Slot added.
> park TN07AB1234 CAR
Parked at slot 1, ticket 123e4567-e89b-12d3-a456-426614174000
> status
Slot   Type     Vehicle          Free?
1      CAR      TN07AB1234       false
2      BIKE     -                true
> leave 1 3
Freed slot 1. Fee = 80

Author

Developed by Puviarasu
Beginner-friendly project for learning Java, OOP, File Handling, Database, and JavaFX.
