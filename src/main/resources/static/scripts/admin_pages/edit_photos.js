$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    PopUpAddHide();
    PopUpEditHide();
});

function PopUpAddShow(){
    $("#coopPopUpAddPhoto").show();
}

function PopUpAddHide(){
    $("#coopPopUpAddPhoto").hide();
}

async function sendPhotoToServer(){
    var name = document.getElementById("photo_add_name").value;
    var material = document.getElementById("photo_add_material").value;
    var file = document.getElementById("photo_add_file").files[0];

    var data = new FormData();
    await data.append('titel', name);
    await data.append('material', material);
    await data.append('file', file);

    let response = await fetch('/add_photo_work', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}


function PopUpEditShow(id,name,material){
    document.getElementById("photo_edit_id").value = id;
    document.getElementById("photo_edit_name").value = name;
    document.getElementById("photo_edit_material").value = material;
    
    $("#coopPopUpEditPhoto").show();
}

function PopUpEditHide(){
    $("#coopPopUpEditPhoto").hide();
}

async function updatePhotoWork(){
    var id = document.getElementById("photo_edit_id").value;
    var edit_name = document.getElementById("photo_edit_name").value;
    var edit_material = document.getElementById("photo_edit_material").value;
    var edit_file = document.getElementById("photo_edit_file").files[0];
    

    var data = new FormData();
    await data.append('id', id);
    await data.append('titel', edit_name);
    await data.append('material', edit_material);
    await data.append('file', edit_file);

    let response = await fetch('/update_photo_work', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();

}


async function deletePhotoWork(id){

    var data = new FormData();
    await data.append('id', id);

    let response = await fetch('/delete_photo_work', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      location.reload();
}