<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container">
        <header>
            <div>
                <h1 class="header">Categories</h1>
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
        
        <form action="/category/new/category" method="post" class="form">
            <div class="mb-3">
                <label class="form-label">Add new category</label>
                <input type="text" name="category" id="category">
            </div>
           
            <div class="mb-3">
                <button class="modal-button" type="submit">Save</button>
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
        function checkedOnClick1(el){
           var checkboxesList = document.getElementsByClassName("checkoption1");
           for (var i = 0; i < checkboxesList.length; i++) {
              checkboxesList.item(i).checked = false;
           }
           el.checked = true; 
        }
    </script>
</body>
</html>