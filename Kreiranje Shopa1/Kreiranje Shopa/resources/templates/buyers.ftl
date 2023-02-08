<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buyers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <link rel="stylesheet" href="./css/style.css" />
</head>
<body>
        <div class="container">
            <header>
                <div>
                   <h1 class="header">Buyers Shop</h1>
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

            <#if updateBuyer??>
            <#if updateBuyer =='true'>
                <div class="success_modal">
                        Buyer has been updated!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>

            <#else>
                <div class="error_modal">
                        There was an error updating buyer! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

        </#if>

            <#if saveBuyer??>
            <#if saveBuyer =='true'>
                <div class="success_modal">
                        Buyer has been saved!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>

            <#else>
                <div class="error_modal">
                        There was an error saving buyer! 
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                </div>
            </#if>

            </#if>
                <#if deleteBuyer??>
                <#if deleteBuyer =='true'>
                    <div class="success_modal">
                        Buyer has been deleted!
                        <button class="close_button"
                        onclick="this.parentElement.remove()">&times;</button>
                    </div>
                <#else>
                    <div class="error_modal">
                        There was an error deleting buyer! 
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
                        <th>Buyers First Name</th>
                        <th>Buyers Surname</th>
                        <th>Package</th>
                        <th><a href="/new/buyer" >New</a></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <#list buyers as buyer>
                        <tr>
                            <td>${buyer.buyers_id}</td>
                            <td>${buyer.name}</td>
                            <td>${buyer.surname}</td>
                            <td>${buyer.packages}</td>
                            <td><a href="/buyer/edit/${buyer.buyers_id}">Edit</a></td>
                            <td><a class="delete_buyer_button" data-buyer="${buyer.name}"
                            data-buyerid="${buyer.buyers_id}" href="#">Delete</a></td>
                        </tr>
                </#list>
                </tbody>
                </table>

                <div id="buyer_delete_modal">
                    <p>Do you wish to delete <span id="span_name"></span></p>
                    <a id="link_buyer_delete" href="">Yes</a>
                    <a href="#" onclick="this.parentElement.style.display='none'">No</a>
                </div>
            </main>
    <script>
         const buyer_delete_modal=document.getElementById("buyer_delete_modal")
         const span_name=document.getElementById("span_name")
         const button_delete_buyer=document.getElementsByClassName("delete_buyer_button")
         const link_buyer_delete=document.getElementById("link_buyer_delete")
         for(let btn_delete of button_delete_buyer){
            btn_delete.onclick=()=>{
                const buyer_name=btn_delete.getAttribute("data-buyer")
                const buyer_id=btn_delete.getAttribute("data-buyerid")
                buyer_delete_modal.style.display="block"
                span_name.innerHTML=buyer_name
                link_buyer_delete.setAttribute("href","/buyer/delete/"+buyer_id)
            }
         }
    </script>        
</body>
</html>