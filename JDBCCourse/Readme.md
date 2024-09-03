Maven :
-----
- is a project management tool, its an apache prjct
- libraries in java is present in jar files
- transitive dependencies as that of in hibernate, it need multiple jar files.....implies main dependent is in one jar file and hibernate itself is depended on another jar files
- when we ask maven for some dependency,
    1. searches for jar files in local machine in m2 folder which shows option for dependency
    2. if it is present in m2 folder then it returns the same
    3. if not present it will go to maven central and finds the dependency
- in companies to provide security to vulnerable dependency they use company wide repository which tests the dependency and then only uses it

JDBC :
------ 
- building applicant to interact with data like storing, fetching, updating etc
- all our data gets stored as variables eg for a number we use int, for point value we use double....since we need to store permanently, we use relational database management system (SQL)
- database <-> Application <-> user
- above application can be built with java language (between user and app)
- between database and app we use jdbc
- jdbc is a api ie., part of jdk
- jdbc steps
    1. Import Packages
    2. Load Driver (register sim): import jar files
    3. Register Driver (register sim card)
    4. Create Connection (make sure i have connection): connection of obj in jdbc
    5. Create Statement(ie. thinking wht u have to say)
    6. Execute Statement (then u have to say it): process wht the frnd told
    7. close: when completed whole thing, just close the connection otherwise u will leak memory and connections


- say eg im taking work from home nd if i want to know wht is happening in office, i'll make a call to my colleague and for the same i need a phone.... so here phone acts as a jar file. Next we have to make sure that we have a sim card which is working and also we need network in my area and that is loading and registering the driver means. Next we have to make sure u have connection ie., ofc i need network in my area also i need connection to call people ie., meant by connection.
  Once the frnd picks up the call, u will think wht u have to say next like greeting nd all nd then we will shoot the actual qn (ie., request) nd then the frnd will respond or gives the response to the qn nd u have to process the response, once responded we can simply close the connection ie. cut the call otherwise u have to pay a huge bill
