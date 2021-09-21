<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
   <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    $(function () {
      alert($("#form1 ~ input").val());
    })
  </script>
</head>
<body>
<form id="form1">
  <input type="text">

  <input type="text" value="9">
  <form>
    <input type="text" value="10">
  </form>
  <input type="text" value="11">
</form>
<form>
  <input type="text" value="12">
</form>
</body>
</html>