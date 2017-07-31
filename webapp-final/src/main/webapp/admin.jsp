<html>
    <head>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <body>
        <style>
            h1
            {
                font-family: "Brush Script MT", cursive;
                color: brown;
                padding-top:40px;
                padding-bottom: 20px;
                text-align: center;
            }
            label{
                font-size: 17px;
                font-family: "Brush Script MT", cursive;
                text-align: center;
                margin-left:500px;
                padding-bottom: 10px;

            }
            .but{
            margin-left: 750px;
            margin-bottom:10px;
            }
            .ex
            {
                font-family:"Brush Script MT", cursive;
                font-size: 16px;
                margin-left:550px;
                color:#2d5991;
            }
        
           
            </style>
        <form action="/login" method="POST">
        <h1>HOME PAGE</h1>
            <label>Username:<input type="text" placeholder="username" name="username"></label></br>
            <label>Password :<input type="password" placeholder="password" name="password"></label></br>
                           

 <h2 class="ex">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Existing User-><button type="submit" class="btn btn-primary glyphicon glyphicon-user">Login</button></h2>  
   </form>
<h2 class="ex">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New User-><a href="new_user.jsp" target="_blank"><button class="btn btn-success glyphicon glyphicon-thumbs-up">SignUp</button></a></h2>  
               
               

         
        </body>
        </head>
    </html>
