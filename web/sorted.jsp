<%@ page import="java.util.ArrayList" %>
<%@ page import="users.Student" %>
<%@ page import="dao.DBStudent" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отсортированный список студентов</title>
    <link rel="stylesheet" href="example.css">
</head>
<script>
    function toLink(req) {
        document.location.href = "sorted.jsp" + req;
    }
</script>
<body>
<%
    ArrayList<Student> students = new DBStudent().getAllStudents();
    String upper = request.getParameter("upper");
    upper = (null == upper || upper.equals("0"))?"1":"0";
    Map<String, Student> studentsSorted;
    studentsSorted = upper.equals("0")?new TreeMap<>():new TreeMap<>(Collections.reverseOrder());
    String sort = request.getParameter("sort");
    sort = null != sort?sort:"";

    switch (sort) {
        case "name": students.forEach(s -> studentsSorted.put(s.getName() + s.hashCode(), s));
            break;
        case "age": students.forEach(s -> studentsSorted.put(s.getAge() + " " + s.hashCode(), s));
            break;
        case "group": students.forEach(s -> studentsSorted.put(s.getGroupNumber() + " " + s.hashCode(), s));
            break;
        default: students.forEach(s -> studentsSorted.put(s.getId() + " ", s));
    }
%>
<table id="customers">
    <tr>
        <th onclick="toLink('?sort=name&upper=<%= upper%>')">Имя</th>
        <th onclick="toLink('?sort=age&upper=<%= upper%>')">Возраст</th>
        <th onclick="toLink('?sort=group&upper=<%= upper%>')">Группа</th>
    </tr>
    <%
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsSorted.forEach((key, value) -> studentsList.add(value));
        for (Student s: studentsList) {
            String row = String.format("<tr><td>%s</td><td>%d</td><td>%d</td></tr>",
                    s.getName(), s.getAge(), s.getGroupNumber());
            out.print(row);
        }
    %>

</table>

</body>
</html>
