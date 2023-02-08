<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="./css/style.css" />
</head>
<body>
        <div class="container">
            <header>
                <div>
                   <h1 class="header">Products Shop</h1>
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

        <#if updateProduct??>
            <#if updateProduct =='true'>
                <div class="success_modal">
                        Product has been updated!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            <#else>
                <div class="error_modal">
                        There was an error updating product! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>

        <#if saveProduct??>
            <#if saveProduct =='true'>
                <div class="success_modal">
                        Product has been saved!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>

            <#else>
                <div class="error_modal">
                        There was an error saving product! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>

        <#if deleteProduct??>
            <#if deleteProduct =='true'>
                <div class="success_modal">
                        Product has been deleted!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>

            <#else>
                <div class="error_modal">
                        There was an error deleting product! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>

            <main>
                <table class="buyer_list_table">
                    <thead>
                        <tr>
                            <th>DB ID</th>
                            <th>Products</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Package</th>
                            <th><a href="/products/new/product">New</a></th>
                            <th></th>
                            <th>Photo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list products as product>
                            <tr>
                                <td>${product.products_id}</td>
                                <td>${product.manufacturer}</td>
                                <td>${product.name}</td>
                                <td>${product.price}€</td>
                                <td>${product.packages}</td>
                                <td><a href="/products/product/edit/${product.products_id}">Edit</a></td>
                                <td><a class="delete_product_button" data-product="${product.name}"
                                data-productid="${product.products_id}" href="#">Delete</a></td>
                                <td><img src="${product.photo}"  style="width:72px;height:72px;" alt="${product.photo}"></td>                              
                            </tr>
                        </#list>
                       
                    </tbody>
                </table>
            
                <div id="product_delete_modal">
                    <p>Do you wish to delete <span id="span_name"></span></p>
                    <a id="link_product_delete" href="">Yes</a>
                    <a href="#" onclick="this.parentElement.style.display='none'">No</a>
                </div>
            </main>

    <script>

         const product_delete_modal=document.getElementById("product_delete_modal")
         const span_name=document.getElementById("span_name")
         const button_delete_product=document.getElementsByClassName("delete_product_button")
         const link_product_delete=document.getElementById("link_product_delete")
         for(let btn_delete of button_delete_product){
            btn_delete.onclick=()=>{
                const product_name=btn_delete.getAttribute("data-product")
                const product_id=btn_delete.getAttribute("data-productid")
                product_delete_modal.style.display="block"
                span_name.innerHTML=product_name
                link_product_delete.setAttribute("href","/products/product/delete/"+product_id)
            }
         }
    </script>      
</body>
</html>