<%@ page import="com.game.GameField" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>game.jsp</h1>
    <h1>${hello}</h1>

    <script>
        function print(){
            var field = <%=((GameField)request.getAttribute("field")).getArray()%>;
            for (var i = 0; i < 16; i++){
                document.write(field[0])
            }
            alert("!!!");
        }
    </script>

</body>
</html>