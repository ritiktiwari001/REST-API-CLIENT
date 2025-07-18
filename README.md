# REST-API-CLIENT
*COMPANYNAME*: CODETECH IT SOLUTION
*NAME*: RITIK KUMAR TIWARI
*INTERN ID*: CT06DF2939
*DOMAIN*: JAVA DEVELOPMENT
*DERATION*: 6 WEEK
*MENTOR*: NEELA SANTOSH

*DESCRIPTION*
THE WEATHERFETCHER JAVA PROGRAM IS A SIMPLE, WELL-DOCUMENTED APPLICATION DESIGNED TO DEMONSTRATE HOW TO CONSUME A PUBLIC REST API AND DISPLAY THE FETCHED DATA IN A STRUCTURED FORMAT. SPECIFICALLY, THIS PROGRAM CONNECTS TO THE OPENWEATHERMAP API TO RETRIEVE CURRENT WEATHER INFORMATION FOR A USER-SPECIFIED CITY. IT SERVES AS AN EXCELLENT EXAMPLE FOR STUDENTS AND DEVELOPERS WHO WANT TO LEARN HOW TO WORK WITH WEB APIs IN JAVA.

AT ITS CORE, THE PROGRAM USES JAVA’S BUILT-IN HTTPURLCONNECTION CLASS TO PERFORM AN HTTP GET REQUEST. THIS ALLOWS IT TO COMMUNICATE DIRECTLY WITH THE OPENWEATHERMAP SERVER OVER THE INTERNET. THE USER PROVIDES THE NAME OF THE CITY THEY WANT WEATHER INFORMATION FOR. THE PROGRAM BUILDS THE CORRECT API REQUEST URL BY INSERTING THE CITY NAME AND A VALID API KEY INTO THE REQUEST STRING. THIS STEP DEMONSTRATES HOW TO DYNAMICALLY CONSTRUCT API ENDPOINTS BASED ON USER INPUT.

ONCE THE CONNECTION IS OPENED, THE PROGRAM HANDLES THE SERVER’S RESPONSE CODE TO DETERMINE IF THE REQUEST WAS SUCCESSFUL. IT EXPLICITLY CHECKS FOR COMMON ERRORS SUCH AS 401 (UNAUTHORIZED, DUE TO INVALID API KEY) AND 404 (CITY NOT FOUND). THESE CHECKS MAKE THE PROGRAM USER-FRIENDLY BY PROVIDING CLEAR ERROR MESSAGES RATHER THAN JUST CRASHING OR SHOWING RAW ERRORS.

IF THE RESPONSE IS SUCCESSFUL (HTTP 200), THE PROGRAM READS THE RESPONSE BODY USING A BUFFEREDREADER. IT BUILDS THE ENTIRE JSON RESPONSE INTO A STRING. SINCE THIS PROGRAM IS MEANT AS AN EASY-TO-UNDERSTAND EXAMPLE, IT DOES NOT USE A COMPLEX JSON LIBRARY. INSTEAD, IT INCLUDES A SIMPLE extractBetween METHOD THAT EXTRACTS THE NEEDED FIELDS—SUCH AS WEATHER DESCRIPTION AND TEMPERATURE—BY LOCATING THE TEXT BETWEEN SPECIFIC MARKERS IN THE JSON.

AFTER OBTAINING THE TEMPERATURE VALUE, THE PROGRAM CONVERTS IT FROM KELVIN (THE DEFAULT UNIT FROM OPENWEATHERMAP) TO CELSIUS BY SUBTRACTING 273.15. THIS EXTRA STEP MAKES THE OUTPUT MORE USEFUL AND HUMAN-FRIENDLY. IT ALSO DEMONSTRATES HOW TO PROCESS AND TRANSFORM DATA AFTER FETCHING IT FROM AN API.

THE PROGRAM THEN PRINTS A STRUCTURED WEATHER REPORT TO THE CONSOLE. THE OUTPUT INCLUDES CLEARLY LABELED FIELDS SUCH AS CITY NAME, WEATHER DESCRIPTION (WITH THE FIRST LETTER CAPITALIZED FOR READABILITY), AND TEMPERATURE IN CELSIUS FORMATTED TO TWO DECIMAL PLACES. THE REPORT IS ENCLOSED IN A DECORATIVE BORDER MADE WITH DASHES TO MAKE IT EASY TO READ.

THE CODE IS WELL-DOCUMENTED, WITH A CLASS-LEVEL JAVADOC COMMENT THAT EXPLAINS THE OVERALL PURPOSE, FEATURES, AND REQUIREMENTS (INCLUDING NEEDING AN OPENWEATHERMAP API KEY). EACH METHOD IS ALSO DOCUMENTED WITH JAVADOC COMMENTS DESCRIBING ITS PARAMETERS, PURPOSE, AND BEHAVIOR. THIS MAKES THE PROGRAM VERY SUITABLE AS A TEACHING RESOURCE OR A STARTING POINT FOR MORE ADVANCED PROJECTS.

IN ADDITION, THE PROGRAM INCLUDES GOOD JAVA PRACTICES SUCH AS CLOSING THE SCANNER RESOURCE AND HANDLING EXCEPTIONS GRACEFULLY BY PRINTING MEANINGFUL ERROR MESSAGES AND STACK TRACES. THIS ENSURES THAT USERS AND DEVELOPERS CAN UNDERSTAND WHAT WENT WRONG IF SOMETHING FAILS.

OVERALL, THE WEATHERFETCHER PROGRAM COMPLETELY FULFILLS THE REQUIREMENT OF WRITING A JAVA APPLICATION THAT CONSUMES A PUBLIC REST API AND DISPLAYS THE DATA IN A STRUCTURED FORMAT. IT IS SIMPLE, EDUCATIONAL, AND EASY TO EXTEND OR CUSTOMIZE FOR FUTURE IMPROVEMENTS, SUCH AS USING A PROPER JSON LIBRARY, ADDING MORE WEATHER DETAILS, OR SUPPORTING DIFFERENT UNITS OF MEASUREMENT.


*OUTPUT*

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/c166f84b-2be8-453e-8acd-3af84174714c" />
