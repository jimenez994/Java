<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ninja Gold</title>
    <link rel="stylesheet" href="css/main.css" />

    <link rel="stylesheet" href="../../resources/static/css/main.css" />
  </head>
  <body>
    <main>
      <h2 id="gold">
        Your Gold: <span><div id="coins">&dollar;${coins}</div> </span>
      </h2>
      <div class="places">
        <div class="location" id="farm">
          <form action="/play" method="POST">
            <div class="ln-loc">
              <h2>Farm</h2>
              <p>&lpar;earn 10-20 gold&rpar;</p>
              <input type="hidden" name="input" value="farm" />
              <button class="btn-findG">Find Gold!</button>
            </div>
            <button class="flex-btn">
              <h2>Farm</h2>
              <p>&lpar;earn 10-20 gold&rpar;</p>
            </button>
          </form>
				</div>
				<div class="location" id="cave">
          <form action="/play" method="POST">
            <div class="ln-loc">
              <h2>Cave</h2>
              <p>&lpar;earn 5-10 gold&rpar;</p>
              <input type="hidden" name="input" value="cave" />
              <button class="btn-findG">Find Gold!</button>
            </div>
            <button class="flex-btn">
              <h2>Farm</h2>
              <p>&lpar;earn 10-20 gold&rpar;</p>
            </button>
          </form>
				</div>
				<div class="location" id="house">
          <form action="/play" method="POST">
            <div class="ln-loc">
              <h2>House</h2>
              <p>&lpar;earn 2-5 gold&rpar;</p>
              <input type="hidden" name="input" value="house" />
              <button class="btn-findG">Find Gold!</button>
            </div>
            <button class="flex-btn">
              <h2>house</h2>
              <p>&lpar;earn 10-20 gold&rpar;</p>
            </button>
          </form>
        </div>
				<div class="location" id="casino">
          <form action="/play" method="POST">
            <div class="ln-loc">
              <h2>Casino</h2>
              <p>&lpar;earn+- 0-50 gold&rpar;</p>
              <input type="hidden" name="input" value="casino" />
              <button class="btn-findG">Find Gold!</button>
            </div>
            <button class="flex-btn">
              <h2>casino</h2>
              <p>&lpar;earn 10-20 gold&rpar;</p>
            </button>
          </form>
        </div>
      </div>
      <h3 id="subtitle-act">Activity:</h3>
      <div id="activity">
        ${activities}
      </div>
      <a href="/reset" class="btn-reset"><button>reset</button></a>
    </main>
  </body>
</html>
