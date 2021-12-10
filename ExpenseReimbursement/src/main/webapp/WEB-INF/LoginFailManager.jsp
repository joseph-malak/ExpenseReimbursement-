<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

     <style>
            body{
            background-color: #666699;
            }


        </style>
    </head>
    <body>
    <form action="FinancialManagerServlet" method = "post">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">

                    <div class="card bg-dark text-white" style="border-radius: 8rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text">Financial Manager Login</h2>
                                <p class="text-white-50 mb-5">Please enter your Username and password</p>

                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="username" class="form-control form-control-lg" />
                                    <label class="form-label" for="username">Username</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="password" class="form-control form-control-lg" />
                                    <label class="form-label" for="password">Password</label>
                                </div>

                                <button class="btn btn-outline-primary btn-lg px-10" type="submit">Login</button>

                            </div>
                                         <p>${message}</p>
                            <div>
                                <p class="mb-0">Employees<a href="EmployeeLogin.html" class="text-white-50 fw-bold"> Click here</a></p>
                            </div>

                        </div>
                    </div>
            </div>
        </div>
    </section>
    </form>

    </body>
    </html>