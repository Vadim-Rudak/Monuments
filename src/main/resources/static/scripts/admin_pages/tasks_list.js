$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    PopUpAddElementHide();
    PopUpEditElementHide();
});

function PopUpAddElementShow(type){
    var input_name = document.getElementById("popUp_name");
    var input_material = document.getElementById("popUp_material");
    var input_more_info = document.getElementById("popUp_info");
    input_more_info.style.display = "none";
    switch(type){
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
            input_material.style.display = "block";
            input_name.placeholder = "Название памятника";
            break;
        default:
            input_material.style.display = "none";
            input_name.placeholder = "Название";
            break;
    }
    $("#coopPopUpAddElement").show();
    console.log(type)
}

function PopUpAddElementHide(){
    $("#coopPopUpAddElement").hide();
}

async function sendToServer(){
    var num_type = document.getElementById("num_type").value;
    var name = document.getElementById("popUp_name").value;
    var material = document.getElementById("popUp_material").value;
    var price = document.getElementById("popUp_price").value;
    var info = document.getElementById("popUp_info").value;
    var photo_file = document.getElementById("popUp_file").files[0];
    console.log(num_type);
    console.log("F");

    var bodyFormData = new FormData();
    await bodyFormData.append('type', num_type);
    await bodyFormData.append('name', name);
    await bodyFormData.append('material', material);
    await bodyFormData.append('price', price);
    await bodyFormData.append('info', info);
    await bodyFormData.append('file', photo_file);
    sendDataToServer(bodyFormData);
    

}


async function sendDataToServer(data){

    let response = await fetch('/add_element', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();
}

function PopUpEditElementShow(){
    $("#coopPopUpEditElement").show();
}

function PopUpEditElementHide(){
    $("#coopPopUpEditElement").hide();
}


function updateElement(id,titel,type,material,price){
    var input_name = document.getElementById("popUp_edit_name");
    input_name.value = titel;
    var input_material = document.getElementById("popUp_edit_material");
    input_material.value = material;
    var input_price = document.getElementById("popUp_edit_price");
    input_price.value = price;
    var input_more_info = document.getElementById("popUp_edit_info");
    input_more_info.style.display = "none";
    PopUpEditElementShow();

    switch(type){
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
            input_material.style.display = "block";
            // input_name.placeholder = "Название памятника";
            break;
        default:
            input_material.style.display = "none";
            // input_name.placeholder = "Название";
            break;
    }

    popUp_edit_material

}

function updateElementInServer(){
    
 

}


async function deleteElement(id,type){

    var data = new FormData();
    await data.append('id', id);
    await data.append('type', type);
    

    let response = await fetch('/delete_element', {
        method: 'POST',
        body: data
    });
  
    //   let result = await response.json();
    //   console.log(result);
      location.reload();

}