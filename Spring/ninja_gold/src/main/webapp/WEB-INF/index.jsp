<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" type="text/css" href="css/style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="page">
      <h1>Ninja Gold <span id="version">2.0</span></h1>
      <p>Made with Java</p>
      <h3>Your Gold:
          <span>$</span>
          <span>{{ request.session.yourGold }}</span>
      </h3>
      <div class="location">
          <h3>Farm</h3>
          <p>(earn 10-20 gold)</p>
          <form action="/process_gold/farm" method="post">
              <input type="hidden" name="location" value="farm">
              <input class="butn" type="submit" value="Find Gold!">
          </form>
      </div>
      <div class="location">
          <h3>Cave</h3>
          <p>(earn 5-10 gold)</p>
          <form action="/process_gold/cave" method="post">
              <input type="hidden" name="location" value="cave">
              <input class="butn" type="submit" value="Find Gold!">
          </form>
      </div>
      <div class="location">
          <h3>House</h3>
          <p>(earn 2-5 gold)</p>
          <form action="/process_gold/house" method="post">
              <input type="hidden" name="location" value="house">
              <input class="butn" type="submit" value="Find Gold!">
          </form>
      </div>
      <div class="location">
          <h3>Casino</h3>
          <p>(earn/takes 0-50 gold)</p>
          <form action="/process_gold/casino" method="post">
              <input type="hidden" name="location" value="casino">
              <input class="butn" type="submit" value="Find Gold!">
          </form>
      </div>
      <h3>Activities</h3>
      <div id="activities">
          {% for x in request.session.activity reversed %}
              {% if x.lost == False %}
                  <p class="earn">{{ x.message }}</p>

              {% else %}
                  <p class="lost">{{ x.message }}</p>
              {% endif %}

          {% endfor %}


      </div>
  </div>

</body>
</html>
