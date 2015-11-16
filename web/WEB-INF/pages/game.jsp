<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.game.GameField" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% GameField gameField = (GameField) session.getAttribute("gameField"); %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>game.jsp</h1>
    <h1>${hello}</h1>

    <div>
        <h2 id="score">Score 0</h2>
        <table border=1 style="table-layout: fixed; width: 200px; height: 100px">
            <%for (int i = 0; i < 4; i++) {%>
                <tr>
                <%for (int j = 0; j < 4; j++) {%>
                    <td class="cell"><%=gameField.getCell(i, j).getValue()%></td>
                <%}%>
                </tr>
            <%}%>
        </table>
    </div>

    <script src="../../resources/jquery-1.11.3.js"></script>
    <script>
        jQuery(document).bind('keydown', function (evt) {
            var key = evt.which;
            if ([37, 38, 39, 40].indexOf(key) != -1){
                var data = 'key=' + key;
                $.ajax({
                    url: "/game",
                    data: data,
                    type: "POST",
                    acync: true,
                    success: function (response) {
                        var values = response.split(" ");
                        for (var i = 0; i < 16; i++) {
                            document.getElementsByClassName("cell")[i].innerHTML = values[i];
                        }
                        document.getElementById("score").innerHTML = "Score: " + values[16];
                    }
                });
            }
        });
    </script>

    <h3><a href="admin**">Admin</a></h3>

</body>
</html>