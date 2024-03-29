<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Faculty Management System</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/table.css" rel="stylesheet" type="text/css"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">
            <h1>FACULTY MANAGEMENT SYSTEM</h1>
        </div> <!-- end of templatemo_header -->

        <div id="templatemo_menu">

            <ul>
                <li><a href="#" class="current">Home</a></li>
                <li><a href="userList?page=list">User</a></li>
                <li><a href="teacherList?page=list">Faculty</a></li>
                <li><a href="logout?page=logout">Logout</a></li>
            </ul>

        </div> <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="userList?page=list">User list</a></li>
                        <li><a href="TeacherList?page=list">Faculty list</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>


            <div id="templatemo_content">

                <div class="content_section">

                    <h2>Fill the required information </h2>
                    <form method="post" action="addTeacher">
                        <input type="hidden" name="page" value="addTeacher">


                        <table id="t01">
                            <tr>
                                <th>Teacher Name</th>
                                 <td><input type="text" name="teachername" placeholder="Your name" required="required" autofocus></td>
                            </tr> 

                            <tr>
                                <th>Subject</th>
                                 <td><input type="text" name="subject" placeholder="Your subject of study" required="required"></td>
                            </tr> 

                            <tr>
                                <th>Qualification</th>
                                 <td><input type="text" name="qualification" placeholder="Your qualification" required="required"></td>
                            </tr>
                            <tr>
                                 <td colspan="2"><input type="submit" value="Add Teacher"></td>
                            </tr>
                        </table>
                    </form>
                </div>

            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">

            This is Footer
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>
