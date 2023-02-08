<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sales</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="./css/style.css" />
</head>
<body>
    <div class="container">
            <header>
                <div>
                   <h1 class="header">Sales Shop</h1>
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

             <#if updateSale??>
            <#if updateSale =='true'>
                <div class="success_modal">
                        Sale has been updated!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            <#else>
                <div class="error_modal">
                        There was an error updating sale! Update your package!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>
            <#if saveSale??>
            <#if saveSale =='true'>
                <div class="success_modal">
                        Sale has been saved!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>

            <#else>
                <div class="error_modal">
                        There was an error saving sale! Update your package! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>
            <#if deleteSale??>
            <#if deleteSale =='true'>
                <div class="success_modal">
                        Sale has been deleted!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            <#else>
                <div class="error_modal">
                        There was an error deleting sale! 
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
                            <th>Buyer First Name</th>
                            <th>Buyer Surname</th>
                            <th>Product</th>
                            <th>Date of purchase</th>
                            <th><a href="/sales/new/sale">New</a></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list sales as sale>
                                <tr>
                                    <td>${sale.sales_id}</td>
                                    <td>${sale.buyers.name}</td>
                                    <td>${sale.buyers.surname}</td>
                                    <td>${sale.products.name}</td>
                                    <td>${sale.date_of_purchase}</td>
                                    <td><a href="/sales/sale/edit/${sale.sales_id}">Edit</a></td>
                                    <td><a class="delete_sale_button" 
                                    data-saleid="${sale.sales_id}" href="#">Delete</a></td>
                                </tr>
                        </#list>
                    </tbody>
                </table>

                <div id="sale_delete_modal">
                    <p>Do you wish to delete <span id="span_name"></span></p>
                    <a id="link_sale_delete" href="">Yes</a>
                    <a href="#" onclick="this.parentElement.style.display='none'">No</a>
                </div>
            </main>

        <script>
         const sale_delete_modal=document.getElementById("sale_delete_modal")
         const span_name=document.getElementById("span_name")
         const button_delete_sale=document.getElementsByClassName("delete_sale_button")
         const link_sale_delete=document.getElementById("link_sale_delete")
         for(let btn_delete of button_delete_sale){
            btn_delete.onclick=()=>{
                const sale_id=btn_delete.getAttribute("data-saleid")
                sale_delete_modal.style.display="block"
                span_name.innerHTML=sale_id
                link_sale_delete.setAttribute("href","/sales/sale/delete/"+sale_id)
            }
         }
    </script>         
</body>
</html>