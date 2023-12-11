$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    PopUpAddHide();
    PopUpEditHide();
    PopUpDeleteHide();
});

function PopUpAddShow(){
    $("#coopPopUp").show();
}

function PopUpAddHide(){
    $("#coopPopUp").hide();
}


function PopUpEditShow(id){
    var name1 = document.getElementById("card_name_material_" + id).textContent;
    var info1 = document.getElementById("card_info_material_" + id).textContent;

    document.getElementById('material_edit_id').value = id;
    document.getElementById('edit_material_name').value = name1;
    document.getElementById('edit_material_info').value = info1;


    $("#popUpEditMaterial").show();
}

function PopUpEditHide(){
    $("#popUpEditMaterial").hide();
}

function PopUpDeleteShow(id){
    document.getElementById("material_delete_id").value = id;
    $("#popUpDeleteMaterial").show();
}

function PopUpDeleteHide(){
    $("#popUpDeleteMaterial").hide();
}

async function addMaterial(){
    var name = document.getElementById("material_name").value;
    var info = document.getElementById("material_info").value;
    var file = document.getElementById("material_photo").files[0];


    var data = new FormData();
    await data.append('name', name);
    await data.append('info', info);
    await data.append('file', file);

    let response = await fetch('/add_material', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();


}

async function deleteMaterial(){
    var id_delete = document.getElementById("material_delete_id").value;

    var data = new FormData();
    await data.append('id', id_delete);

    let response = await fetch('/delete_material', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}

async function updateMaterial(){
    var id = document.getElementById("material_edit_id").value;
    var name = document.getElementById("edit_material_name").value;
    var info = document.getElementById("edit_material_info").value;
    var file = document.getElementById("edit_material_photo").files[0];


    var data = new FormData();
    await data.append('id', id);
    await data.append('name', name);
    await data.append('info', info);
    await data.append('file', file);

    let response = await fetch('/update_material', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}