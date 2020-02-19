<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8" />
    <title>Survey</title>
  </head>
  <body>
    <h1>Some Survey</h1>
    <form action="/subSurvey" method="POST">
      <label for="name">Your name: <input type="text" name="name"/></label
      ><br />
      <label for="location"
        >Location:
        <select name="location" id="location">
          <option value="DC">DC</option>
          <option value="NewYork">New York</option>
          <option value="Miami">Miami</option>
        </select> </label
      ><br/>
      <label for="language"
        >Language:
        <select name="language" id="language">
          <option value="Java">Java</option>
          <option value="Python">Python</option>
          <option value="MEAN">MEAN</option>
        </select> </label
      ><br />
      <label for="comment">Comment: (optional)</label><br />
      <textarea name="comment" id="comment" cols="40" rows="5"> </textarea><br>
      <button>Submit</button>
    </form>
  </body>
</html>
