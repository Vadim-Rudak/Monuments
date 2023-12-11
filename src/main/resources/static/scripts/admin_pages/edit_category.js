$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    PopUpAddCategoryHide();
    PopUpEditCategoryHide();
});

function PopUpAddCategoryShow(){
    $("#coopPopUpAddCategory").show();
}

function PopUpAddCategoryHide(){
    $("#coopPopUpAddCategory").hide();
}

async function SendInfoToServer(){
    var name = document.getElementById("popUp_add_name").value;
    var category = document.getElementById("popUp_add_category").value;
    var file = document.getElementById("popUp_add_file").files[0];

    var data = new FormData();
    await data.append('name', name);
    await data.append('category', category);
    await data.append('file', file);

    let response = await fetch('/add_in_catalog', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}


function PopUpEditItemCategoryShow(id){
    var name = document.getElementById("item_name_" + id).textContent;
    var category = document.getElementById("category_" + id).textContent;

    document.getElementById('id_elem').value = id;
    document.getElementById('popUp_edit_name').value = name;
    document.getElementById('popUp_edit_category').value = category;

    $("#coopPopUpEditCategory").show();
}

function PopUpEditCategoryHide(){
    $("#coopPopUpEditCategory").hide();
}

async function updateItemCategory(){
    var id = document.getElementById("id_elem").value;
    var name = document.getElementById("popUp_edit_name").value;
    var category = document.getElementById("popUp_edit_category").value;
    var file = document.getElementById("popUp_edit_file").files[0];


    var data = new FormData();
    await data.append('id', id);
    await data.append('name', name);
    await data.append('category', category);
    await data.append('file', file);

    let response = await fetch('/update_item_category', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}


async function deleteItemCategory(id_delete){

    var data = new FormData();
    await data.append('id', id_delete);

    let response = await fetch('/delete_item_catalog', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}