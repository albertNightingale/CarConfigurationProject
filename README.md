# CarConfigurationProject written in Java
This is actually separated into two projects, one project is the server, while the other is the client. 
The server will ask the client for three options: 
1. upload a file for the server to read to the memory and store to the car list. 
2. configure an automotive(basically select features the user wish to get when buying the car)
0. leave. 

The project composes 6 parts, with the last part still in process: 
1) Setting up the model package for creating automotive object and util package for reading/writing/serializing files
2) Writing APIs and catch some of my own exceptions
3) Having the program read multiple files and therefore put them into a list. 
4) Give the capability for multiple access to the automotive list created in lab 3 at once. 
5) Build the server and the client so they may communicate to each other in different devices. 
