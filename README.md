Stephanos Kungfu Club



SKF is a martial arts school with hundreds of students.  SKF has these requirements:
•	There is only one instructor who teaches all classes
•	Students are given a student number when they join the school.  This is stored along with their name, date of birth, the date they joined the school, their mobile number, email, and address.  
•	The school wants to track also the students’ parents (Mother and/or Father). Assume that students live with their parents. Not all students have parents (some students might be adults so need to keep track of their parents). We need to store also their mobile phone and email address. Parents may also be students.
•	Students pay fees for membership, tests, purchasing products, etc. The system must be able to keep track of all money received from students. The system should be able to show this information for any given date, e.g. by month or within a range such as from Jan 1-Jan 20th.
•	A class is offered for a specific level at a specific time, day of the week.  For example, one class taught on Mondays at 5:00 pm is an intermediate-level class.  Another class taught on Mondays at 6:00 pm is a beginner-level class.  A third class taught on Tuesdays and Thursdays at 5:00 pm is an advanced-level class, and so on.  There are different levels of classes. These provided here are only as an example.
•	Students may attend any class at any level during each week so there is no expectation that any particular student will attend any particular class session.  Therefore, the actual attendance of students at each individual class meeting must be tracked.
•	Each student holds a rank in the martial arts.  The rank name, belt color, and rank requirements are stored.  Each rank will have numerous rank requirements.  Each requirement is considered a requirement just for the rank at which the requirement is introduced.  Every requirement is associated with a particular rank.  All ranks except white belt have at least one requirement.
•	A given rank may be held by many students.  While it is customary to think of a student as having a single rank, it is necessary to track each student’s progress through the ranks.  Therefore, every rank that a student attains is kept in the system.  New students joining the school are automatically given a white belt rank.  The date that a student is awarded each rank should be kept in the system.  All ranks have at least one student that has achieved that rank at some time.
•	The system should be able to produce dynamic (not static) reports. For example, the admin may want to see all current (active) students, students of a particular rank (e.g. red belt), Students who joined in a specific year and are black belt, etc.


➢	The Project has been made on Netbeans 8.1.
➢	The framework used is Spring 4.0.1 and Hibernate 4.3.x(JPA2.1)
➢	To access the database in Spring we have added MySQL JDBC Driver library.
➢	We first created the database and after that we mapped it using Spring ( using @ Annotations).
➢	In this project, we added or inserted the values manually (using MySQL (Insert)) in Meeting, Class, Fees, Rank and Parents in the backend. 
➢	We can add students through the frontend (using java Getter and Setter).
➢	To access the data on our webpages we have embedded MySQL code(Select) in our Java class files.

Usernames and Passwords

When you start running the Project, you will encounter a login page. You need the following login information:
➢	Username : chonzom or prabhjot
➢	Password : drish
We have included the admin information in a Members table for which values were inserted using MySQL (Insert).

JDBC Properties for database

➢	jdbc.driverClassName = com.mysql.jdbc.Driver
➢	jdbc.url = jdbc:mysql://localhost:3306/springhib
➢	jdbc.username = root
➢	jdbc.password = chonzom

