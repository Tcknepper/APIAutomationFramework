APIAutomationFramework

I created this project to build on the previous experience I gained making the AutomationFramework project. In order to 
expand my knowledge in Software Quality Assurance I decided to learn API testing. I started with API tests in PostMan
and then used that to move into making automated tests in Java with REST Assured. I made this project to help test myself 
and solidify what I had learned. The project uses the GitHub API to create and delete repositories in a dummy 
account I set up.

The framework is organized with a base class containing methods for all of the different calls you could make like get, post, 
put, or delete. It also contains a package called utility which contains classes and methods to perform common functions
like creating urls, authenticating, generating a payload, getting values from a response, and getting status codes. There is a 
package called pojoClasses that contains the POJO class which is used to make a request. The final package is called
resources and it contains a JSON file used as a payload to make a request. 

The test source folder contains the class with the actual tests. I only performed 4 tests in total, 2 for creating and 2 for deleting
repositories. Two of the tests create a repository, one using a POJO, and the other uses the JSON file as a payload. The other two tests
delete a repository, one uses the JSON file, and the other uses the POJO.

Since my previous project used Jenkins I did not feel the need to do that with this project. This one can simply be ran in an IDE as a 
TestNG Suite and only requires Java and Maven.

I hope you enjoy this project!
