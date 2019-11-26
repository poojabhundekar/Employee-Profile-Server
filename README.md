# Employee profile spring boot application
Employee profile is a spring boot-enabled, Angular 8 application.
- Angular application link can be found here (https://github.com/poojabhundekar/employeeprofile)

  - Register an Employee with first name, last name, gender and date of birth fields
  - See the employee list in the home page
  - Delete employee from home page

Following Methods available:
1.  GET /empapiserver/user/get-users -  Get all employee details
2.  POST /empapiserver/user/save-user with data - Add New Employee to MongoDB
3.  DELETE /empapiserver/user/delete-user/{id} - Remove employee details from MongoDB.
# Prequisites
1.  Have Maven downloded and is in Path.
2.  Java 8
3.  MongoDB Installed.

# How to run this sample
1.  Download and extract this project.
2.  Start MongoDB with
3.  Change your MongoDb configuration in src/java/resource/application.properties
4.  Go to CMD and run mvn clean install
5.  Go to browser type http://localhost:8080/api/employees