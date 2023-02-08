<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Sale</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container">
        <header>
            <div>
                <h1 class="header">New Sale</h1>
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
        
        <form action="/sales/new/sale" method="post" class='form' >
            <div class="mb-3 mt-3">
                <label class="form-label">Buyers</label>
                <select name="buyer" id="buyer-select">
                    <#list buyers as buyer>
                    <option  value="${buyer.buyers_id}">${buyer.name} ${buyer.surname}</option>
                    </#list>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Products</label>
                <select name="product" id="product-select">
                    <#list products as product>
                    <option  value="${product.products_id}">${product.name}</option>
                    </#list>
                </select>
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