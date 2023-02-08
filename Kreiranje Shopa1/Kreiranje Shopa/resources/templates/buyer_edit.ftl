<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Buyer</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container">
        <header>
            <div>
                <h1 class="header">Edit Buyer</h1>
            </div>
        </header>
        <nav>
            <div class="nav" >
                <#list main_menu as item>
                    <li class="nav-item">
                        <a class="nav-link" href="${item.path}">${item.title}</a>
                    </li>
                </#list>
            </div>
        </nav>
        <div>
        <form action="/buyer/edit/${buyer.buyers_id}" method="post" enctype="multipart/form-data" class="form">
            <div class="mb-3 mt-5" >
                <label class="form-label">Name</label>
                <input type="text" name="name" value="${buyer.name}">
            </div>    
            <div class="mb-3">
                <label class="form-label">Surname</label>
                <input type="text" name="surname" value="${buyer.surname}">
            </div>
            <div class="mb-3">
                <label class="form-label">E-mail</label>
                <input type="text" name="email" value="${buyer.email}">
            </div>
            <div class="mb-3">
                <label class="form-label">Package</label>
                <input  type="checkbox" class="checkoption" name="packages" id="standard" value="STANDARD" onclick="checkedOnClick(this);">STANDARD
                <input type="checkbox" class="checkoption" name="packages" id="premium" value="PREMIUM" onclick="checkedOnClick(this);">PREMIUM
            </div>
            <div class="mb-3">
                <button class="modal-button" type="submit">Edit</button>
            </div>    
        </form>   
    </div>

    <script >
        function checkedOnClick(el){
     
           
           var checkboxesList = document.getElementsByClassName("checkoption");
           for (var i = 0; i < checkboxesList.length; i++) {
              checkboxesList.item(i).checked = false;
           }
     
           el.checked = true; 
        }
    </script>
</body>
</html>